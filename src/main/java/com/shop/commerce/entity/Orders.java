package com.shop.commerce.entity;

import com.shop.commerce.entity.common.BaseEntity;
import com.shop.commerce.member.domain.Member;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ORDERS")
public class Orders extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDERS_UID")
    private Long ordersUid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_UID", nullable = false)
    private Member member;

    @Column(name = "TOTAL_PRICE", nullable = true, precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Column(name = "STATUS", nullable = false, length = 1)
    private String status = "0"; // 기본값 0 (ORDERED 상태)

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrderLine> orderLines;
}
