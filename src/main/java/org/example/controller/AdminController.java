package org.example.controller;

import org.example.data.models.Product;
import org.example.dto.request.AddProductRequest;
import org.example.dto.response.AddProductResponse;
import org.example.service.AdminService;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<AddProductResponse> addProduct(@RequestBody AddProductRequest request){
        AddProductResponse response = adminService.addProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        var response = productService.getProducts();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
