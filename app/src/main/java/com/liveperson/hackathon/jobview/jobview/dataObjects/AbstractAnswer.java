package com.liveperson.hackathon.jobview.jobview.dataObjects;

import java.util.List;
import java.util.UUID;

/**
 * Created by liorr on 1/4/17.
 */

public abstract class AbstractAnswer {

    protected UUID answerId;
    protected UUID answerVideoId;
    protected String answerText;

    public UUID getAnswerId() {
        return answerId;
    }

    public void setAnswerId(UUID answerId) {
        this.answerId = answerId;
    }

    public UUID getAnswerVideoId() {
        return answerVideoId;
    }

    public void setAnswerVideoId(UUID answerVideoId) {
        this.answerVideoId = answerVideoId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }
}
