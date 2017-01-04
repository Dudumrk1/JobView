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
}
