package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.api.queue.MovieSender;
import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.dto.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.dto.MovieWS;
import com.dh.catalogservice.domain.model.dto.dto.SerieWS;
import com.dh.catalogservice.domain.repository.MovieFeignRepository;
import com.dh.catalogservice.domain.repository.CatalogRepository;
import com.dh.catalogservice.domain.repository.SerieFeignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

	private CatalogRepository catalogRepository;
	private MovieFeignRepository movieFeignRepository;
	private SerieFeignRepository serieFeignRepository;
	private MovieSender movieSender;

	public CatalogServiceImpl() {
	}
	@Autowired
	public CatalogServiceImpl(CatalogRepository catalogRepository, MovieFeignRepository movieFeignRepository, SerieFeignRepository serieFeignRepository, MovieSender movieSender) {
		this.catalogRepository = catalogRepository;
		this.movieFeignRepository = movieFeignRepository;
		this.serieFeignRepository = serieFeignRepository;
		this.movieSender = movieSender;
	}





	@Override
	public CatalogWS getUserCatalog(String genre){
//		Course course = courseRepository.findById(id).orElse(null);
//		List<Student> students = studentService.findAll();
//		if (course != null) {
//			course.setStudents(students);
//		}
//		return course;

		List<MovieWS> movieWS = movieFeignRepository.getMoviesByGenero(genre);
		List<SerieWS> serieWS = serieFeignRepository.getSeriesByGenre(genre);
		//CatalogWS catalogWS = new CatalogWS();

//		List<Catalog> catalogList = catalogRepository.findAllByGenre(genre);
//		//List<MovieWS> movieList = new ArrayList<>();
//		List<MovieWS> movieList = catalogList.stream()
//				.map(Catalog::getMovieId)
//				.map(movieId -> movieFeignRepository.getMovieDetails(movieId))
//				.collect(Collectors.toList());

//		for (Catalog catalog : catalogList) {
//			Integer movieId = catalog.getMovieId();
//			String serieId = catalog.getSeriesId();
//			MovieWS movieDetails = movieFeignRepository.getMovieDetails(movieId);
//			SerieWS seriesDetails = serieFeignRepository.getSeriesDetails(serieId);
//			movieWS.add(movieDetails);
//			serieWS.add(seriesDetails);

//		}

		CatalogWS done = CatalogWS.builder()
				.genre(genre)
				.movies(movieWS)
				.series(serieWS)
				.build();
//
//		List<MovieWS> movieListId = movieWS.stream()
//				.map(MovieWS::)
//				.map(movieId -> movieFeignRepository.getMovieDetails(movieId))
//				.collect(Collectors.toList());
//
//		Catalog MongoCatalog = Catalog.builder().genre(genre).movieId()build();
//		catalogRepository.saveCatalog(done);

		return done;
	}





}
