package com.dh.studentservice.controller;

import com.dh.studentservice.model.Student;
import com.dh.studentservice.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/students")
public class StudentRestController {
    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/findAll")
    public List<Student> findAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> find(@PathVariable Long id) throws InterruptedException {
        if (id.equals(10L)) {
            throw new IllegalStateException("Student not found!");
        }

        if (id.equals(7L)) {
            TimeUnit.SECONDS.sleep(5L);
            return ResponseEntity.ok().body(studentService.get(1L));
        }

        var student = studentService.get(id);

        if (student == null) return  ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(student);
    }

}
