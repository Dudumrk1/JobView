package com.liveperson.hackathon.jobview.jobview.dataObjects;

import java.util.List;

/**
 * Created by liorr on 1/4/17.
 */


public class User {
    private String mUserId;
    private String mName;
    private String mEmail;
    private OccupationalDomain mOccupationalDomains;
    private List<String> mAnsweredQuestions;

    public User (){

    }
    public User(String userId, String name, String email) {
        mUserId = userId;
        mName = name;
        mEmail = email;
    }

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String userId) {
        this.mUserId = userId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String name) {
        mName = name;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String email) {
        mEmail = email;
    }

    public OccupationalDomain getOccupationalDomains() {
        return mOccupationalDomains;
    }

    public void setOccupationalDomains(OccupationalDomain occupationalDomainsList) {
        mOccupationalDomains = occupationalDomainsList;
    }

    public List<String > getAnsweredQuestions() {
        return mAnsweredQuestions;
    }

    public void setAnsweredQuestions(List<String > answeredQuestions) {
        mAnsweredQuestions = answeredQuestions;
    }

    public void setAnsweredQuestions(String answeredQuestions) {
        mAnsweredQuestions.add(answeredQuestions);
    }
}
