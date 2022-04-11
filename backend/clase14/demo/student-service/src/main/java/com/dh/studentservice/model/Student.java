package com.dh.studentservice.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String lastName;
	private Integer identificationNumber;

	public Student() {
	}

	public Student(Integer id, String name, String lastName, Integer identificationNumber) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.identificationNumber = identificationNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(Integer identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", lastName='" + lastName + '\'' +
				", identificationNumber=" + identificationNumber +
				'}';
	}
}
