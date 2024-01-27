package org.example.service;

import org.example.data.repo.UserRepo;
import org.example.dto.request.LoginUserRequest;
import org.example.dto.request.RegisterUserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServicesTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;
    @Test
    public void testToRegisterUser(){
        RegisterUserRequest request= new RegisterUserRequest();
        request.setEmail("miko@gmial.com");
        request.setPassword("12345");
        request.setUsername("mikijoe");
        userService.register(request);
        assertThat(userRepo.count(),is(1L));
    }

    @Test
    public void testUserCantRegisterWithUsedEmail(){
        RegisterUserRequest request= new RegisterUserRequest();
        request.setEmail("miko@gmial.com");
        request.setPassword("12345");
        request.setUsername("mikijoe");
        assertThrows(RuntimeException.class,()->userService.register(request));
    }
    @Test
    public void testThatUserCanLogin(){
        LoginUserRequest request =new LoginUserRequest();
        request.setEmail("miko@gmial.com");
        request.setPassword("12345");
        var response =userService.login(request);
        System.out.println(response.getId() +"    "+response.getUsername() +"    "+response.getRole() +"    "+response.getEmail());
        assertThat(response.getUsername(), is("mikijoe"));
    }
    @Test
    public void testToRegisterMultiUsers(){
        RegisterUserRequest request= new RegisterUserRequest();
        request.setEmail("micheal@gmial.com");
        request.setPassword("12345");
        request.setUsername("micheal");
        userService.register(request);

        RegisterUserRequest request1= new RegisterUserRequest();
        request1.setEmail("john@gmial.com");
        request1.setPassword("12345");
        request1.setUsername("john");
        userService.register(request1);

        RegisterUserRequest request2= new RegisterUserRequest();
        request2.setEmail("chidinma@gmial.com");
        request2.setPassword("12345");
        request2.setUsername("chidinma");
        userService.register(request2);

        assertThat(userRepo.count(),is(4L));
    }

}