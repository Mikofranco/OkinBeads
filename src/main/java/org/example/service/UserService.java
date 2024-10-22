package org.example.service;

import org.example.dto.request.CommentRequest;
import org.example.dto.request.LikeRequest;
import org.example.dto.request.LoginUserRequest;
import org.example.dto.request.RegisterUserRequest;
import org.example.dto.response.CommentResponse;
import org.example.dto.response.LikeResponse;
import org.example.dto.response.LoginUserResponse;
import org.example.dto.response.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse register(RegisterUserRequest request);
    LoginUserResponse login(LoginUserRequest request);
    LikeResponse likeProduct(LikeRequest request);
    CommentResponse commentOnProduct(CommentRequest request);
}
