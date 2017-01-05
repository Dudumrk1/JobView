package com.liveperson.hackathon.jobview.jobview.dataObjects;

import java.util.List;
import java.util.UUID;

/**
 * Created by liorr on 1/4/17.
 */

public class OccupationalDomain {
    long domainId;
    String domainName;
    List<UUID> questionIdsList;

    public OccupationalDomain(long domainId, String domainName) {
        this.domainName = domainName;
        this.domainId = domainId;
    }

    public OccupationalDomain(String domainName) {
        this.domainName = domainName;
    }

    public long getDomainId() {
        return domainId;
    }

    public void setDomainId(long domainId) {
        this.domainId = domainId;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public List<UUID> getQuestionIdsList() {
        return questionIdsList;
    }

    public void setQuestionIdsList(List<UUID> questionIdsList) {
        this.questionIdsList = questionIdsList;
    }
}
