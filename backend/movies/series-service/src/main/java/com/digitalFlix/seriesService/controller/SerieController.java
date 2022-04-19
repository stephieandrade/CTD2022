package com.digitalFlix.seriesService.controller;

import com.digitalFlix.seriesService.model.Serie;
import com.digitalFlix.seriesService.service.ISerieService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/series")
@AllArgsConstructor
public class SerieController {
    private ISerieService serieService;

    @GetMapping("/{genre}")
    public ResponseEntity<List<Serie>> getSeriesByGenre(@PathVariable String genre){
        return ResponseEntity.ok().body(serieService.getSeriesByGenre(genre));
    }

//    @PostMapping
//    public ResponseEntity<Serie> saveSerie(@RequestBody Serie serie){
//        return ResponseEntity.ok().body(serieService.saveSerie(serie));
//    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Serie>> findbyid(@PathVariable String id){
        return ResponseEntity.ok().body(serieService.findById(id));
    }
}
