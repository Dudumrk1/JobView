package com.liveperson.hackathon.jobview.jobview.dataObjects;

import java.util.UUID;

/**
 * Created by liorr on 1/4/17.
 */

public class ReviewMetric {
    private UUID reviewMetricId;
    private String reviewMetricText;

    public ReviewMetric(String reviewMetricText) {
        reviewMetricId = UUID.randomUUID();
        this.reviewMetricText = reviewMetricText;
    }

    public UUID getReviewMetricId() {
        return reviewMetricId;
    }

    public void setReviewMetricId(UUID reviewMetricId) {
        this.reviewMetricId = reviewMetricId;
    }

    public String getReviewMetricText() {
        return reviewMetricText;
    }

    public void setReviewMetricText(String reviewMetricText) {
        this.reviewMetricText = reviewMetricText;
    }
}
