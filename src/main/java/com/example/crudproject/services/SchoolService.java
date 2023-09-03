package com.example.crudproject.services;

import com.example.crudproject.entity.School;

import java.util.List;
import java.util.Optional;

public interface SchoolService {

    List<School> findAllSchools();

    Optional<School> findSchoolById(Long schoolId);
    School createSchool(School newSchool);

    School updateSchool(School updatedSchool);

    boolean deleteSchoolById(Long schoolId);
}
