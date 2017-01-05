package com.liveperson.hackathon.jobview.jobview.dataObjects;

import java.util.UUID;

/**
 * Created by liorr on 1/4/17.
 */

public class SystemAnswer extends AbstractAnswer {

    public SystemAnswer() {
        answerId = UUID.randomUUID().toString();
    }
    public SystemAnswer(String answerText, String answerVideoId) {
        super.answerText = answerText;
       super.answerVideoId = answerVideoId;

    }

}
