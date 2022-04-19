package com.digitalFlix.seriesService.service.impl;

import com.digitalFlix.seriesService.model.Serie;
import com.digitalFlix.seriesService.repository.ISerieRepository;
import com.digitalFlix.seriesService.service.ISerieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SerieServiceImpl implements ISerieService {

    private ISerieRepository serieRepository;

    @Override
    public List<Serie> getSeriesByGenre(String genre) {
        return serieRepository.findAllByGenre(genre);
    }

    @Override
    public Serie saveSerie(Serie serie) {
        return serieRepository.save(serie);
    }

    @Override
    public Optional<Serie> findById(String id) {
        return serieRepository.findById(id);
    }
}