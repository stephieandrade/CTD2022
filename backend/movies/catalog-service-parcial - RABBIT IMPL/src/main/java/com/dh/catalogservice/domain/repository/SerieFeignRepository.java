package com.dh.catalogservice.domain.repository;

import com.dh.catalogservice.domain.model.dto.dto.MovieWS;
import com.dh.catalogservice.domain.model.dto.dto.SerieWS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="series-service") //registro el cliente
public interface SerieFeignRepository {
    @GetMapping("/series/{genre}")
    List<SerieWS> getSeriesByGenre(@RequestParam String genre);
}
