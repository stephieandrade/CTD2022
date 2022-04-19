package com.dh.movieservice.api.service;

import com.dh.movieservice.domain.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
	List<Movie> getListByGenre(String genre);
	Optional<Movie> findById(Integer id);
	Movie save(Movie movie);
	void delete(Integer id);
}
