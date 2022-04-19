package com.dh.movieservice.api.controller;

import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.domain.model.Movie;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequiredArgsConstructor
@RefreshScope
@RequestMapping("/movies")
public class MovieController {
	private MovieService movieService;
	private final CircuitBreakerFactory cbFactory;

	@Autowired
	public MovieController(MovieService movieService, CircuitBreakerFactory cbFactory) {
		this.movieService = movieService;
		this.cbFactory = cbFactory;
	}


	//@GetMapping("/genre/{genre}")
	@RequestMapping({ "/genre/{genre}" })
	public ResponseEntity<List<Movie>> findAllByGenre(@PathVariable String genre) {
		return ResponseEntity.ok().body(movieService.getListByGenre(genre));
	}

	//cbFactory.create("students").run(()->
	//                        studentService.find(id), throwable -> fallBakcMethod(id, throwable));
	//    }
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Movie>> findbyid(@PathVariable Integer id){
		return ResponseEntity.ok().body(movieService.findById(id));
	}


	@PostMapping
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
		//return cbFactory.create("movies").run(()->movieService.save(movie), throwable -> fallBackMethod(throwable)));
		return ResponseEntity.ok().body(movieService.save(movie));
	}

//	public String fallBackMethod(Throwable ex){
//		log.info("Response 200, fallback method for error: {}", ex.getMessage());
//		return "Se ha realizado correctamente la insercion de la pelicula";
//	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id){
		movieService.delete(id);
	}




}
