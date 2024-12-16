package com.satyendra.phonepe.services;

import com.satyendra.phonepe.models.Agent;
import com.satyendra.phonepe.models.Issue;
import com.satyendra.phonepe.models.IssueStatus;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class IssueServiceImpl implements IssueService {

    private final Map<String, Issue> issueMap;
    private final AgentService agentService;
    private AssignStrategy assignStrategy;

    public IssueServiceImpl(AgentService agentService, AssignStrategy assignStrategy) {
        this.issueMap = new HashMap<>();
        this.agentService = agentService;
        this.assignStrategy = assignStrategy;
    }

    @Override
    public Issue createIssue(String transactionId, String issueType, String subject, String description, String email) {
        Issue issue = new Issue(transactionId, issueType, subject, description, email);
        issueMap.put(issue.getId(), issue);
        System.out.println("Issue " + issue.getId() + " created against transaction " + transactionId);
        return issue;
    }

    @Override
    public void assignIssue(String issueId) {
        Issue issue = issueMap.get(issueId);
        if (issue == null || !IssueStatus.OPEN.equals(issue.getStatus())) {
            System.out.println("Issue not found or already assigned.");
            return;
        }
        assignStrategy.assignIssue(issue, agentService.getAgentMap());
    }

    @Override
    public List<Issue> getIssues(Map<String, String> filter) {
        List<Issue> issues =  issueMap.values().stream()
                .filter(issue -> filter.get("email") == null || issue.getEmail().equals(filter.get("email")))
                .filter(issue -> filter.get("type") == null || issue.getIssueType().equals(filter.get("type")))
                .filter(issue -> filter.get("status") == null || issue.getStatus().toString().equals(filter.get("status")))
                .filter(issue -> filter.get("transactionId") == null || issue.getTransactionId().equals(filter.get("transactionId")))
                .filter(issue -> filter.get("id") == null || issue.getId().equals(filter.get("id")))
                .collect(Collectors.toList());
        for(Issue issue : issues) {
            System.out.println(issue.toString());
        }
        return issues;
    }

    @Override
    public void updateIssue(String issueId, IssueStatus status, String resolution) {
        Issue issue = issueMap.get(issueId);
        if (issue != null) {
            issue.updateStatus(status, resolution);
            System.out.println("Issue " + issueId + " status updated to " + status);
        }
    }

    @Override
    public void resolveIssue(String issueId, String resolution) {
        for (Agent agent : agentService.getAgentMap().values()) {
            if(agent.resolveCurrentIssue(resolution, issueId)) {
                return;
            }
        }
        System.out.println("Issue " + issueId + " not assigned to any agent");
    }

    @Override
    public void viewAgentsWorkHistory() {
        System.out.println("Already worked!");
        agentService.getAgentMap().values().forEach(agent -> {
            System.out.println(agent.getId() + " -> " + agent.getWorkHistory().stream().map(Issue::getId).toList());
        });
        System.out.println("working!");
        agentService.getAgentMap().values().forEach(agent -> {
            System.out.println(agent.getId() + " -> " + agent.getAssignedIssues().stream().map(Issue::getId).toList());
        });
        System.out.println("Will work!");
        agentService.getAgentMap().values().forEach(agent -> {
            System.out.println(agent.getId() + " -> " + agent.getWaitlist().stream().map(Issue::getId).toList());
        });
    }
}
