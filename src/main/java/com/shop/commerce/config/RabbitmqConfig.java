package com.shop.commerce.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    public static final String ORDER_QUEUE       = "order.queue";
    public static final String ORDER_EXCHANGE    = "order.exchange";
    public static final String ORDER_ROUTING_KEY = "order.routingKey";

    // Queue를 생성해주는 Bean
    @Bean
    public Queue orderQueue() {

        return new Queue(ORDER_QUEUE, true);
    }

    // Exchange를 생성해주는 Bean
    @Bean
    public DirectExchange orderExchange() {

        return new DirectExchange(ORDER_EXCHANGE);
    }

    // Exchange와 Queue를 binding 시켜주는 Bean
    @Bean
    public Binding orderBinding(Queue orderQueue, DirectExchange orderExchange) {

        return BindingBuilder.bind(orderQueue).to(orderExchange).with(ORDER_ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {

        return new Jackson2JsonMessageConverter();
    }

    @Bean //RabbitTemplate 커스텀
    public RabbitTemplate rabbitTemplate(
            ConnectionFactory connectionFactory) {// Bean이 정의되어 있지 않으면 자동으로 생성된 ConnectionFactory를 주입받는다.

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
//    SimpleMessageListenerContainer를 통해 옵션이나 message를 읽었을 때 공통 처리를 수행할 수 있다.
//    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        return container;
//    }

}
