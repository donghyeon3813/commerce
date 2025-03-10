package com.shop.commerce.cart.controller;

import com.shop.commerce.cart.service.CartService;
import com.shop.commerce.entity.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts() {
        List<Cart> allCarts = cartService.getAllCarts();
        return ResponseEntity.ok(allCarts);
    }
}
