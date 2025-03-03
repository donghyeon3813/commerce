package com.shop.commerce.product.dto;

import com.shop.commerce.entity.Category;
import com.shop.commerce.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
@AllArgsConstructor
public class ProductDto {
    private Category category;
    private String name;
    private BigDecimal price;
    private int stock;

    public static ProductDto from(Product product) {
        return ProductDto.builder()
                .category(product.getCategory())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }
}
