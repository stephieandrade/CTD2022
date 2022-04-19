package com.dh.movieservice.api.service.impl;

import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.domain.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class MovieServiceImpl implements MovieService {
	private MovieRepository movieRepository;

	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public List<Movie> getListByGenre(String genre) {
		return movieRepository.findAllByGenre(genre);
	}

//	@CircuitBreaker(name = "movies",fallbackMethod = "moviesFallbackMethod")
//	@Retry(name = "movies")
	@Override
	public Movie save(Movie movie) {
		log.info("Intentado guardar la pelicula");
		return movieRepository.save(movie);
	}

//	//private List<Movie> moviesFallbackMethod(CallNotPermittedException exception){
//		return new ArrayList<>();
//	}

	@Override
	public Optional<Movie> findById(Integer id) {
		return movieRepository.findById(id);
	}

	@Override
	public void delete(Integer id) {
		movieRepository.deleteById(id);
	}
}
