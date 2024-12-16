package com.satyendra.supermoney;

import com.satyendra.supermoney.model.*;
import com.satyendra.supermoney.service.SurveyService;
import com.satyendra.supermoney.service.SurveyServiceImpl;
import com.satyendra.supermoney.service.UserSurveyService;
import com.satyendra.supermoney.service.UserSurveyServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SupermoneyApplication {

	/*
	* Dynamic Multi-Step Survey Form
	Description
	Develop a dynamic multi-step survey form application that allows users to complete the survey in multiple sessions, resuming where they left off. The form should be able to branch based on user input and provide a preview feature at any stage.
Key Requirements - SDE 2 & 3
Multi-Step Form with Conditional Branching: The survey should consist of multiple steps/pages. Based on the responses, the next set of questions may vary (conditional branching).
Save and Resume: Users may not complete the survey in one go. Implement a feature to save the current state of the survey so that the user can resume from the same point later.
Preview Feature: At any point, the user should be able to preview the responses provided so far.
New surveys onboarding: Admin should be able to onboard new surveys.
Key Requirements - Only for SDE 3
Survey life cycle: Surveys should have a life cycle. Post expiry users shouldn’t be able to see or fill the survey.
Question-Answer format with skip functionality: Assume every question in the survey will have few options / text / numerical input as possible answers. Users will be choosing one of the answers or can skip the question altogether.
Advanced Features (Bonus) - Only for SDE2
Survey life cycle: Surveys should have a life cycle. Post expiry users shouldn’t be able to see or fill the survey.
Question-Answer format with skip functionality: Assume every question in the survey will have few options / text / numerical input as possible answers. Users will be choosing one of the answers or can skip the question altogether.
Advanced Features (Bonus) - Only for SDE3
Analytics: Generate a summary or analytics of the survey responses after submission.
Survey level analytics
Page (within survey) level analytics
*/
	public static void main(String[] args) {
		System.out.println("Started!!");
		// SpringApplication.run(SupermoneyApplication.class, args);

		SurveyService surveyService = new SurveyServiceImpl();
		UserSurveyService userSurveyService = new UserSurveyServiceImpl(surveyService);
		List<Question> questionsP1 = new ArrayList<>();
		questionsP1.add(new Question(1, "question1", false, List.of("option1", "option2"), AnswerInputType.TEXT));
		questionsP1.add(new Question(2, "question2", false, List.of("option3", "option3"), AnswerInputType.TEXT));

		List<Question> questionsP2 = new ArrayList<>();
		questionsP2.add(new Question(3, "question1", false, List.of("option1", "option2"), AnswerInputType.TEXT));
		questionsP2.add(new Question(4, "question2", false, List.of("option3", "option3"), AnswerInputType.TEXT));
		List<SurveyPage> pages = new ArrayList<>();
		pages.add(new SurveyPage(1, 1, "page 1", questionsP1));
		pages.add(new SurveyPage(2, 2, "page 2", questionsP2));

		Date startDate = new Date();
		Date endDate = new Date(startDate.getTime() + 10000);
		surveyService.createSurvey(new Survey(1, "survey1", pages, startDate, endDate, SurveyStatus.ACTIVE));
		Survey survey = surveyService.getSurvey(1);
		int userId = 100;
		userSurveyService.createUserSurvey(survey.getId(), userId);
		UserSurveyResponse userSurveyResponse = userSurveyService.getUserSurvey(survey.getId(), userId);
		printData(userSurveyResponse);
		userSurveyService.updateUserSurvey(survey.getId(), userId, 1, "option1", UserSurveyStatus.INPROGRESS);
		userSurveyService.updateUserSurvey(survey.getId(), userId, 3, "option3", UserSurveyStatus.INPROGRESS);
		userSurveyResponse = userSurveyService.getUserSurvey(survey.getId(), userId);
		printData(userSurveyResponse);
		survey.setStatus(SurveyStatus.ENDED);
		System.out.println("Finished!!");
	}

	public static void printData(UserSurveyResponse userSurveyResponse) {
		System.out.println("Survey title :" + userSurveyResponse.getSurvey().getTitle());
		for(SurveyPage page : userSurveyResponse.getSurvey().getPages()) {
			System.out.println("page title : " + page.getTitle());
			for(Question question : page.getQuestions()) {
				System.out.println("Question : " + question.getTitle() + " Options : " + question.getOptions());
			}
		}

		System.out.println("answers :");
		UserResponse userResponse = userSurveyResponse.getUserResponse();

		for(Map.Entry<Integer, String> entry : userResponse.getResponses().entrySet()) {
			System.out.println("questionId : " + entry.getKey() + ", answer : " + entry.getValue());
		}
	}

}
