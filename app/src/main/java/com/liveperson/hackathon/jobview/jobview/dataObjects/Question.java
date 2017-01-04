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
}
