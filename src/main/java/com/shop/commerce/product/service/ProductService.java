package com.shop.commerce.product.service;

import com.shop.commerce.product.dto.ProductRequest;
import com.shop.commerce.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public void createProduct(ProductRequest request) {

        if (productRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("Product name already exists");
        }
        productRepository.save(request.toEntity());

    }
}
