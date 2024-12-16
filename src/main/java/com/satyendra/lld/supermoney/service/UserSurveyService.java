package com.satyendra.supermoney.service;

import com.satyendra.supermoney.model.Survey;
import com.satyendra.supermoney.model.UserSurveyResponse;
import com.satyendra.supermoney.model.UserSurveyStatus;

import java.util.Map;
import java.util.Set;

public interface UserSurveyService {

    UserSurveyResponse createUserSurvey(int surveyId, int userId);
    UserSurveyResponse getUserSurvey(int surveyId, int userId);

    UserSurveyResponse updateUserSurvey(int surveyId, int userId, int questionId, String answer, UserSurveyStatus status);

    Map<String, Integer> generateAnalytics(int surveyId);
}
