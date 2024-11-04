package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.data.models.Cart;
import org.example.data.models.Product;
import org.example.data.repo.CartRepo;
import org.example.data.repo.ProductRepo;
import org.example.data.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService{
    private final CartRepo cartRepo;
    private final UserRepo userRepo;
    private final ProductRepo productRepo;

    @Override
    public Cart addToCart(Long productId, Long userId) {
        var user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        var product = productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        // Check if the user already has a cart
        Cart cart = cartRepo.findByUserIdWithProducts(userId).orElseGet(() -> {
            // If no cart exists, create a new one
            Cart newCart = new Cart();
            newCart.setUser(user);
            return newCart;
        });

        // Initialize product list if it's null
        if (cart.getProducts() == null) {
            cart.setProducts(new ArrayList<>());
        }

        // Add product to the list of products in the cart
        cart.getProducts().add(product);

        return cartRepo.save(cart);
    }

    @Override
    public String removeSingleItemFromCart(Long productId, Long userId) {
        return "";
    }

    @Override
    public Cart getItemsInCart(Long userId) {
        return cartRepo.findByUserId(userId).orElseThrow();
    }
}
