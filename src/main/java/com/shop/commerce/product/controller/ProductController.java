package com.shop.commerce.product.controller;

import com.shop.commerce.product.dto.ProductDto;
import com.shop.commerce.product.dto.ProductRequest;
import com.shop.commerce.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    private ResponseEntity<List<ProductDto>> getProduct() {
        try {
            List<ProductDto> productDtos = getProductServiceProduct();
            return ResponseEntity.ok(productDtos);
        } catch (Exception e) {
            log.error("Error fetching products: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }

    private List<ProductDto> getProductServiceProduct() {
        return productService.getProduct();
    }

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
