package com.dh.courseservice.service.impl;

import com.dh.courseservice.model.Student;
import com.dh.courseservice.repository.StudentRepository;
import com.dh.courseservice.service.StudentService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
	private StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@CircuitBreaker(name = "students", fallbackMethod = "findAllEmptyFallback")
	@Retry(name = "students")
	@Override
	public List<Student> findAll() {
		log.info("Calling student service...");
		return studentRepository.findAll(false);
	}

	private List<Student> findAllEmptyFallback(CallNotPermittedException exception) {
		return new ArrayList<>();
	}
}
