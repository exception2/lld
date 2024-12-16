package com.satyendra.phonepe.models;

import lombok.Data;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@Data
@ToString
public class Issue {

    private static final AtomicInteger idGenerator = new AtomicInteger(1);
    private final String id;
    private final String transactionId;
    private String issueType;
    private String subject;
    private String description;
    private final String email;
    private IssueStatus status;
    private String resolution;

    public Issue(String transactionId, String issueType, String subject, String description, String email) {
        this.id = "I" + idGenerator.getAndIncrement();
        this.transactionId = transactionId;
        this.issueType = issueType;
        this.subject = subject;
        this.description = description;
        this.email = email;
        this.status = IssueStatus.OPEN;
    }

    public void updateStatus(IssueStatus status, String resolution) {
        this.status = status;
        this.resolution = resolution;
    }
}
