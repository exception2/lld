package com.satyendra.supermoney.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class SurveyPage {

    private int id;
    private int sequenceId;
    private String title;
    private List<Question> questions;

    public SurveyPage(int id, int sequenceId, String title) {
        this.id = id;
        this.sequenceId = sequenceId;
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

}
