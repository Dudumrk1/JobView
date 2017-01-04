package com.liveperson.hackathon.jobview.jobview.dataObjects;

import java.util.List;
import java.util.UUID;

/**
 * Created by liorr on 1/4/17.
 */

public class Question {
    private String questionId;
    private String questionText;
    private String positiveSystemAnswer;
    private String negativeSystemAnswer;
    private List<String> userAnswerIdsList;

    public Question() {
        questionId = UUID.randomUUID().toString();
    }

    public Question(String questionText, String positiveSystemAnswer, String negativeSystemAnswer, List<String> userAnswerIdsList){
        questionId = UUID.randomUUID().toString();
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

    public String getPositiveSystemAnswer() {
        return positiveSystemAnswer;
    }

    public void setPositiveSystemAnswer(String positiveSystemAnswer) {
        this.positiveSystemAnswer = positiveSystemAnswer;
    }

    public String getNegativeSystemAnswer() {
        return negativeSystemAnswer;
    }

    public void setNegativeSystemAnswer(String negativeSystemAnswer) {
        this.negativeSystemAnswer = negativeSystemAnswer;
    }

    public List<String> getUserAnswerIdsList() {
        return userAnswerIdsList;
    }

    public void setUserAnswerIdsList(List<String> userAnswerIdsList) {
        this.userAnswerIdsList = userAnswerIdsList;
    }
}
