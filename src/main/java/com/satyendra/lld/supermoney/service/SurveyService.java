package com.satyendra.supermoney.service;

import com.satyendra.supermoney.model.Survey;

public interface SurveyService {

    void createSurvey(Survey newSurvey);
    Survey getSurvey(int surveyId);

    boolean isSurveyActive(int surveyId);

}
