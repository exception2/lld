package com.satyendra.lld.issuemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class Issue {

    public enum Priority {LOW, MEDIUM, HIGH};

    private String id;
    private String title;
    private IssueStatus status;
    private Priority priority;
    private String assignee;
    private String reporter;
    private List<Comment> comments;
    private Date createdDate;
}
