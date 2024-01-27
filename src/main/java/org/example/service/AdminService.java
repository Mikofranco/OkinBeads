package org.example.service;

import org.example.data.models.User;
import org.example.dto.request.AddProductRequest;
import org.example.dto.request.AdminLoginRequest;
import org.example.dto.request.RegisterAdminRequest;
import org.example.dto.response.AddProductResponse;
import org.example.dto.response.AdminLoginResponse;

public interface AdminService {
    void createAdmin(RegisterAdminRequest request);
    AdminLoginResponse login(AdminLoginRequest request);
    AddProductResponse addProduct(AddProductRequest request);

}
