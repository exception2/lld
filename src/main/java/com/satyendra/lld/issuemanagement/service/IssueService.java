package com.satyendra.lld.issuemanagement.service;

import com.satyendra.lld.issuemanagement.model.Issue;
import com.satyendra.lld.issuemanagement.model.IssueStatus;

import java.util.List;

public interface IssueService {

    Issue createIssue(String title, String description, Issue.Priority priority, String reporter, String assignee);
    Issue updateIssue(String issueId, String title, String description, Issue.Priority priority, String reporter, String assignee);

    void addComment(String issueId, String userId, String message);

    List<Issue> searchIssues(IssueStatus status, String assigneeId);
}
