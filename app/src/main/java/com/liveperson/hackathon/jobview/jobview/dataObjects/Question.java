package com.liveperson.hackathon.jobview.jobview.dataObjects;

import java.util.List;
import java.util.UUID;

/**
 * Created by liorr on 1/4/17.
 */

public class Question {
    private String questionId;
    private String questionText;
    // Id of positive answer
    private String positiveSystemAnswerId;
    // Id of negative answer
    private String negativeSystemAnswerId;
    //List of user answer ids
    private List<String> userAnswerIdsList;

    public Question() {
        questionId = UUID.randomUUID().toString();
    }

    public Question(String questionText, String positiveSystemAnswer, String negativeSystemAnswer, List<String> userAnswerIdsList){
        questionId = UUID.randomUUID().toString();
        this.questionText = questionText;
        this.positiveSystemAnswerId = positiveSystemAnswer;
        this.negativeSystemAnswerId = negativeSystemAnswer;
        this.userAnswerIdsList = userAnswerIdsList;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getPositiveSystemAnswerId() {
        return positiveSystemAnswerId;
    }

    public void setPositiveSystemAnswerId(String positiveSystemAnswerId) {
        this.positiveSystemAnswerId = positiveSystemAnswerId;
    }

    public String getNegativeSystemAnswerId() {
        return negativeSystemAnswerId;
    }

    public void setNegativeSystemAnswerId(String negativeSystemAnswerId) {
        this.negativeSystemAnswerId = negativeSystemAnswerId;
    }

    public List<String> getUserAnswerIdsList() {
        return userAnswerIdsList;
    }

    public void setUserAnswerIdsList(List<String> userAnswerIdsList) {
        this.userAnswerIdsList = userAnswerIdsList;
    }
}
