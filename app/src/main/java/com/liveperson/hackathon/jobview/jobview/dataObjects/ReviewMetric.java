package com.liveperson.hackathon.jobview.jobview.dataObjects;

import java.util.UUID;

/**
 * Created by liorr on 1/4/17.
 */

public class ReviewMetric {
    private String reviewMetricId;
    private String reviewMetricText;

    public ReviewMetric(String reviewMetricText) {
        reviewMetricId = UUID.randomUUID().toString();
        this.reviewMetricText = reviewMetricText;
    }

    public String getReviewMetricId() {
        return reviewMetricId;
    }

    public void setReviewMetricId(String reviewMetricId) {
        this.reviewMetricId = reviewMetricId;
    }

    public String getReviewMetricText() {
        return reviewMetricText;
    }

    public void setReviewMetricText(String reviewMetricText) {
        this.reviewMetricText = reviewMetricText;
    }
}
