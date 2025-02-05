package com.shop.commerce.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ORDER_LINE")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_LINE_UID")
    private Long orderLineUid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDERS_UID", nullable = false)
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_UID", nullable = false)
    private Product product;

    @Column(nullable = true)
    private int quantity;

}
