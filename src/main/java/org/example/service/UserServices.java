package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.data.models.*;
import org.example.data.repo.CommentRepo;
import org.example.data.repo.LikeRepo;
import org.example.data.repo.ProductRepo;
import org.example.data.repo.UserRepo;
import org.example.dto.request.CommentRequest;
import org.example.dto.request.LikeRequest;
import org.example.dto.request.LoginUserRequest;
import org.example.dto.request.RegisterUserRequest;
import org.example.dto.response.CommentResponse;
import org.example.dto.response.LikeResponse;
import org.example.dto.response.LoginUserResponse;
import org.example.dto.response.RegisterUserResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServices  implements UserService{
    private final UserRepo userRepo;
    private final ProductRepo productRepo;
    private final LikeRepo likeRepo;
    private final CommentRepo commentRepo;

    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {
        User user = new User();
        user.setRole(Role.User);
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        var newUser =userRepo.save(user);
        if(newUser != null){
            return RegisterUserResponse.builder()
                    .message("Registration successful")
                    .username(newUser.getUsername())
                    .build();
        }
        throw new RuntimeException("Reistration failed");
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

    @Override
    public LikeResponse likeProduct(LikeRequest request) {
       var user = getUser(request);
       var product = getProduct(request);
       Likes like = new Likes();
       like.setUser(user);
       like.setProduct(product);
       var savedLike = likeRepo.save(like);
       if(savedLike != null){
           return LikeResponse.builder()
                   .likeId(savedLike.getId())
                   .build();
       }else{
           throw new RuntimeException("like not successful");
       }
    }

    private Product getProduct(LikeRequest request) {
        return productRepo.findById(request.getProductId()).orElseThrow(() -> new RuntimeException("Product not available"));
    }

    private User getUser(LikeRequest request) {
        return userRepo.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public CommentResponse commentOnProduct(CommentRequest request) {
        var product =productRepo.findById(request.getProductId()).orElseThrow(() -> new RuntimeException("Product not available"));
        var commenter =userRepo.findById(request.getCommenterId()).orElseThrow(() -> new RuntimeException("User not found"));

        Comment comment = new Comment();
        comment.setComment(request.getComment());
        comment.setUser(commenter);
        comment.setProduct(product);
        var savedComment = commentRepo.save(comment);
        if(!savedComment.getComment().isEmpty()){
            return CommentResponse.builder()
                    .commenterId(savedComment.getUser().getId())
                    .commenterName(savedComment.getUser().getUsername() + "commented ")
                    .build();
        }else {
            throw new RuntimeException("Comment not successful");
        }
    }
}
