package com.liveperson.hackathon.jobview.jobview.ui;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.liveperson.hackathon.jobview.jobview.R;
import com.liveperson.hackathon.jobview.jobview.controller.SessionManager;
import com.liveperson.hackathon.jobview.jobview.dataObjects.ReviewMetric;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewFragment extends DialogFragment {


    public ReviewFragment() {
        // Required empty public constructor
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_review, null);

        SessionManager sessionManager = SessionManager.getInstance();
        ArrayList<ReviewMetric> reviewMetricsList = sessionManager.getAllReviewMetrics();


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(inflater.inflate(R.layout.fragment_review, null));

        ListView lv = (ListView) view.findViewById(R.id.reviewMetricListView);
        lv.setAdapter(new ReviewMetricAdapter(getContext(), reviewMetricsList));


        builder.setPositiveButton("הוספה", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // TODO send the data
                    }
                })
                .setNegativeButton("ביטול", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Do nothing
                    }
                });

        // Create the AlertDialog object and return it
        return builder.create();
    }
}