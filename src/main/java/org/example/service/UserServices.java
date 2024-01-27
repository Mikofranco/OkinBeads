package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.data.models.Role;
import org.example.data.models.User;
import org.example.data.repo.UserRepo;
import org.example.dto.request.LoginUserRequest;
import org.example.dto.request.RegisterUserRequest;
import org.example.dto.response.LoginUserResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServices  implements UserService{
    private final UserRepo userRepo;
    @Override
    public void register(RegisterUserRequest request) {
        User user = new User();
        user.setRole(Role.User);
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        userRepo.save(user);
    }

    @Override
    public LoginUserResponse login(LoginUserRequest request) {
        User user =userRepo.findByEmail(request.getEmail())
                .orElseThrow(()->  new RuntimeException("User Not found"));
        if(!user.getPassword().equals(request.getPassword()))
            throw new RuntimeException("invalid password");
        return LoginUserResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .id(user.getId())
                .role(user.getRole())
                .build();
    }
}
