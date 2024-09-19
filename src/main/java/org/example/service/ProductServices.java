package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.data.models.Product;
import org.example.data.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServices implements ProductService {
    private final ProductRepo productRepo;
    @Override
    public Product add(BigDecimal amount, String name, String description, String imgUrl) {
        Product product = new Product();
        product.setAmount(amount);
        product.setName(name);
        product.setDescription(description);
        product.setImageUrl(imgUrl);
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        var product =productRepo.findById(id).orElseThrow(()-> new RuntimeException("Item not found"));
        productRepo.delete(product);
    }

    @Override
    public Product updateDescription(Long id) {
        var product =productRepo.findById(id).orElseThrow(()-> new RuntimeException("Item not found"));
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return  productRepo.findAll();
    }

    @Override
    public Product getSingleProduct(long productId) {
        return productRepo.findById(productId).orElseThrow(()-> new RuntimeException("Product not found"));
    }
}
