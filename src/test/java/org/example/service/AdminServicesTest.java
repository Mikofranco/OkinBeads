package org.example.service;

import org.example.data.repo.AdminRepo;
import org.example.data.repo.ProductRepo;
import org.example.dto.request.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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
        AddProductRequest request = new AddProductRequest();
        request.setAdminId(1L);
        request.setName("gold bag");
        request.setAmount(BigDecimal.valueOf(1700));
        request.setDescription("The bag is gold in color and its  supper rugged");
        request.setImageUrl("http://www.checkit.com");
        adminService.addProduct(request);
        assertThat(productRepo.count(),is(5L));
    }
    @Test
    public void testToDeleteProduct(){
        DeleteProductRequest request = new DeleteProductRequest();
        request.setProductId(4);
        request.setAdminId(1);
        adminService.deleteProduct(request);
        assertThat(productRepo.count(),is(4L));
    }
    @Test
    public void testToUpdateProduct(){
        UpdateProductRequest request = new UpdateProductRequest();
        request.setProductId(3);
        request.setAdminId(1);
        var response =adminService.updateProduct(request);
        assertThat(response.getName(),is("gold bag"));

    }

}