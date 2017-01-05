package com.liveperson.hackathon.jobview.jobview.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.liveperson.hackathon.jobview.jobview.R;

public class TrainingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        final ListView listview = (ListView) findViewById(R.id.listViewHR);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         String[] HRDomainQuestions = getResources().getStringArray(R.array.domainQuestionsHR);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
