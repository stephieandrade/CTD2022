package com.dh.movieservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
//@Component // Spring treats it as a Spring-managed object.
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Movie.class)
public class Movie implements Serializable  { //it will be transmitted over a messaging system.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String genre;
	private String urlStream;


	@Override
	public String toString() {
		return "Movie{" +
				"id=" + id +
				", name='" + name + '\'' +
				", genre='" + genre + '\'' +
				", urlStream='" + urlStream + '\'' +
				'}';
	}
}
