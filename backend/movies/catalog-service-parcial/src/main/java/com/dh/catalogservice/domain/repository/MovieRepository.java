package com.dh.catalogservice.domain.repository;

import com.dh.catalogservice.domain.model.dto.Catalog;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Catalog, Integer> {
    public List<Catalog> findAllByGenre(String genre);

}
