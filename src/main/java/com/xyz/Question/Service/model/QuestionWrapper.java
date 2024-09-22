package com.xyz.Question.Service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data


public class QuestionWrapper {
    @Id
    private Integer id;
    private String ques;
    private String a;
    private String b;
    private String c;

    public QuestionWrapper() {
    }

    public QuestionWrapper(Integer id, String ques, String a, String b, String c) {
        this.id = id;
        this.ques = ques;
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
