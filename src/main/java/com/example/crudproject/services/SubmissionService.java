package com.example.crudproject.services;

import com.example.crudproject.dto.Submission;
import com.example.crudproject.dto.SubmissionResponse;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface SubmissionService {

    SubmissionResponse getById(String id);

    SubmissionResponse create(Submission data);

    SubmissionResponse update(Submission data);

    boolean delete(String id);

    List<Submission> getFilteredSubmissions(MultiValueMap<String, String> filters);
}

