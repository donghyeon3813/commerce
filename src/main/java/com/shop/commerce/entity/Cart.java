package com.shop.commerce.entity;

import com.shop.commerce.entity.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "CART")
public class Cart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_KEY")
    private Long cartKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_UID", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_UID", nullable = false)
    private Product product;

    @Column(nullable = true)
    private int quantity;

}
