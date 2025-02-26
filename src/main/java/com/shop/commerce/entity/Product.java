package com.shop.commerce.entity;

import com.shop.commerce.entity.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "PRODUCT")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_UID")
    private Long productUid;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column
    private int stock;

    @Builder
    public Product(Category category, String name, BigDecimal price, int stock) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public static Product createProduct(Category category, String name, BigDecimal price, int stock){
        return new ProductBuilder().category(category).name(name).price(price).stock(stock).build();
    }
}

