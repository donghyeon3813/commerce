package com.shop.commerce.product.presentation.dto;

import com.shop.commerce.product.domain.Category;
import com.shop.commerce.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
@AllArgsConstructor
public class ProductDto {
    private Long productId;
    private Category category;
    private String name;
    private BigDecimal price;
    private int stock;

    public static ProductDto from(Product product) {
        return ProductDto.builder()
                .productId(product.getProductUid())
                .category(product.getCategory())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }
}
