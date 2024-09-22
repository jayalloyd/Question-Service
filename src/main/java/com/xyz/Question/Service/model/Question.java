package com.xyz.Question.Service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Question{
    @Id
    private Integer id;
    private String ques;
    private String a;
    private String b;
    private String c;
    private String category;
    
    private String rightAnswer;

}
