package com.dh.catalogservice.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@Builder
public class Catalog {
    @Id
    private Integer id;
    private String genre;
    private Integer movieId;
    private String seriesId;
}
