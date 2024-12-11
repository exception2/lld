package com.satyendra.lld.issuemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Comment {

    private String id;
    private String authorId;
    private Date createdDate;
    private String message;
    private String issueId;
}
