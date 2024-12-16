package com.satyendra.phonepe;

import com.satyendra.phonepe.models.Agent;
import com.satyendra.phonepe.models.IssueStatus;
import com.satyendra.phonepe.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Map;

@SpringBootApplication
public class PhonepeApplication {

	public static void main(String[] args) {


		System.out.println("Started!!");
		AgentService agentService = new AgentServiceImpl();
		AssignStrategy assignStrategy = new AssignToFirstAvailableAgent();
		IssueService issueService = new IssueServiceImpl(agentService, assignStrategy);
		issueService.createIssue("T1", "Payment Related", "Payment Failed", "My payment failed but money is debited", "testUser1@test.com");
		issueService.createIssue("T2", "Mutual Fund Related", "Purchase Failed", "Unable to purchase Mutual Fund", "testUser2@test.com");
		issueService.createIssue("T3", "Payment Related", "Payment Failed", "My payment failed but money is debited","testUser2@test.com");

		agentService.addAgent("agent1@test.com","Agent 1", Arrays.asList("Payment Related", "Gold Related"));
		agentService.addAgent("agent2@test.com", "Agent 2", Arrays.asList("Payment Related", "Mutual Fund Related"));

		issueService.assignIssue("I1");
		issueService.assignIssue("I2");
		issueService.assignIssue("I3");

		issueService.viewAgentsWorkHistory();

		System.out.println("--------");
		issueService.getIssues(Map.of("email", "testUser2@test.com"));
		System.out.println("--------");
		issueService.getIssues(Map.of("type", "Payment Related"));
		System.out.println("--------");

		issueService.updateIssue("I3", IssueStatus.IN_PROGRESS, "Waiting for payment confirmation");

		issueService.resolveIssue("I3", "PaymentFailed debited amount will get reversed");
		issueService.resolveIssue("I1", "PaymentFailed debited amount will get reversed");

		issueService.viewAgentsWorkHistory();
		System.out.println("Finished!!");
	}

}
