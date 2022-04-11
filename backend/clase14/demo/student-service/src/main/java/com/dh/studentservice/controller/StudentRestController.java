package com.dh.studentservice.controller;

import com.dh.studentservice.model.Student;
import com.dh.studentservice.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentRestController {
	private final StudentService studentService;

	public StudentRestController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/findAll")
	public List<Student> findAll(@RequestParam(defaultValue = "false") Boolean throwError) {
		return studentService.findAll(throwError);
	}
}
