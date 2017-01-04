package com.liveperson.hackathon.jobview.jobview.dataObjects;

import java.util.List;
import java.util.UUID;

/**
 * Created by liorr on 1/4/17.
 */

public class UserAnswer extends AbstractAnswer {
    private List<UUID> answerReviewsIds;

    public UserAnswer(List<UUID> answerReviewsIds) {
        super();
        this.answerReviewsIds = answerReviewsIds;
    }
}
