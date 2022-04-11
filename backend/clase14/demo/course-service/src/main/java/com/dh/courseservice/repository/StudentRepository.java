package com.dh.courseservice.repository;

import com.dh.courseservice.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="student-service")
public interface StudentRepository {
	@GetMapping("/students/findAll")
	List<Student> findAll(@RequestParam Boolean throwError);
}
