package com.satyendra.phonepe.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Agent {

    private static final AtomicInteger idGenerator = new AtomicInteger(1);
    private final String id;
    private final String email;
    private final String name;
    private final List<String> expertAreas;
    private final Queue<Issue> assignedIssues;
    private final List<Issue> workHistory;
    private final Queue<Issue> waitlist;

    public Agent(String email, String name, List<String> expertAreas) {
        this.id = "A" + idGenerator.getAndIncrement();
        this.email = email;
        this.name = name;
        this.expertAreas = expertAreas;
        this.assignedIssues = new LinkedList<>();
        this.workHistory = new ArrayList<>();
        this.waitlist = new LinkedList<>();
    }

    public void addToWaitlist(Issue issue) {
        waitlist.offer(issue);
    }

    public boolean isAvailable() {
        return assignedIssues.isEmpty();
    }

    public boolean canResolve(String issueType) {
        return expertAreas.contains(issueType);
    }

    public void assignIssue(Issue issue) {
        synchronized (this) {
            assignedIssues.add(issue);
        }
    }

    public boolean resolveCurrentIssue(String resolution, String issueId) {
        Issue issue = assignedIssues.peek();
        if (issue != null && issue.getId().equalsIgnoreCase(issueId)) {
            assignedIssues.poll();
            issue.updateStatus(IssueStatus.RESOLVED, resolution);
            workHistory.add(issue);
            System.out.println("Issue " + issue.getId() + " issue marked resolved");
            if (!waitlist.isEmpty()) {
                Issue nextIssue = waitlist.poll();
                assignedIssues.offer(nextIssue);
                System.out.println("Issue " + nextIssue.getId() + " moved from waitlist to current issues for agent " + this.getId());
            }
        }
        return false;
    }
}
