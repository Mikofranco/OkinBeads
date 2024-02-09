package org.example.service;

import org.example.data.models.User;
import org.example.dto.request.*;
import org.example.dto.response.AddProductResponse;
import org.example.dto.response.AdminLoginResponse;
import org.example.dto.response.DeleteProductResponse;
import org.example.dto.response.UpdateProductResponse;

public interface AdminService {
    void createAdmin(RegisterAdminRequest request);
    AdminLoginResponse login(AdminLoginRequest request);
    AddProductResponse addProduct(AddProductRequest request);
    DeleteProductResponse deleteProduct(DeleteProductRequest request);
    UpdateProductResponse updateProduct(UpdateProductRequest request);

}
