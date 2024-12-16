package com.satyendra.supermoney.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class Survey {

    private int id;
    private String title;
    private List<SurveyPage> pages;
    private Date startDate;
    private Date exipyDate;
    private SurveyStatus status;

    public boolean isSurveyActive() {
        Date currentDate = new Date();
        return currentDate.after(startDate) && currentDate.before(exipyDate) && SurveyStatus.ACTIVE == status;
    }

    public void addPage(SurveyPage surveyPage) {
        this.pages.add(surveyPage);
    }
}
