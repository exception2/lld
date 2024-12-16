package com.satyendra.supermoney.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class UserResponse {

    private int userId;
    private int surveyId;
    private Map<Integer, String> responses; // questionId -> answer
    private int currentPageId;
    private UserSurveyStatus status;

    public UserResponse(int userId, int surveyId, Map<Integer, String> responses, int currentPageId) {
        this.userId = userId;
        this.surveyId = surveyId;
        this.responses = responses == null ? new HashMap<>() : responses;
        this.currentPageId = currentPageId;
        this.status = UserSurveyStatus.STARTED;
    }

    public void saveUserResponse(int questionId, String answer) {
        this.responses.put(questionId, answer);
    }

}
