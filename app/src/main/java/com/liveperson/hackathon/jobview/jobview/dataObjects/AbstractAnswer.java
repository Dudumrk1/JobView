package com.liveperson.hackathon.jobview.jobview.dataObjects;

import android.net.Uri;

import java.util.List;
import java.util.UUID;

/**
 * Created by liorr on 1/4/17.
 */

public abstract class AbstractAnswer {

    protected String answerId;
    protected Uri uriFile;
    protected String answerText;

    public String  getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public Uri  getUriFile() {
        return uriFile;
    }

    public void setUriFile(Uri uriFile) {
        this.uriFile = uriFile;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

}
