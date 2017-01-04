package com.liveperson.hackathon.jobview.jobview.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liveperson.hackathon.jobview.jobview.R;

/**
 * Created by liorr on 1/4/17.
 */

public class GuidanceFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_guidance, container, false);

        TextView textView = (TextView) rootView.findViewById(R.id.liorId);
        textView.setText(textView.getText() + " " + Integer.toString(getArguments().getInt("LiorNumber")));

        rootView.setBackgroundColor(getArguments().getInt("LiorNumber"));
        return rootView;
    }
}
