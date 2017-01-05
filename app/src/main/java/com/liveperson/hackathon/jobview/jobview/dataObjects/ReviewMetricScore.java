package com.liveperson.hackathon.jobview.jobview.dataObjects;

import java.util.UUID;

/**
 * Created by liorr on 1/4/17.
 */

public class ReviewMetricScore {
    private String id;
    private String metricId;
    private int reviewMetricScore;
    private String reviewMetricText;

    public ReviewMetricScore(String metricId, int score) {
        id = UUID.randomUUID().toString();
        this.metricId = metricId;
        reviewMetricScore = score;

    }

    public String getMetricId() {
        return metricId;
    }

    public void setMetricId(String metricId) {
        this.metricId = metricId;
    }

    public int getReviewMetricScore() {
        return reviewMetricScore;
    }

    public void setReviewMetricScore(int reviewMetricScore) {
        this.reviewMetricScore = reviewMetricScore;
    }

    public String getReviewMetricText() {
        return reviewMetricText;
    }

    public void setReviewMetricText(String reviewMetricText) {
        this.reviewMetricText = reviewMetricText;
    }

    public String getId(){
        return id;
    }
}
