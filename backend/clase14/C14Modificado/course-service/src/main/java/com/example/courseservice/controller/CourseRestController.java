package com.example.courseservice.controller;

import com.example.courseservice.model.Course;
import com.example.courseservice.service.impl.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseRestController {

  private final CourseService courseService;

  public CourseRestController(CourseService courseService) {
    this.courseService = courseService;
  }

  @GetMapping("/{id}")
  public Course findById(@PathVariable Integer id){
    return  courseService.findCourseById(id);
  }
}
