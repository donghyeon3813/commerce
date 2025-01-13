package com.shop.commerce.order.service;

import com.shop.commerce.order.domain.Dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final RabbitTemplate rabbitTemplate;
    public void requestOrder(OrderDto orderDto) {
        rabbitTemplate.convertAndSend("order.exchange", "order.routing.key", orderDto);
    }
}
