package com.dh.movieservice.api.service;

import com.dh.movieservice.domain.model.Movie;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // sets the exchange and routingkey fields with the values from the application.yml file.
    @Value("${spring.rabbitmq.exchange}")
    private String exchange;
    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    public void send(String message1) {
        rabbitTemplate.convertAndSend(exchange, routingkey, message1);
    }
//    public void send(Movie movie){  //defines the send() method that calls the convertAndSend() method of the RabbitTemplate class and sets exchange routing user to it. This convertAndSend() method then pushes the message to exchange with the specified routingkey.
//        rabbitTemplate.convertAndSend(exchange,routingkey, movie);
//    }

}
