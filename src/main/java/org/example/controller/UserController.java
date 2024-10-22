package org.example.controller;

import org.example.dto.request.LikeRequest;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buyer")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/likeProduct")
    public ResponseEntity<?> likeProduct(LikeRequest request){
        var likeResponse = userService.likeProduct(request);
        return ResponseEntity.status(HttpStatus.OK).body(likeResponse);
    }
}
