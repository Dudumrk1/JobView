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

    public UUID getReviewId() {
        return reviewId;
    }

    public void setReviewId(UUID reviewId) {
        this.reviewId = reviewId;
    }

    public UUID getReviewerUserId() {
        return reviewerUserId;
    }

    public void setReviewerUserId(UUID reviewerUserId) {
        this.reviewerUserId = reviewerUserId;
    }

    public List<UUID> getAnswerReviewElementsList() {
        return AnswerReviewElementsList;
    }

    public void setAnswerReviewElementsList(List<UUID> answerReviewElementsList) {
        AnswerReviewElementsList = answerReviewElementsList;
    }
}
