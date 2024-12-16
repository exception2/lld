package com.satyendra.supermoney.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSurveyResponse {

    private Survey survey;
    private UserResponse userResponse;
}
