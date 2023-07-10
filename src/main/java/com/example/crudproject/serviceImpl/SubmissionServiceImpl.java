package com.example.crudproject.serviceImpl;

import com.example.crudproject.dto.Submission;
import com.example.crudproject.dto.SubmissionResponse;
import com.example.crudproject.services.SubmissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.*;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    private static final Logger logger = LoggerFactory.getLogger(SubmissionServiceImpl.class);

    private final List<Submission> submissions = new ArrayList<>();

    public SubmissionResponse getById(String id) {
        logger.info("Fetching submission by ID: {}", id);
        Submission submission = findSubmissionById(id);
        if (submission != null) {
            logger.info("Submission found for ID: {}", id);
            return new SubmissionResponse(submission.getId(), submission);
        } else {
            logger.info("Submission not found for ID: {}", id);
            return null;
        }
    }

    public SubmissionResponse create(Submission data) {
        logger.info("Creating new submission: {}", data);
        Submission submission = createSubmission(data);
        logger.info("Submission created with ID: {}", submission.getId());
        return new SubmissionResponse(submission.getId(), submission);
    }

    public SubmissionResponse update(Submission data) {
        logger.info("Updating submission: {}", data);
        Submission submission = updateSubmission(data.getId(), data);
        if (submission != null) {
            logger.info("Submission updated for ID: {}", submission.getId());
            return new SubmissionResponse(submission.getId(), submission);
        } else {
            logger.info("Submission update failed for ID: {}", data.getId());
            return null;
        }
    }

    public boolean delete(String id) {
        logger.info("Deleting submission with ID: {}", id);
        return deleteSubmission(id);
    }

    @Override
    public List<Submission> getFilteredSubmissions(MultiValueMap<String, String> filters) {
        logger.info("Filtering submissions with filters: {}", filters);

        // If no filters are specified, return all submissions
        if (filters.isEmpty()) {
            logger.info("No filters specified. Returning all submissions.");
            return new ArrayList<>(submissions);
        }

        List<Submission> filteredSubmissions = new ArrayList<>();

        for (Submission submission : submissions) {

            for (Map.Entry<String, List<String>> entry : filters.entrySet()) {
                String columnName = entry.getKey();
                List<String> filterValues = entry.getValue();

                // Get the value of the submission field based on the column name
                String submissionValue = getSubmissionValue(submission, columnName);

                // Check if the submission value matches any of the filter values
                if (filterValues.contains(submissionValue)) {
                    filteredSubmissions.add(submission);
                    break;
                }
            }
        }

        logger.info("Filtered submissions count: {}", filteredSubmissions.size());
        return filteredSubmissions;
    }

    private String getSubmissionValue(Submission submission, String columnName) {
        return switch (columnName) {
            case "id" -> submission.getId();
            case "name" -> submission.getName();
            case "date" -> submission.getDate();
            case "column1" -> submission.getColumn1();
            case "column2" -> String.valueOf(submission.getColumn2());
            case "column3" -> submission.getColumn3();
            default -> null; // Or handle the case when the column name is not recognized
        };
    }


    private Submission findSubmissionById(String id) {
        for (Submission submission : submissions) {
            if (submission.getId().equals(id)) {
                return submission;
            }
        }
        return null;
    }

    private Submission createSubmission(Submission data) {
        data.setId(generateId());
        submissions.add(data);
        return data;
    }

    private Submission updateSubmission(String id, Submission newData) {
        Submission submission = findSubmissionById(id);
        if (submission != null) {
            submission.setName(newData.getName());
            submission.setDate(newData.getDate());
            submission.setColumn1(newData.getColumn1());
            submission.setColumn2(newData.getColumn2());
            submission.setColumn3(newData.getColumn3());
            return submission;
        } else {
            return null;
        }
    }

    private boolean deleteSubmission(String id) {
        Submission submission = findSubmissionById(id);
        if (submission != null) {
            submissions.remove(submission);
            logger.info("Submission deleted with ID: {}", id);
            return true;
        } else {
            logger.info("Submission not found for deletion with ID: {}", id);
            return false;
        }
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }
}
