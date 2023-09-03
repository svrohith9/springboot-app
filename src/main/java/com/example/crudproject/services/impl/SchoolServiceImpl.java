package com.example.crudproject.services.impl;

import com.example.crudproject.entity.School;
import com.example.crudproject.repository.SchoolRepository;

import com.example.crudproject.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public Optional<School> findSchoolById(Long schoolId) {
        return schoolRepository.findById(schoolId);
    }
}
