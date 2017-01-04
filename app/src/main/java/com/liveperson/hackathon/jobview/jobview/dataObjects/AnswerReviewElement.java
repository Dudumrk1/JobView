package com.liveperson.hackathon.jobview.jobview.dataObjects;

import java.util.UUID;

/**
 * Created by liorr on 1/4/17.
 */

public class AnswerReviewElement {
    UUID answerReviewElementId;
    UUID reviewMetric;
    UUID reviewMetricScore;

    public AnswerReviewElement() {
        answerReviewElementId = UUID.randomUUID();
    }

    public UUID getAnswerReviewElementId() {
        return answerReviewElementId;
    }

    public void setAnswerReviewElementId(UUID answerReviewElementId) {
        this.answerReviewElementId = answerReviewElementId;
    }

    public UUID getReviewMetric() {
        return reviewMetric;
    }

    public void setReviewMetric(UUID reviewMetric) {
        this.reviewMetric = reviewMetric;
    }

    public UUID getReviewMetricScore() {
        return reviewMetricScore;
    }

    public void setReviewMetricScore(UUID reviewMetricScore) {
        this.reviewMetricScore = reviewMetricScore;
    }
}
