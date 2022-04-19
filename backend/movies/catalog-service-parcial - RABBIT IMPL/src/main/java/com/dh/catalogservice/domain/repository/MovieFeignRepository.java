package com.dh.catalogservice.domain.repository;

import com.dh.catalogservice.domain.model.dto.dto.MovieWS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="movie-service") //registro el cliente
public interface MovieFeignRepository {
    @PostMapping
    Object postMovie(@RequestBody MovieWS movie);
    @GetMapping("/movies/{id}")
    MovieWS getMovieById(@RequestParam Integer id, Boolean throwError);
    @GetMapping("/movies/genre/{genre}")
    List<MovieWS> getMoviesByGenero(@RequestParam String genre);


}
