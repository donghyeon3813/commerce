package com.shop.commerce.order.domain.Dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class OrderDto {

    private String productId; // 상품 ID
    private int    quantity;     // 주문 수량
}
