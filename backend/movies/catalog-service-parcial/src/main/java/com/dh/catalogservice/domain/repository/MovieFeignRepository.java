package com.dh.catalogservice.domain.repository;

import com.dh.catalogservice.domain.model.dto.MovieWS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="movie-service")
public interface MovieFeignRepository {
    @GetMapping("/movies/{id}")
    MovieWS getMovieDetails(@PathVariable Integer id);

}
