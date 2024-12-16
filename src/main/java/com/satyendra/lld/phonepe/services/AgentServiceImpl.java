package com.satyendra.phonepe.services;

import com.satyendra.phonepe.models.Agent;
import com.satyendra.phonepe.models.Issue;
import lombok.Data;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class AgentServiceImpl implements AgentService {
    private final Map<String, Agent> agentMap;

    public AgentServiceImpl() {
        this.agentMap = new LinkedHashMap<>();
    }

    public Map<String, Agent> getAgentMap() {
        return agentMap;
    }


    @Override
    public Agent addAgent(String agentEmail, String agentName, List<String> expertAreas) {
        Agent agent = new Agent(agentEmail, agentName, expertAreas);
        agentMap.put(agent.getId(), agent);
        System.out.println("Agent " + agent.getId() + " created");
        return agent;
    }
}
