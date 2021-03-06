package com.liveperson.hackathon.jobview.jobview.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.liveperson.hackathon.jobview.jobview.R;
import com.liveperson.hackathon.jobview.jobview.controller.SessionManager;
import com.liveperson.hackathon.jobview.jobview.dataObjects.OccupationalDomain;
import com.liveperson.hackathon.jobview.jobview.dataObjects.Question;

import java.util.ArrayList;


public class TrainingActivity extends BaseDrawerActivity {

    ArrayList<ListItem> questionsView = new ArrayList<>();
    private ListItemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the drawer as well
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_training, null, false);
        drawer.addView(contentView, 0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<ListItem> questionsViewTmp =  new ArrayList<>();
        questionsViewTmp.add(new ListHeader("כללי"));

        ArrayList<Question> questions = new ArrayList<>();
        ArrayList<Question> generalQuestions = SessionManager.getInstance().fetchGeneralQuestions();
        for (Question q : generalQuestions){
            questionsViewTmp.add(new QuestionItemView(q));
        }

        OccupationalDomain userDomain = SessionManager.getInstance().getUserDomain();
        if (userDomain != null && !"כללי".equals(userDomain.getDomainName())) {
            questions = SessionManager.getInstance().fetchQuestionsByDomain(userDomain.getDomainName());
            if (!questions.isEmpty()){

                questionsViewTmp.add(new ListHeader(userDomain.getDomainName()));

                for (Question q : questions){
                    questionsViewTmp.add(new QuestionItemView(q));
                }
            }
        }

        questionsView = questionsViewTmp;

        ListView mListView = (ListView)findViewById(R.id.questions_list);
        mAdapter = new ListItemAdapter(getApplicationContext(), questionsView);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), SingleQuestionActivity.class);
                i.putExtra("QuestionId", mAdapter.getItem(position).getKey());
                startActivity(i);
            }
        });
    }

}


