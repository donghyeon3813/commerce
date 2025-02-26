package com.shop.commerce.product.controller;

import com.shop.commerce.product.dto.ProductRequest;
import com.shop.commerce.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    private ResponseEntity<String> createProduct(@Valid @RequestBody ProductRequest request) {
        log.info("Create product: {}", request);
        try {
            productService.createProduct(request);
        } catch (Exception e){
            log.error(e.getMessage());
        }

        return ResponseEntity.ok("Product created successfully");
    }

}
