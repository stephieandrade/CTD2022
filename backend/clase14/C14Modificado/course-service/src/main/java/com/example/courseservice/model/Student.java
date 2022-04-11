package com.example.courseservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Student {
  private Long id;
  private String name;
  private String lastName;
  private Integer identificationNumber;
}
