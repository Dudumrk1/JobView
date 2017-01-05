package com.liveperson.hackathon.jobview.jobview.ui;

import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by ykarasik on 7/22/14.
 */
public interface ListItem {
    String getKey();
    String getValue();
    String getType();
    int getViewType();
    View getView(LayoutInflater inflater, View convertView);
}