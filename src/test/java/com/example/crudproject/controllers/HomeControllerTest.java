package com.example.crudproject.controllers;

import com.example.crudproject.dto.Submission;
import com.example.crudproject.dto.SubmissionResponse;
import com.example.crudproject.services.SubmissionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class HomeControllerTest {

    @Mock
    private SubmissionService submissionService;

    @InjectMocks
    private HomeController homeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getById_ValidId_ReturnsSubmissionResponse() {
        String id = "123";
        SubmissionResponse submissionResponse = new SubmissionResponse(id, new Submission());

        when(submissionService.getById(id)).thenReturn(submissionResponse);

        ResponseEntity<SubmissionResponse> response = homeController.getById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(submissionResponse, response.getBody());

        verify(submissionService, times(1)).getById(id);
    }

    @Test
    void getById_InvalidId_ReturnsNotFound() {
        String id = "invalidId";

        when(submissionService.getById(id)).thenReturn(null);

        ResponseEntity<SubmissionResponse> response = homeController.getById(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        verify(submissionService, times(1)).getById(id);
    }

    @Test
    void getFilteredSubmissions_ValidFilters_ReturnsFilteredSubmissions() {
        MultiValueMap<String, String> filters = new LinkedMultiValueMap<>();
        filters.add("column", "value");

        List<Submission> filteredSubmissions = new ArrayList<>();
        filteredSubmissions.add(new Submission());

        when(submissionService.getFilteredSubmissions(filters)).thenReturn(filteredSubmissions);

        ResponseEntity<List<Submission>> response = homeController.getFilteredSubmissions(filters);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(filteredSubmissions, response.getBody());

        verify(submissionService, times(1)).getFilteredSubmissions(filters);
    }


    @Test
    void create_ValidSubmission_ReturnsCreatedResponse() {
        Submission submission = new Submission();
        SubmissionResponse submissionResponse = new SubmissionResponse("123", submission);

        when(submissionService.create(submission)).thenReturn(submissionResponse);

        ResponseEntity<SubmissionResponse> response = homeController.create(submission);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(submissionResponse, response.getBody());

        verify(submissionService, times(1)).create(submission);
    }

    @Test
    void create_InvalidSubmission_ReturnsInternalServerError() {
        Submission submission = new Submission();

        when(submissionService.create(submission)).thenReturn(null);

        ResponseEntity<SubmissionResponse> response = homeController.create(submission);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

        verify(submissionService, times(1)).create(submission);
    }

    @Test
    void update_ValidSubmission_ReturnsUpdatedResponse() {
        Submission submission = new Submission();
        SubmissionResponse submissionResponse = new SubmissionResponse("123", submission);

        when(submissionService.update(submission)).thenReturn(submissionResponse);

        ResponseEntity<SubmissionResponse> response = homeController.update(submission);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(submissionResponse, response.getBody());

        verify(submissionService, times(1)).update(submission);
    }

    @Test
    void update_InvalidSubmission_ReturnsNotFound() {
        Submission submission = new Submission();

        when(submissionService.update(submission)).thenReturn(null);

        ResponseEntity<SubmissionResponse> response = homeController.update(submission);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        verify(submissionService, times(1)).update(submission);
    }

    @Test
    void delete_ValidId_ReturnsNoContent() {
        String id = "123";

        when(submissionService.delete(id)).thenReturn(true);

        ResponseEntity<Void> response = homeController.delete(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

        verify(submissionService, times(1)).delete(id);
    }

    @Test
    void delete_InvalidId_ReturnsNotFound() {
        String id = "invalidId";

        when(submissionService.delete(id)).thenReturn(false);

        ResponseEntity<Void> response = homeController.delete(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        verify(submissionService, times(1)).delete(id);
    }
}
