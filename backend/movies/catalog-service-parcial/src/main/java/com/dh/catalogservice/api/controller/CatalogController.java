package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.queue.MovieSender;
import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.dto.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.dto.MovieWS;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	private CatalogService catalogService;
	private MovieSender movieSender;

	@Autowired
	public CatalogController(CatalogService catalogService) {
		this.catalogService = catalogService;
	}

	@GetMapping("/{genre}")
	public CatalogWS findAllByGenre(@PathVariable String genre) {
		return catalogService.getUserCatalog(genre);
	}

	@PostMapping("/salvar")
	public void saveMovie(@RequestBody MovieWS movie) {
		movieSender.send(movie);
	}




}
