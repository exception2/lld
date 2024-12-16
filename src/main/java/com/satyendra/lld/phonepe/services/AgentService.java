package com.satyendra.phonepe.services;

import com.satyendra.phonepe.models.Agent;
import com.satyendra.phonepe.models.Issue;

import java.util.List;
import java.util.Map;

public interface AgentService {
    Agent addAgent(String agentEmail, String agentName, List<String> expertAreas);
    Map<String, Agent> getAgentMap();
}
