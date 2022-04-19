package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.dto.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.dto.MovieWS;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/catalog")
public class CatalogController {
	private CatalogService catalogService;
	private CircuitBreakerFactory cbFactory;
	@Autowired
	public CatalogController(CatalogService catalogService) {
		this.catalogService = catalogService;
	}

	@GetMapping("/{genre}")
	public CatalogWS findAllByGenre(@PathVariable String genre) {
		return catalogService.getUserCatalog(genre);
	}

	@GetMapping("movies/{id}")
	public MovieWS findMovieById(@PathVariable Integer id, Boolean ThrowError) {
		return catalogService.findMovieById(id, true); //cambiar a FALSE p probar
	}









}
