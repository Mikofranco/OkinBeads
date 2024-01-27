package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.data.models.Admin;
import org.example.data.models.Role;
import org.example.data.models.User;
import org.example.data.repo.AdminRepo;
import org.example.data.repo.UserRepo;
import org.example.dto.request.AddProductRequest;
import org.example.dto.request.AdminLoginRequest;
import org.example.dto.request.RegisterAdminRequest;
import org.example.dto.response.AddProductResponse;
import org.example.dto.response.AdminLoginResponse;
import org.example.dto.response.LoginUserResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServices  implements AdminService{
    private final AdminRepo adminRepo;
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
        return null;
    }
}
