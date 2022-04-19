package com.dh.catalogservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitTemplateConfig {

    //This code defines six properties: queue, exchange routingKey, username, password and host.
    // It  also uses the @Value annotation to read the values from the application.yml file.
    @Value("${spring.rabbitmq.queue}")
    private String queue;
    @Value("${spring.rabbitmq.queue2}")
    private String queue2;
    @Value("${spring.rabbitmq.exchange}")
    private String exchange;
    @Value("${spring.rabbitmq.exchange2}")
    private String exchange2;
    @Value("${spring.rabbitmq.routingkey}")
    private String routingKey;
    @Value("${spring.rabbitmq.routingkey2}")
    private String routingKey2;
    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;
    @Value("${spring.rabbitmq.host}")
    private String host;

    @Bean
    Queue queue() {
        return new Queue(queue, true);
    }
    @Bean
    Queue queue2() {
        return new Queue(queue2, true);
    }
    //creates an ExchangeBuilder bean to send a message to the
    // queue whose binding key matches the routing key of the message.
    @Bean
    Exchange myExchange() {
        return ExchangeBuilder.directExchange(exchange).durable(true).build();
    }

    @Bean
    Exchange myExchange2() {
        return ExchangeBuilder.directExchange(exchange2).durable(true).build();
    }

    // creates a Jackson2JsonMessageConverter bean of type
    // MeaasgeConverter to send the message in the JSON format.
    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    //creates a Binding bean by binding the queue, exchange and routingkey.

    @Bean
    Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(myExchange())
                .with(routingKey)
                .noargs();
    }

    @Bean
    Binding binding2() {
        return BindingBuilder
                .bind(queue2())
                .to(myExchange2())
                .with(routingKey2)
                .noargs();
    }
    //creates a CashingConnectionFactory
    // bean of type ConnectionFactory initialized with localhost, username, and password.
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host);
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);
        return cachingConnectionFactory;
    }


    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }
}
