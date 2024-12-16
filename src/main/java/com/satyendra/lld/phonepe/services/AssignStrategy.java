package com.satyendra.phonepe.services;

import com.satyendra.phonepe.models.Agent;
import com.satyendra.phonepe.models.Issue;

import java.util.Map;

public interface AssignStrategy {
    void assignIssue(Issue issue, Map<String, Agent> agents);
}
