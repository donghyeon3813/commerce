package com.shop.commerce.entity;

import com.shop.commerce.entity.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PAYMENT")
public class Payment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENT_ID")
    private Long paymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_UID", nullable = false)
    private Orders orders;

    @Column(nullable = true, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(nullable = true, length = 50)
    private String method;

    @Column(nullable = true, length = 20)
    private String status;

}

