package com.example.crudproject.services.impl;

import com.example.crudproject.entity.Student;
import com.example.crudproject.exceptions.StudentNotFoundException;
import com.example.crudproject.repository.StudentRepository;
import com.example.crudproject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long studentId) throws StudentNotFoundException {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + studentId));
    }

    @Override
    public Student createStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @Override
    public Student updateStudent(Long studentId, Student updatedStudent) throws StudentNotFoundException {
        Optional<Student> existingStudent = studentRepository.findById(studentId);

        if (existingStudent.isPresent()) {
            updatedStudent.setId(studentId); // Assuming setId() method exists in Student entity
            return studentRepository.save(updatedStudent);
        } else {
            throw new StudentNotFoundException("Student not found with ID: " + studentId);
        }
    }

    @Override
    public boolean deleteStudent(Long studentId) {
        Optional<Student> studentToDelete = studentRepository.findById(studentId);

        if (studentToDelete.isPresent()) {
            studentRepository.delete(studentToDelete.get());
            return true;
        }

        return false;
    }

    @Override
    public List<Student> findBySchoolId(Long schoolId) {
        return studentRepository.findBySchool_SchoolId(schoolId);
    }
}
