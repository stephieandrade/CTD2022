package com.example.courseservice.controller;

import com.example.courseservice.model.Student;
import com.example.courseservice.service.impl.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentRestController {

    private final StudentService studentService;
    private final CircuitBreakerFactory cbFactory;

    @GetMapping("/v1/{id}")
    public Student findById(@PathVariable Long id) {
        return cbFactory.create("students").run(()->
                        studentService.find(id), throwable -> fallBakcMethod(id, throwable));
    }

    public Student fallBakcMethod(Long id, Throwable ex){
        log.info("Response 200, fallback method for error: {}", ex.getMessage());
        Student student = new Student ();
        student.setId(id);
        student.setName("Ricardo");
        student.setLastName("Arjona");
        student.setIdentificationNumber(35526867);
        return student;
    }
}
