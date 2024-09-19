package org.example.service;

import org.example.data.models.Product;
import org.example.data.models.User;
import org.example.dto.request.*;
import org.example.dto.response.AddProductResponse;
import org.example.dto.response.AdminLoginResponse;

import java.util.List;

public interface AdminService {
    void createAdmin(RegisterAdminRequest request);
    AdminLoginResponse login(AdminLoginRequest request);
    AddProductResponse addProduct(AddProductRequest request);
    void deleteProduct(DeleteProductRequest request);
    Product updateProduct(UpdateProductRequest request);
}
