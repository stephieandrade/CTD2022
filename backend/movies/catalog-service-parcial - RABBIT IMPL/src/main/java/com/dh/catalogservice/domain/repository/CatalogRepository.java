package com.dh.catalogservice.domain.repository;

import com.dh.catalogservice.domain.model.dto.Catalog;
import com.dh.catalogservice.domain.model.dto.dto.CatalogWS;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CatalogRepository extends MongoRepository<Catalog, String> {
      //  void saveCatalog(Catalog catalog); //?????????????

}
