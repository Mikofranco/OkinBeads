package org.example.service;

import org.example.dto.request.LoginUserRequest;
import org.example.dto.request.RegisterUserRequest;
import org.example.dto.response.LoginUserResponse;

public interface UserService {
    void register(RegisterUserRequest request);
    LoginUserResponse login(LoginUserRequest request);
}
