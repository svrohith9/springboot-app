package com.example.crudproject.controllers;

import com.example.crudproject.dto.Submission;
import com.example.crudproject.dto.SubmissionResponse;
import com.example.crudproject.services.SubmissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submission")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    private final SubmissionService service;

    public HomeController(SubmissionService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubmissionResponse> getById(@PathVariable String id) {
        logger.info("GET request received for ID: {}", id);
        SubmissionResponse submission = service.getById(id);
        if (submission != null) {
            logger.info("GET request successful for ID: {}", id);
            return ResponseEntity.ok(submission);
        } else {
            logger.info("GET request failed for ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<Submission>> getFilteredSubmissions(@RequestParam MultiValueMap<String, String> filters) {
        logger.info("GET request received with filters: {}", filters);
        List<Submission> filteredSubmissions = service.getFilteredSubmissions(filters);
        if (filteredSubmissions.isEmpty()) {
            logger.info("GET request returned no content with filters: {}", filters);
            return ResponseEntity.noContent().build();
        }
        logger.info("GET request successful with filters: {}", filters);
        return ResponseEntity.ok(filteredSubmissions);
    }

    @PostMapping
    public ResponseEntity<SubmissionResponse> create(@RequestBody Submission data) {
        logger.info("POST request received with data: {}", data);
        SubmissionResponse submission = service.create(data);
        if (submission != null) {
            logger.info("POST request successful with data: {}", data);
            return ResponseEntity.status(HttpStatus.CREATED).body(submission);
        } else {
            logger.error("POST request failed with data: {}", data);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping()
    public ResponseEntity<SubmissionResponse> update(@RequestBody Submission data) {
        logger.info("PUT request received with data: {}", data);
        SubmissionResponse submission = service.update(data);
        if (submission != null) {
            logger.info("PUT request successful with data: {}", data);
            return ResponseEntity.ok(submission);
        } else {
            logger.info("PUT request failed with data: {}", data);
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        logger.info("DELETE request received for ID: {}", id);
        boolean deleted = service.delete(id);
        if (deleted) {
            logger.info("DELETE request successful for ID: {}", id);
            return ResponseEntity.noContent().build();
        } else {
            logger.info("DELETE request failed for ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }
}
