package com.liveperson.hackathon.jobview.jobview.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import com.liveperson.hackathon.jobview.jobview.R;

import java.io.Serializable;

public class ListHeader implements ListItem, Serializable {
    private final String title;

    public ListHeader(String title) {
        this.title = title;
    }

    public ListHeader(String title, int imgResource) {
        this.title = title;
    }

    @Override
    public String getKey() {
        return "";
    }

    @Override
    public String getValue() { return ""; }

    @Override
    public String getType() { return "header"; }

    @Override
    public int getViewType() {
        return ListItemAdapter.RowType.HEADER_ITEM.ordinal();
    }

    @Override
    public View getView(LayoutInflater inflater, View convertView) {
        View view;
        if (convertView == null) {
            view = (View) inflater.inflate(R.layout.list_header, null);
            // Do some initialization
        } else {
            view = convertView;
        }

        TextView textView = (TextView) view.findViewById(R.id.list_header_text);
        textView.setText(title);

        return view;
    }
}