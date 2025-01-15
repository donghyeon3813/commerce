package com.shop.commerce.order.listener;

import com.shop.commerce.order.domain.Dto.OrderDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.shop.commerce.config.RabbitmqConfig.ORDER_QUEUE;

@Component
public class OrderListener {
    @RabbitListener(queues = ORDER_QUEUE)
    public void orderConsume(OrderDto orderDto){

        System.out.println("orderDto = " + orderDto.getProductId());
    }
}
