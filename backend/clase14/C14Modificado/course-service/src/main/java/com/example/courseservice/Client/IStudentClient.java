package com.example.courseservice.Client;

import com.example.courseservice.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "student-service")
public interface IStudentClient {

    @GetMapping("/students/findAll")
    List<Student> findAll(@RequestParam Boolean throwError);

    @GetMapping("/students/{id}")
    Student find(@PathVariable Long id);

}
