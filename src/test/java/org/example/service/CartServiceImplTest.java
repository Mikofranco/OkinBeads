package org.example.service;

import org.example.data.repo.CartRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CartServiceImplTest {

    @Autowired
    private CartService cartService;
    @Autowired
    private CartRepo cartRepo;

    @Test
    public void testAddToCart(){
        cartService.addToCart(5L,1L);
        assertEquals(1L, cartRepo.count());
    }

    @Test
    public void testToThrowExceptionWhenSameProductIsAdded(){
        cartService.addToCart(3L,2L);
        assertEquals(1L, cartRepo.count());
    }

}