package com.liveperson.hackathon.jobview.jobview.dataObjects;

import java.util.UUID;

/**
 * Created by litalh on 1/5/17.
 */

public class AnsweredQuestion {

    private String id;
    private String questionId;
    private String answerId;

    public AnsweredQuestion(){
        id = UUID.randomUUID().toString();
    }

    public AnsweredQuestion(String questionId, String answerId){
        this.questionId = questionId;
        this.answerId = answerId;

    }

    public String getId (){
        return this.id;

    }
}
