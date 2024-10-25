package org.example.service;

import org.example.data.models.Cart;

import java.util.List;

public interface CartService {
    Cart addToCart(Long productId, Long userId);
    String  removeSingleItemFromCart(Long productId, Long userId);
    Cart  getItemsInCart(Long userId);
}
