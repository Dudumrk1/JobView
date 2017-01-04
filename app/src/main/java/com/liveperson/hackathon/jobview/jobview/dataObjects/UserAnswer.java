package com.liveperson.hackathon.jobview.jobview.dataObjects;

import java.util.List;
import java.util.UUID;

/**
 * Created by liorr on 1/4/17.
 */

public class UserAnswer extends AbstractAnswer {
    private List<String > answerReviewsIds;

    public UserAnswer(List<String > answerReviewsIds) {
        answerId = UUID.randomUUID().toString();
        this.answerReviewsIds = answerReviewsIds;
    }
}
