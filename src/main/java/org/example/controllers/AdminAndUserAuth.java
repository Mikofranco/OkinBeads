package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.request.AdminLoginRequest;
import org.example.dto.request.RegisterAdminRequest;
import org.example.dto.response.AdminLoginResponse;
import org.example.service.AdminService;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AdminAndUserAuth {
    private final AdminService adminService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?>registerAdmin(@RequestBody RegisterAdminRequest request){
        adminService.createAdmin(request);
        return new ResponseEntity<>("Successful", HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<AdminLoginResponse> loginAdmin(@RequestBody AdminLoginRequest request){
        var response =adminService.login(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
