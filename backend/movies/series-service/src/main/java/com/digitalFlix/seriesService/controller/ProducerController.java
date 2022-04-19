package com.digitalFlix.seriesService.controller;

import com.digitalFlix.seriesService.model.Serie;
import com.digitalFlix.seriesService.service.ISerieService;
import com.digitalFlix.seriesService.service.RabbitMQSender;
import com.digitalFlix.seriesService.service.impl.SerieServiceImpl;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/post/")
public class ProducerController {
    private RabbitMQSender rabbitMqSender;
    private ISerieService service;

    @Autowired
    public ProducerController(RabbitMQSender rabbitMqSender, SerieServiceImpl service) {
        this.rabbitMqSender = rabbitMqSender;
        this.service = service;
    }

    @Value("${app.message}")
    private String message;

    @PostMapping//creates a publishUserDetails()  method annotated with the @PostMapping annotation to map this handler method to a URL named user with the HTTP POST method.
    public String publishUserDetails(@RequestBody Serie serie) {
        service.saveSerie(serie);
        String message1 = "eh campeon lo lograste, posteaste una serie";
        rabbitMqSender.send(message1); //calls the send() method of the RabbitMqSender class accepts a User object to send it to RabbitMQ.
        return message;
    }
}
