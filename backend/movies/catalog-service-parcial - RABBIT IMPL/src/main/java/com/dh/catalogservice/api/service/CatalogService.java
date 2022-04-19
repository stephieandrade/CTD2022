package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.dto.Catalog;
import com.dh.catalogservice.domain.model.dto.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.dto.MovieWS;

import java.util.List;

public interface CatalogService {
    CatalogWS getUserCatalog(String genre);
    MovieWS findMovieById(Integer id, Boolean ThrowError);
}
