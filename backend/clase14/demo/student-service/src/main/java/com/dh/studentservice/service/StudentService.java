package com.dh.studentservice.service;

import com.dh.studentservice.model.Student;
import com.dh.studentservice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

	private StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> findAll(Boolean throwError) {
		if (throwError)
			throw new RuntimeException();

		return studentRepository.findAll();
	}
}
