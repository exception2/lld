package com.satyendra.phonepe.services;

import com.satyendra.phonepe.models.Issue;
import com.satyendra.phonepe.models.IssueStatus;

import java.util.List;
import java.util.Map;

public interface IssueService {
    Issue createIssue(String transactionId, String issueType, String subject, String description, String email);
    void assignIssue(String issueId);
    List<Issue> getIssues(Map<String, String> filter);
    void updateIssue(String issueId, IssueStatus status, String resolution);
    void resolveIssue(String issueId, String resolution);
    void viewAgentsWorkHistory();
}
