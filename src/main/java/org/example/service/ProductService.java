package org.example.service;

import org.example.data.models.Product;

import java.math.BigDecimal;

public interface ProductService {
    Product add(BigDecimal amount, String name, String description, String imgUrl);
    void deleteProduct(Long id);
    Product updateDescription(Long id);
}
