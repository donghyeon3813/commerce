package com.shop.commerce.product.dto;

import com.shop.commerce.entity.Category;
import com.shop.commerce.entity.Product;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
public class ProductRequest {
    @NotNull(message = "카테고리는 필수입니다.")
    private Category category;

    @NotNull(message = "상품 이름은 필수입니다.")
    @Size(max = 255, message = "상품 이름은 최대 255자까지 가능합니다.")
    private String name;

    @NotNull(message = "상품 가격은 필수입니다.")
    @Positive(message = "상품 가격은 0보다 커야 합니다.")
    private BigDecimal price;

    @Positive(message = "상품 재고는 0 이상이어야 합니다.")
    private int stock;

    public Product toEntity(){
        return Product.createProduct(category, name, price, stock);
    }
}
