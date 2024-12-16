package com.satyendra.supermoney.service;

import com.satyendra.supermoney.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class UserSurveyServiceImpl implements UserSurveyService {

    private Map<String, UserResponse> userResponseMap;
    private final SurveyService surveyService;

    public UserSurveyServiceImpl(SurveyService surveyService) {
        this.userResponseMap = new HashMap<>();
        this.surveyService = surveyService;
    }

    @Override
    public UserSurveyResponse createUserSurvey(int surveyId, int userId) {
        String userSurveyKey = getUserSurveyKey(userId, surveyId);
        Survey survey = surveyService.getSurvey(surveyId);
        if(survey == null) {
            return null;
        }
        UserResponse userResponse = userResponseMap.get(userSurveyKey);
        if(userResponse != null) {
            System.out.println("Survey of userId : " + userId + " already exists with surveyId : " + surveyId);
            return new UserSurveyResponse(survey, userResponse);
        }
        int currentPageId = findFirstPageId(survey);
        userResponse = new UserResponse(userId, surveyId, new HashMap<>(), currentPageId);
        userResponseMap.put(userSurveyKey, userResponse);
        return new UserSurveyResponse(survey, userResponse);
    }

    @Override
    public UserSurveyResponse getUserSurvey(int surveyId, int userId) {
        String userSurveyKey = getUserSurveyKey(userId, surveyId);
        Survey survey = surveyService.getSurvey(surveyId);
        if(survey == null) {
            return null;
        }
        UserResponse userResponse = userResponseMap.get(userSurveyKey);
        if(userResponse == null) {
            System.out.println("No user response found! for userId : " + userId + " and surveyId : " + surveyId);
            return null;
        }
        return new UserSurveyResponse(survey, userResponse);
    }

    @Override
    public UserSurveyResponse updateUserSurvey(int surveyId, int userId, int questionId, String answer, UserSurveyStatus status) {
        String userSurveyKey = getUserSurveyKey(userId, surveyId);
        Survey survey = surveyService.getSurvey(surveyId);
        if(survey == null) {
            return null;
        }
        UserResponse userResponse = userResponseMap.get(userSurveyKey);
        if(userResponse == null) {
            System.out.println("No user response found! for userId : " + userId + " and surveyId : " + surveyId);
            return null;
        }
        if(userResponse.getStatus() == UserSurveyStatus.COMPLETED) {
            System.out.println("this survey already completed!");
            new UserSurveyResponse(survey, userResponse);
        }
        userResponse.getResponses().put(questionId, answer);
        userResponse.setStatus(status);
        return new UserSurveyResponse(survey, userResponse);
    }

    @Override
    public Map<String, Integer> generateAnalytics(int surveyId) {
        Map<String, Integer> answersOfUser = new TreeMap<>();
        for(UserResponse userResponse : userResponseMap.values()) {
            if(userResponse.getSurveyId() == surveyId) {
                for(String answer : userResponse.getResponses().values()) {
                    answersOfUser.put(answer, answersOfUser.getOrDefault(answer, 0) + 1);
                }
            }
        }
        return answersOfUser;
    }

    private String getUserSurveyKey(int userId, int surveyId) {
        return userId + "-" + surveyId;
    }

    private int findFirstPageId(Survey survey) {
        int surveyPageId = -1;
        int sequenceId = Integer.MAX_VALUE;
        for(SurveyPage page : survey.getPages()) {
            if(page.getSequenceId() < sequenceId) {
                sequenceId = page.getSequenceId();
                surveyPageId = page.getId();
            }
        }
        return surveyPageId;
    }
}
