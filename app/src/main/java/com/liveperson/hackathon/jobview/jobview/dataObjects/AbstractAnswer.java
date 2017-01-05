package com.liveperson.hackathon.jobview.jobview.dataObjects;

import java.util.List;
import java.util.UUID;

/**
 * Created by liorr on 1/4/17.
 */

public abstract class AbstractAnswer {

    protected String answerId;
    protected String answerVideoId;
    protected String answerText;

    public String  getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String  getAnswerVideoId() {
        return answerVideoId;
    }

    public void setAnswerVideoId(String answerVideoId) {
        this.answerVideoId = answerVideoId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

}
