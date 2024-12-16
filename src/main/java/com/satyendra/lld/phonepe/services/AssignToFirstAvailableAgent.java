package com.satyendra.phonepe.services;

import com.satyendra.phonepe.models.Agent;
import com.satyendra.phonepe.models.Issue;

import java.util.Map;

public class AssignToFirstAvailableAgent implements AssignStrategy {

    @Override
    public void assignIssue(Issue issue, Map<String, Agent> agents) {
        for (Agent agent : agents.values()) {
            if (agent.isAvailable() && agent.canResolve(issue.getIssueType())) {
                agent.assignIssue(issue);
                System.out.println("Issue " + issue.getId() + " assigned to agent " + agent.getId());
                return;
            }
        }
        // If no agent is available, add to the waitlist of the first agent who can handle this issue type
        for (Agent agent : agents.values()) {
            if (agent.canResolve(issue.getIssueType())) {
                agent.addToWaitlist(issue);
                System.out.println("Issue " + issue.getId() + " added to waitlist of agent " + agent.getId());
                return;
            }
        }

        System.out.println("No agent found to handle issue " + issue.getId());
    }
}
