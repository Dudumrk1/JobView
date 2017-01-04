package com.liveperson.hackathon.jobview.jobview.dataObjects;

import java.util.List;
import java.util.UUID;

/**
 * Created by liorr on 1/4/17.
 */

public class OccupationalDomain {
    String domainId;
    String domainName;
    List<String> questionIdsList;

    public OccupationalDomain() {
        domainId = UUID.randomUUID().toString();
    }

    public OccupationalDomain(String domainName) {
        this.domainName = domainName;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public List<String> getQuestionIdsList() {
        return questionIdsList;
    }

    public void setQuestionIdsList(List<String> questionIdsList) {
        this.questionIdsList = questionIdsList;
    }
}
