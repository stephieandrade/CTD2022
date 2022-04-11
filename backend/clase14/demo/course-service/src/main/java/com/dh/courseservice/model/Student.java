package com.dh.courseservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Data
public class Student {
	private Integer id;
	private String name;
	private String lastName;
	private Integer identificationNumber;
}
