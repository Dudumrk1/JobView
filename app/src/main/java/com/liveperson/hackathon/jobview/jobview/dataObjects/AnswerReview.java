package com.liveperson.hackathon.jobview.jobview.dataObjects;

import android.util.Pair;

import java.util.List;
import java.util.UUID;

/**
 * Created by liorr on 1/4/17.
 */

public class AnswerReview {
    private UUID reviewId;
    private UUID reviewerUserId;
    private List<UUID> AnswerReviewElementsList;

    public AnswerReview() {
        reviewId = UUID.randomUUID();
    }
}
