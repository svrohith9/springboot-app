package com.example.crudproject.controllers;

import com.example.crudproject.entity.School;
import com.example.crudproject.services.SchoolService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public ResponseEntity<List<School>> getAllSchools() {
        List<School> schools = schoolService.findAllSchools();
        return ResponseEntity.ok(schools);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSchoolById(@PathVariable("id") Long schoolId) {
        Optional<School> school = schoolService.findSchoolById(schoolId);

        if (school.isPresent()) {
            return ResponseEntity.ok(school.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<School> createSchool(@Valid @RequestBody School newSchool) {
        School createdSchool = schoolService.createSchool(newSchool);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSchool);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSchool(@PathVariable("id") Long schoolId, @Valid @RequestBody School updatedSchool) {
        Optional<School> existingSchool = schoolService.findSchoolById(schoolId);

        if (existingSchool.isPresent()) {
            updatedSchool.setSchoolId(schoolId); // Assuming setSchoolId() method exists in School entity
            School savedSchool = schoolService.updateSchool(updatedSchool);
            return ResponseEntity.ok(savedSchool);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable("id") Long schoolId) {
        boolean deleted = schoolService.deleteSchoolById(schoolId);

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
