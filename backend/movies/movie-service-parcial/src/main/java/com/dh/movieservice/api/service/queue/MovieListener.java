package com.dh.movieservice.api.service.queue;

import com.dh.movieservice.api.service.impl.MovieServiceImpl;
import com.dh.movieservice.domain.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

//@RequiredArgsConstructor
@Component
public class MovieListener {

    private MovieServiceImpl service;

    @RabbitListener(queues = { "${queue.movie.name}" })

    public void receive(@Payload Movie movie) {
        service.save(movie);
    }

}
