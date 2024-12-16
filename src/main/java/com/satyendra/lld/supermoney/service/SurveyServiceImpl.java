package com.satyendra.supermoney.service;

import com.satyendra.supermoney.model.Survey;
import com.satyendra.supermoney.model.SurveyStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    private Map<Integer, Survey> surveyMap;

    public SurveyServiceImpl() {
        this.surveyMap = new HashMap<>();
    }

    @Override
    public void createSurvey(Survey newSurvey) {
        Survey survey = surveyMap.get(newSurvey.getId());
        if(survey != null) {
            System.out.println("survey id : " + survey.getId() + "already exists");
        } else {
            surveyMap.put(newSurvey.getId(), newSurvey);
        }
    }

    @Override
    public Survey getSurvey(int surveyId) {
        Survey survey = surveyMap.get(surveyId);
        if(survey == null) {
            System.out.println("survey id : " + surveyId + "doesn't exists");
            return null;
        }
        return survey;
    }

    @Override
    public boolean isSurveyActive(int surveyId) {
        Survey survey = surveyMap.get(surveyId);
        if(survey == null) {
            System.out.println("survey id : " + surveyId + "doesn't exists");
            return false;
        }
        return survey.getStatus() == SurveyStatus.ACTIVE && survey.isSurveyActive();
    }



}
