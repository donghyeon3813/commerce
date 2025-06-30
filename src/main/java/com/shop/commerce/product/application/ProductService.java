package com.shop.commerce.product.application;

import com.shop.commerce.product.domain.Product;
import com.shop.commerce.product.presentation.dto.ProductDto;
import com.shop.commerce.product.presentation.dto.ProductRequest;
import com.shop.commerce.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream().map(ProductDto::from).toList();
    }
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow();
    }
}
