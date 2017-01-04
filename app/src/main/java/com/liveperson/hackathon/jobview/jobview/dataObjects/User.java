package com.liveperson.hackathon.jobview.jobview.dataObjects;

import java.util.List;
import java.util.UUID;

/**
 * Created by liorr on 1/4/17.
 */

public class User {
    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;
    private List<OccupationalDomain> occupationalDomainsList;
    private List<UUID> answeredQuestions;

    public User() {
        userId = UUID.randomUUID();
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<OccupationalDomain> getOccupationalDomainsList() {
        return occupationalDomainsList;
    }

    public void setOccupationalDomainsList(List<OccupationalDomain> occupationalDomainsList) {
        this.occupationalDomainsList = occupationalDomainsList;
    }

    public List<UUID> getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(List<UUID> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }
}
