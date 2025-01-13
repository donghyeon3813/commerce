package com.shop.commerce.order.domain.Dto;

import java.io.Serializable;

public class OrderDto implements Serializable {

    private String productId; // 상품 ID
    private int quantity;     // 주문 수량
    private String userId;    // 유저 ID 또는 이름
}
