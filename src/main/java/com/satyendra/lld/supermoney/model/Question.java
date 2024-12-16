package com.satyendra.supermoney.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Question {

    private int id;
    private String title;
    private List<String> options;
    private boolean isSkippable;
    private AnswerInputType answerInputType;

    public Question(int id, String title, boolean isSkippable, List<String> options, AnswerInputType type) {
        this.id = id;
        this.title = title;
        this.isSkippable = isSkippable;
        this.options = options == null ? new ArrayList<>() : options;
        this.answerInputType = type;
    }

    public void addOption(String option) {
        this.options.add(option);
    }
}
