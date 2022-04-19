package com.digitalFlix.seriesService.repository;

import com.digitalFlix.seriesService.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ISerieRepository extends MongoRepository<Serie, String> {
    List<Serie> findAllByGenre(String genre);
}
