package com.example.crudproject.repository;

import com.example.crudproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findBySchool_SchoolId(Long schoolId);
    // Spring Data JPA will auto-implement this based on the method name.
}
