package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.dto.dto.MovieWS;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqService implements RabbitListenerConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqService.class);



    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(String message) {
        logger.info("You have been sent this message.. " + message);
    }
    @RabbitListener(queues = "${spring.rabbitmq.queue2}")
    public void receivedMessage2(String message) {
        logger.info("You have been sent this message.. " + message);
    }

}
