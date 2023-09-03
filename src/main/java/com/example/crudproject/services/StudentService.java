    package com.example.crudproject.services;

    import com.example.crudproject.entity.Student;

    import java.util.List;

    public interface StudentService {

        List<Student> findAll();

        List<Student> findBySchoolId(Long schoolId);
    }
