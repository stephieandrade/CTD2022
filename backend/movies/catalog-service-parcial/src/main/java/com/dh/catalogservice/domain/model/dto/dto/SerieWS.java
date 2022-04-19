package com.dh.catalogservice.domain.model.dto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
public class SerieWS {
    @Id
    private String id;
    private String name;
    private String genre;
    private List<SeasonsWS> seasons;
}
