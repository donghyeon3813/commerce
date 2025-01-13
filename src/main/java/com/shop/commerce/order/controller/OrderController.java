package com.shop.commerce.order.controller;

import com.shop.commerce.order.domain.Dto.OrderDto;
import com.shop.commerce.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor

public class OrderController {
    private final OrderService orderService;
    @PostMapping
    public void requestOrder(@RequestBody OrderDto orderDto){
        try {
            orderService.requestOrder(orderDto);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
