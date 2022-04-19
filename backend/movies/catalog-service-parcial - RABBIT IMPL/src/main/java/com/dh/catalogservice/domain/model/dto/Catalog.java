package com.dh.catalogservice.domain.model.dto;

import com.dh.catalogservice.domain.model.dto.dto.MovieWS;
import com.dh.catalogservice.domain.model.dto.dto.SerieWS;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Catalog {
    @Id
    private Integer id;
    private String genre;
    private List<MovieWS> movies;
    private List<SerieWS> series;
}
