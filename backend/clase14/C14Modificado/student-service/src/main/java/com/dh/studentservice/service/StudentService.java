package com.dh.studentservice.service;

import com.dh.studentservice.model.Student;
import com.dh.studentservice.repository.IStudentRepository;
import com.dh.studentservice.shared.GenericServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService extends GenericServiceImpl<Student, Long> implements IStudenService {

  private final IStudentRepository studentRepository;

  @Override
  public JpaRepository<Student, Long> getJpaRepository() {
    return studentRepository;
  }
}
