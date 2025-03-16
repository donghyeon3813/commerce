package com.shop.commerce.cart.controller;

import com.shop.commerce.cart.dto.CartRequest;
import com.shop.commerce.cart.service.CartService;
import com.shop.commerce.entity.Cart;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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

    @PostMapping
    public ResponseEntity<String> createCart(@RequestBody CartRequest request) {
        try {
            cartService.createCart(request);
        }catch (Exception e) {
            log.error(e.getMessage());
        }

        return ResponseEntity.ok("Successfully created cart.");
    }
}
