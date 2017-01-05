package com.liveperson.hackathon.jobview.jobview.ui;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.liveperson.hackathon.jobview.jobview.R;
import com.liveperson.hackathon.jobview.jobview.controller.SessionManager;
import com.liveperson.hackathon.jobview.jobview.dataObjects.ReviewMetric;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewFragment extends DialogFragment {

    private ListItemAdapter mAdapter;
    ArrayList<ListItem> metricRowsView = new ArrayList<>();

    public ReviewFragment() {
        // Required empty public constructor
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_review, null);

        ListView mListView = (ListView)view.findViewById(R.id.reviewMetricListView);

        SessionManager sessionManager = SessionManager.getInstance();
        ArrayList<ListItem> metricRowsViewTmp = new ArrayList<>();
        for(ReviewMetric rm: sessionManager.getAllReviewMetrics()){
            metricRowsViewTmp.add(new MetricItemView(rm));
        }

        metricRowsView = metricRowsViewTmp;

        mAdapter = new ListItemAdapter(getActivity(), metricRowsView);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), SingleQuestionActivity.class);
                i.putExtra("QuestionId", mAdapter.getItem(position).getKey());
                startActivity(i);
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setPositiveButton("הוספה", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // TODO send the data
            }
        })
        .setNegativeButton("ביטול", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Do nothing
            }
        }).setView(view);

        return builder.create();
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setView(inflater.inflate(R.layout.fragment_review, null));
//
////        ListView lv = (ListView) view.findViewById(R.id.reviewMetricListView);
////        lv.setAdapter(new ReviewMetricAdapter(getContext(), reviewMetricsList));
//
//
//
//
//        builder.setPositiveButton("הוספה", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        // TODO send the data
//                    }
//                })
//                .setNegativeButton("ביטול", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        // Do nothing
//                    }
//                });
//
//        // Create the AlertDialog object and return it
//        return builder.create();
    }
}