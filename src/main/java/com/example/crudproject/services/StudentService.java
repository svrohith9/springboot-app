package com.example.crudproject.services;

import com.example.crudproject.entity.Student;
import com.example.crudproject.exceptions.StudentNotFoundException;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(Long studentId) throws StudentNotFoundException;

    Student createStudent(Student newStudent);

    Student updateStudent(Long studentId, Student updatedStudent) throws StudentNotFoundException;

    boolean deleteStudent(Long studentId);

    List<Student> findBySchoolId(Long schoolId);
}
