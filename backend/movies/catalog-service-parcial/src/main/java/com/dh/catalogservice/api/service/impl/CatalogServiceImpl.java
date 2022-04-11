package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.dto.Catalog;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.repository.MovieFeignRepository;
import com.dh.catalogservice.domain.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class CatalogServiceImpl implements CatalogService {

	private MovieRepository movieRepository;
	private MovieFeignRepository movieFeignRepository;



	@Override
	public CatalogWS getUserCatalog(String genre){
		List<Catalog> libraryList = movieRepository.findAllByGenre(genre);
		List<MovieWS> movieList = new ArrayList<>();
		for (Catalog catalog : libraryList) {
			Integer movieId = catalog.getMovieId();
			MovieWS movieDetails = movieFeignRepository.getMovieDetails(movieId);
			movieList.add(movieDetails);
		}
		return CatalogWS.builder()
				.genre(genre)
				.movies(movieList)
				.build();
	}
}
