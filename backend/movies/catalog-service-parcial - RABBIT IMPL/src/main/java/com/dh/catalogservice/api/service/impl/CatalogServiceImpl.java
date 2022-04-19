package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.dto.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.dto.MovieWS;
import com.dh.catalogservice.domain.model.dto.dto.SerieWS;
import com.dh.catalogservice.domain.repository.MovieFeignRepository;
import com.dh.catalogservice.domain.repository.CatalogRepository;
import com.dh.catalogservice.domain.repository.SerieFeignRepository;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

	private CatalogRepository catalogRepository;
	private MovieFeignRepository movieFeignRepository;
	private SerieFeignRepository serieFeignRepository;


	public CatalogServiceImpl() {
	}
	@Autowired
	public CatalogServiceImpl(CatalogRepository catalogRepository, MovieFeignRepository movieFeignRepository, SerieFeignRepository serieFeignRepository) {
		this.catalogRepository = catalogRepository;
		this.movieFeignRepository = movieFeignRepository;
		this.serieFeignRepository = serieFeignRepository;

	}

	@Override
	public CatalogWS getUserCatalog(String genre){

		List<MovieWS> movieWS = movieFeignRepository.getMoviesByGenero(genre);
		List<SerieWS> serieWS = serieFeignRepository.getSeriesByGenre(genre);


		CatalogWS done = CatalogWS.builder()
				.genre(genre)
				.movies(movieWS)
				.series(serieWS)
				.build();
		return done;
	}


	@Override
	@CircuitBreaker(name = "movies", fallbackMethod = "fallbackMethod") //crea instancia de circuit breaker
	@Retry(name = "movies")
	public MovieWS findMovieById(Integer id, Boolean ThrowError){
		System.out.println("Ejecutando..");
		MovieWS response = movieFeignRepository.getMovieById(id, ThrowError);
		return response;

	}


	private MovieWS fallbackMethod(CallNotPermittedException ex){
		return new MovieWS(1, "hola", "Terror", "url");
	}



}
