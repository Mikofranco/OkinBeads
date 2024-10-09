package org.example.service;

import org.example.data.models.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    Product add(BigDecimal amount, String name, String description, String imgUrl);
    void deleteProduct(Long id);
    Product updateDescription(Long id);
    List<Product> getProducts();
    Product getSingleProduct(long productId);

}
