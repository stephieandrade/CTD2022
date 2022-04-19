package com.dh.catalogservice.api.queue;

import com.dh.catalogservice.domain.model.dto.dto.MovieWS;
import com.dh.catalogservice.domain.repository.MovieFeignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieSender {

    private final MovieFeignRepository client;

    private final RabbitTemplate rabbitTemplate;

    private final Queue movieQueue;

    public void send(MovieWS movie) {
        this.rabbitTemplate.convertAndSend(this.movieQueue.getName(), client.postMovie(movie));
    }

}
