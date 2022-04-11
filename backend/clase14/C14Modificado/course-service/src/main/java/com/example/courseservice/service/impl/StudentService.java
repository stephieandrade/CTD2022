package com.example.courseservice.service.impl;

import com.example.courseservice.model.Student;
import com.example.courseservice.Client.IStudentClient;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

  private final IStudentClient studentClient;

  @CircuitBreaker(name = "students",fallbackMethod = "studentFallbackMethod")
  @Retry(name = "students")
  public List<Student> findAll(){
    log.info("Intentado buscar los estudiantes");
    return studentClient.findAll(false);
  }

  public Student find(Long id){
    return studentClient.find(id);
  }

  private List<Student> studentFallbackMethod(CallNotPermittedException exception){
    return new ArrayList<>();
  }


}
