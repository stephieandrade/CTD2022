package com.dh.movieservice.api.controller;

import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.api.service.RabbitMQSender;
import com.dh.movieservice.domain.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/")
public class ProducerController {
    private RabbitMQSender rabbitMqSender;
    private MovieService movieService;

    public ProducerController(RabbitMQSender rabbitMqSender, MovieService movieService) {
        this.rabbitMqSender = rabbitMqSender;
        this.movieService = movieService;
    }

    @Value("${app.message}")
    private String message;

    @PostMapping(value = "movies") //creates a publishUserDetails()  method annotated with the @PostMapping annotation to map this handler method to a URL named user with the HTTP POST method.
    public String publishUserDetails(@RequestBody Movie movie) {
        movieService.save(movie);
        String message1 = "eh wacho lo lograste, posteaste una movie";
        rabbitMqSender.send(message1); //calls the send() method of the RabbitMqSender class accepts a User object to send it to RabbitMQ.
        return message;
    }
}
