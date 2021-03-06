package com.liveperson.hackathon.jobview.jobview.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.liveperson.hackathon.jobview.jobview.R;
import com.liveperson.hackathon.jobview.jobview.controller.SessionManager;
import com.liveperson.hackathon.jobview.jobview.dataObjects.AbstractAnswer;
import com.liveperson.hackathon.jobview.jobview.dataObjects.Question;
import com.ms.square.android.expandabletextview.ExpandableTextView;

public class SingleQuestionActivity extends BaseDrawerActivity {
    static boolean isTextViewClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_single_question, null, false);
        drawer.addView(contentView, 0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView singleQuestionText = (TextView) findViewById(R.id.singleQuestionText);

        SessionManager sessionManager = SessionManager.getInstance();

        final String questionId = getIntent().getStringExtra("QuestionId");
        Question question = sessionManager.getQuestionById(questionId);

        // Question text
        String questionText = question.getQuestionText();
        singleQuestionText.setText(questionText);

        // Positive and negative
        String negativeAnswerId = question.getNegativeSystemAnswerId();
        AbstractAnswer abstractAnswer = sessionManager.getAnswerById(negativeAnswerId);
        ExpandableTextView expTv1 = (ExpandableTextView) findViewById(R.id.expand_text_view_negative);
        expTv1.setText(abstractAnswer.getAnswerText());

        String positiveAnswerId = question.getPositiveSystemAnswerId();
        abstractAnswer = sessionManager.getAnswerById(positiveAnswerId);
        ExpandableTextView expTv2 = (ExpandableTextView) findViewById(R.id.expand_text_view_positive);
        expTv2.setText(abstractAnswer.getAnswerText());

        // Try it
        Button tryItButton = (Button) findViewById(R.id.singleQuestionTry);
        tryItButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), VideoRecordingActivity.class);
                i.putExtra("QuestionId", questionId);
                startActivity(i);
            }
        });

        // Others
        Button othersButton = (Button) findViewById(R.id.singleQuestionOthers);
        othersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CrowdAnswersActivity.class);
                i.putExtra("QuestionId", questionId);
                startActivity(i);
            }
        });
    }
}
