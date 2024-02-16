package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.request.AddProductRequest;
import org.example.dto.response.AddProductResponse;
import org.example.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    private final AdminService adminService;

    @PostMapping("addProduct")
    public ResponseEntity<AddProductResponse> addProduct(AddProductRequest request){
        var response = adminService.addProduct(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
