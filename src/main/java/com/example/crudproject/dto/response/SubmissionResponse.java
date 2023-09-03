package com.example.crudproject.dto.response;

import com.example.crudproject.dto.requests.Submission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubmissionResponse {
    private String id;
    private Submission data;
}
