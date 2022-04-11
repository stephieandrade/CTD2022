package com.dh.courseservice.service.impl;

import com.dh.courseservice.model.Course;
import com.dh.courseservice.model.Student;
import com.dh.courseservice.repository.CourseRepository;
import com.dh.courseservice.service.CourseService;
import com.dh.courseservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
	private CourseRepository courseRepository;
	private StudentService studentService;

	@Autowired
	public CourseServiceImpl(CourseRepository courseRepository, StudentService studentService) {
		this.courseRepository = courseRepository;
		this.studentService = studentService;
	}

	@Override
	public Course findCourseById(Integer id) {
		Course course = courseRepository.findById(id).orElse(null);
		List<Student> students = studentService.findAll();
		if (course != null) {
			course.setStudents(students);
		}
		return course;
	}
}
