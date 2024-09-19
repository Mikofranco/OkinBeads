package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.data.models.Admin;
import org.example.data.models.Product;
import org.example.data.models.Role;
import org.example.data.models.User;
import org.example.data.repo.AdminRepo;
import org.example.data.repo.ProductRepo;
import org.example.data.repo.UserRepo;
import org.example.dto.request.*;
import org.example.dto.response.AddProductResponse;
import org.example.dto.response.AdminLoginResponse;
import org.example.dto.response.LoginUserResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AdminServices  implements AdminService{

    private final AdminRepo adminRepo;
    private  final ProductRepo productRepo;
    private final  UserRepo userRepo;
    private final ProductService productService;

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
        Admin admin = adminRepo.findById(request.getAdminId()).orElseThrow(()-> new RuntimeException("Admin not found"));
        Product product = new Product();
        product.setAmount(request.getAmount());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setImageUrl(request.getImageUrl());
        product.setCategory(request.getCategory());
        product.setUploader(admin);
        var  savedProduct = productRepo.save(product);

        AddProductResponse response = new AddProductResponse();
        response.setMessage("Product added successfully!");
        response.setProductId(savedProduct.getId());
        return response;
    }

    @Override
    public void deleteProduct(DeleteProductRequest request) {
        productService.deleteProduct(request.getProductId());
    }

    @Override
    public Product updateProduct(UpdateProductRequest request) {
        var existingProduct = productService.getSingleProduct(request.getProductId());
        if(request.getAmount() != null){
            existingProduct.setAmount(BigDecimal.valueOf(request.getAmount()));
        }
        if(request.getName() != null){
            existingProduct.setName(request.getName());
        }
        if (request.getDescription() != null){
            existingProduct.setDescription(request.getDescription());
        }
        if (request.getImageUrl() != null){
            existingProduct.setImageUrl(request.getImageUrl());
        }
        if (request.getCategory() != null){
            existingProduct.setCategory(request.getCategory());
        }
        return productRepo.save(existingProduct);
    }
}
