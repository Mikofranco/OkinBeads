package org.example.service;

import org.example.data.models.Product;
import org.example.data.repo.ProductRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class ProductServicesTest {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductService productService;

    @Test
    public void testToAddProduct(){
        var product =productService.add(BigDecimal.valueOf(1000), "bead bag", "made for more and elegant beauty", "http://somthing.url");
        assertThat(productRepo.count(),is(1L));
    }

    @Test
    public void testToAddMultiProduct(){
        productService.add(BigDecimal.valueOf(4000), "Gold bag", "made for more and class", "http://somthing.url");
        productService.add(BigDecimal.valueOf(9000), "bead hat", "made for more and elegant okinGlobal", "http://somthing.url");
        assertThat(productRepo.count(),is(3L));
    }

}