package com.example.crudproject.controllers;

import com.example.crudproject.entity.Student;
import com.example.crudproject.exceptions.StudentNotFoundException;
import com.example.crudproject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long studentId) {
        try {
            Student student = studentService.findById(studentId);
            return ResponseEntity.ok(student);
        } catch (StudentNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student newStudent) {
        Student createdStudent = studentService.createStudent(newStudent);
        URI location = URI.create("/api/students/" + createdStudent.getId());
        return ResponseEntity.created(location).body(createdStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") Long studentId, @RequestBody Student updatedStudent) {
        try {
            Student savedStudent = studentService.updateStudent(studentId, updatedStudent);
            return ResponseEntity.ok(savedStudent);
        } catch (StudentNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long studentId) {
        boolean deleted = studentService.deleteStudent(studentId);

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Student>> getStudentsBySchoolId(@PathVariable("schoolId") Long schoolId) {
        List<Student> students = studentService.findBySchoolId(schoolId);
        return ResponseEntity.ok(students);
    }
}
