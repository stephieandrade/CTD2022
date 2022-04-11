package com.example.courseservice.service.impl;

import com.example.courseservice.model.Course;
import com.example.courseservice.model.Student;
import com.example.courseservice.repository.ICourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService {
  private final ICourseRepository courseRepository;
  private final StudentService studentService;


  public Course findCourseById(Integer id){
    Course course = courseRepository.findById(id).orElse(null);
    List<Student> students =  studentService.findAll();
    if(course != null)
      course.setStudents(students);
    return course;
  }


}
