package com.liveperson.hackathon.jobview.jobview.dataObjects;

import java.util.List;
import java.util.UUID;

/**
 * Created by liorr on 1/4/17.
 */

public class Question {
    private UUID questionId;
    private String questionText;
    private UUID positiveSystemAnswer;
    private UUID negativeSystemAnswer;
    private List<UUID> userAnswerIdsList;

    public Question() {
        questionId = UUID.randomUUID();
    }

    public UUID getQuestionId() {
        return questionId;
    }

    public void setQuestionId(UUID questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public UUID getPositiveSystemAnswer() {
        return positiveSystemAnswer;
    }

    public void setPositiveSystemAnswer(UUID positiveSystemAnswer) {
        this.positiveSystemAnswer = positiveSystemAnswer;
    }

    public UUID getNegativeSystemAnswer() {
        return negativeSystemAnswer;
    }

    public void setNegativeSystemAnswer(UUID negativeSystemAnswer) {
        this.negativeSystemAnswer = negativeSystemAnswer;
    }

    public List<UUID> getUserAnswerIdsList() {
        return userAnswerIdsList;
    }

    public void setUserAnswerIdsList(List<UUID> userAnswerIdsList) {
        this.userAnswerIdsList = userAnswerIdsList;
    }
}
