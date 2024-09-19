package org.example.service;

import org.example.data.models.Category;
import org.example.data.models.User;
import org.example.data.repo.AdminRepo;
import org.example.data.repo.ProductRepo;
import org.example.data.repo.UserRepo;
import org.example.dto.request.AddProductRequest;
import org.example.dto.request.AdminLoginRequest;
import org.example.dto.request.RegisterAdminRequest;
import org.example.dto.request.UpdateProductRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdminServicesTest {
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private AdminService adminService;
    @Autowired
    private ProductRepo productRepo;

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

    @Test
    public void testToAddProduct(){
        AddProductRequest productRequest = new AddProductRequest();
        productRequest.setAdminId(1L);
        productRequest.setName("Neck cowry bead");
        productRequest.setAmount(BigDecimal.valueOf(120000));
        productRequest.setImageUrl("");
        productRequest.setCategory(Category.BAG);
        productRequest.setDescription("A necklace  made with cowries for the use of customers with touch of perfection");
        adminService.addProduct(productRequest);
        assertThat(productRepo.count(), is(3L));
    }

    @Test
    public void testToUpdateProduct(){
        UpdateProductRequest request = new UpdateProductRequest();
        request.setProductId(1);
        request.setCategory(Category.BAG);
        var product = adminService.updateProduct(request);
        assertThat(product.getCategory(), is(Category.BAG));
    }

}