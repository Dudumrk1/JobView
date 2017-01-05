package com.liveperson.hackathon.jobview.jobview.dataObjects;

import android.net.Uri;

import java.util.List;
import java.util.UUID;

/**
 * Created by liorr on 1/4/17.
 */

public class UserAnswer extends AbstractAnswer {
    private List<String > answerReviewsIds;

    public UserAnswer(List<String > answerReviewsIds, Uri uriFile) {
        answerId = UUID.randomUUID().toString();
        this.uriFile = uriFile;
        this.answerReviewsIds = answerReviewsIds;
    }

    public void addReviewId(String reviewId){
        answerReviewsIds.add(reviewId);
    }
}
