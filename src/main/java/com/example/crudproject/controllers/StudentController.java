package com.example.crudproject.controllers;

import com.example.crudproject.entity.Student;
import com.example.crudproject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.findAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Student>> getStudentsBySchoolId(@PathVariable("schoolId") Long schoolId) {
        List<Student> students = studentService.findBySchoolId(schoolId);
        return ResponseEntity.ok(students);
    }
}
