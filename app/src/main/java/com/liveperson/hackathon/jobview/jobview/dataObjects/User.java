package com.liveperson.hackathon.jobview.jobview.dataObjects;

import java.util.List;
import java.util.UUID;

/**
 * Created by liorr on 1/4/17.
 */

public class User {
    private String  userId;
    private String mName;
    private String mEmail;
    private OccupationalDomain mOccupationalDomainsList;
    private List<String> mAnsweredQuestions;

    public User(String name, String email, OccupationalDomain occupationalDomain) {
        userId = UUID.randomUUID().toString();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public OccupationalDomain getOccupationalDomainsList() {
        return mOccupationalDomainsList;
    }

    public void setOccupationalDomainsList(OccupationalDomain occupationalDomainsList) {
        mOccupationalDomainsList = occupationalDomainsList;
    }

    public List<String > getAnsweredQuestions() {
        return mAnsweredQuestions;
    }

    public void setAnsweredQuestions(List<String > answeredQuestions) {
        mAnsweredQuestions = answeredQuestions;
    }
}
