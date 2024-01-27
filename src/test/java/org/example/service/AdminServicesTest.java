package org.example.service;

import org.example.data.models.User;
import org.example.data.repo.AdminRepo;
import org.example.data.repo.UserRepo;
import org.example.dto.request.AdminLoginRequest;
import org.example.dto.request.RegisterAdminRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdminServicesTest {
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private AdminService adminService;

    @Test
    public void testToRegisterAdmin(){
        RegisterAdminRequest request= new RegisterAdminRequest();
        request.setUsername("okin_beads");
        request.setPassword("12345");
        request.setEmail("mariaThomas@yahoo.com");
        adminService.createAdmin(request);
        assertThat(adminRepo.count(),is(1L));

    }

    @Test
    public void testAdminLogin(){
        AdminLoginRequest user = new AdminLoginRequest();
        user.setPassword("12345");
        user.setEmail("mariaThomas@yahoo.com");
        var admin =adminService.login(user);
        assertThat(admin.getUsername(),is("okin_beads"));
    }

}