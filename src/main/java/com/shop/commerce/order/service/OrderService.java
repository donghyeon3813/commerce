package com.shop.commerce.order.service;

import com.shop.commerce.order.domain.Dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.shop.commerce.config.RabbitmqConfig.ORDER_EXCHANGE;
import static com.shop.commerce.config.RabbitmqConfig.ORDER_ROUTING_KEY;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final RabbitTemplate rabbitTemplate;

    public void requestOrder(OrderDto orderDto) {

        rabbitTemplate.convertAndSend(ORDER_EXCHANGE, ORDER_ROUTING_KEY, orderDto);
    }
}
