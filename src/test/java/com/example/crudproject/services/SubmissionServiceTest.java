package com.example.crudproject.services;

import static org.junit.jupiter.api.Assertions.*;

import com.example.crudproject.dto.Submission;
import com.example.crudproject.dto.SubmissionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;

class SubmissionServiceTest {

    @Mock
    private SubmissionService submissionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getById_ValidId_ReturnsSubmissionResponse() {
        // Arrange
        String id = "123";
        Submission expectedSubmission = new Submission(id, "John Doe", "2022-10-31", "Value 1", 42, "Value 3");
        SubmissionResponse expectedResponse = new SubmissionResponse(id, expectedSubmission);
        Mockito.when(submissionService.getById(id)).thenReturn(expectedResponse);

        // Act
        SubmissionResponse actualResponse = submissionService.getById(id);

        // Assert
        assertNotNull(actualResponse);
        assertEquals(expectedResponse.getId(), actualResponse.getId());
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void create_ValidSubmission_ReturnsSubmissionResponse() {
        // Arrange
        Submission submission = new Submission(null, "John Doe", "2022-10-31", "Value 1", 42, "Value 3");
        SubmissionResponse expectedResponse = new SubmissionResponse("123", submission);
        Mockito.when(submissionService.create(submission)).thenReturn(expectedResponse);

        // Act
        SubmissionResponse actualResponse = submissionService.create(submission);

        // Assert
        assertNotNull(actualResponse);
        assertNotNull(actualResponse.getId());
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void update_ValidSubmission_ReturnsSubmissionResponse() {
        // Arrange
        String id = "123";
        Submission submission = new Submission(id, "John Doe", "2022-10-31", "Value 1", 42, "Value 3");
        SubmissionResponse expectedResponse = new SubmissionResponse(id, submission);
        Mockito.when(submissionService.update(submission)).thenReturn(expectedResponse);

        // Act
        SubmissionResponse actualResponse = submissionService.update(submission);

        // Assert
        assertNotNull(actualResponse);
        assertEquals(expectedResponse.getId(), actualResponse.getId());
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void delete_ValidId_ReturnsTrue() {
        // Arrange
        String id = "123";
        Mockito.when(submissionService.delete(id)).thenReturn(true);

        // Act
        boolean isDeleted = submissionService.delete(id);

        // Assert
        assertTrue(isDeleted);
    }

    @Test
    void getFilteredSubmissions_ValidFilters_ReturnsFilteredSubmissions() {
        // Arrange
        MultiValueMap<String, String> filters = new LinkedMultiValueMap<>();
        filters.put("column1", Collections.singletonList("Value 1"));
        filters.put("column2", Collections.singletonList("42"));
        List<Submission> expectedSubmissions = new ArrayList<>();
        expectedSubmissions.add(new Submission("123", "John Doe", "2022-10-31", "Value 1", 42, "Value 3"));
        expectedSubmissions.add(new Submission("456", "Jane Smith", "2022-11-01", "Value 2", 42, "Value 3"));
        Mockito.when(submissionService.getFilteredSubmissions(filters)).thenReturn(expectedSubmissions);

        // Act
        List<Submission> actualSubmissions = submissionService.getFilteredSubmissions(filters);

        // Assert
        assertNotNull(actualSubmissions);
        assertEquals(expectedSubmissions.size(), actualSubmissions.size());
        assertEquals(expectedSubmissions.get(0), actualSubmissions.get(0));
        assertEquals(expectedSubmissions.get(1), actualSubmissions.get(1));
    }
}
