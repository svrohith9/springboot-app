package com.example.crudproject.services.impl;

import com.example.crudproject.entity.Student;
import com.example.crudproject.repository.StudentRepository;
import com.example.crudproject.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findBySchoolId(Long schoolId) {
        // Assuming you have a method in the repository that can fetch students by school ID
        return studentRepository.findBySchool_SchoolId(schoolId);
    }
}
