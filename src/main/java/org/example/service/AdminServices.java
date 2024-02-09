package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.data.models.Admin;
import org.example.data.models.Product;
import org.example.data.models.Role;
import org.example.data.repo.AdminRepo;
import org.example.data.repo.ProductRepo;
import org.example.dto.request.*;
import org.example.dto.response.*;
import org.example.exception.InvalidUserId;
import org.example.exception.UnableToDelete;
import org.example.exception.UnableToUpdateProduct;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServices  implements AdminService{
    private final AdminRepo adminRepo;
    private final ProductService productService;
    private  final ProductRepo productRepo;
    @Override
    public void createAdmin(RegisterAdminRequest request) {
        Admin admin = new Admin();
        admin.setRole(Role.Admin);
        admin.setEmail(request.getEmail());
        admin.setUsername(request.getUsername());
        admin.setPassword(request.getPassword());
        adminRepo.save(admin);
    }

    @Override
    public AdminLoginResponse login(AdminLoginRequest request) {
        Admin user =adminRepo.findByEmail(request.getEmail())
                .orElseThrow(()->  new RuntimeException("User Not found"));
        if(!user.getPassword().equals(request.getPassword()))
            throw new RuntimeException("invalid password");
        return AdminLoginResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .id(user.getId())
                .role(user.getRole())
                .build();
    }

    @Override
    public AddProductResponse addProduct(AddProductRequest request) {
      var admin = adminRepo.findById(request.getAdminId()).orElseThrow(()-> new InvalidUserId("Invalid User Id"));
        Product product=productService.add(request.getAmount(), request.getName(), request.description, request.getImageUrl());
        product.setUploader(admin);
        var savedProduct =productRepo.save(product);
       return AddProductResponse.builder()
                .productId(savedProduct.getId())
                .name(savedProduct.getName())
                .imageUrl(savedProduct.getImageUrl())
                .amount(savedProduct.getAmount())
                .build();
    }

    @Override
    public DeleteProductResponse deleteProduct(DeleteProductRequest request) {
        var admin = adminRepo.findById(request.getAdminId()).orElseThrow(()-> new InvalidUserId("Invalid User Id"));
        var product = productRepo.findById(request.getProductId()).orElseThrow();
        if(!product.getUploader().getId().equals(admin.getId()))
            throw new UnableToDelete("Unable to delete Product ");
        productRepo.delete(product);
        return DeleteProductResponse.builder()
                .productId(product.getId())
                .build();
    }

    @Override
    public UpdateProductResponse updateProduct(UpdateProductRequest request) {
        var admin = adminRepo.findById(request.getAdminId()).orElseThrow(()-> new InvalidUserId("Invalid User Id"));
        var product = productRepo.findById(request.getProductId()).orElseThrow(()-> new UnableToUpdateProduct("Unable to update product"));
//
//        if(!admin.getId().equals(product.getUploader().getId())) {
//            throw  new InvalidUserId("Invalid user Id");
//        }
        if (!request.getName().isEmpty())
            product.setName(request.getName());
        if (!request.getDescription().isEmpty())
            product.setDescription(request.getDescription());
        if (request.getAmount() != null)
            product.setAmount(request.getAmount());
        if (!request.getImageUrl().isEmpty())
            product.setImageUrl(request.getImageUrl());

        var updatedProduct =productRepo.save(product);
        return  UpdateProductResponse.builder()
                .amount(updatedProduct.getAmount())
                .productId(updatedProduct.getId())
                .name(updatedProduct.getName())
                .description(updatedProduct.getDescription())
                .imageUrl(updatedProduct.getImageUrl())
                .build();
    }
}
