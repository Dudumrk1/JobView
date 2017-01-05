package com.liveperson.hackathon.jobview.jobview.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import com.liveperson.hackathon.jobview.jobview.R;

import java.util.ArrayList;

public class ListItemAdapter extends ArrayAdapter<ListItem> {
    private LayoutInflater mInflater;

    public enum RowType {
        LIST_ITEM, HEADER_ITEM, PLACEHOLDER_ITEM
    }

    public ListItemAdapter(Context context, ArrayList<ListItem> items) {
        super(context, 0, items);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getViewTypeCount() {
        return RowType.values().length;

    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getViewType();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItem item = getItem(position);
        View view = item.getView(mInflater, convertView);
        View divider = view.findViewById(R.id.line_header_text);
        if (item.getViewType() == RowType.LIST_ITEM.ordinal()){
            divider.setVisibility(View.VISIBLE);
        }
        if (getCount() - 1 > position) {
            ListItem nextItem = getItem(position + 1);
            if (nextItem != null && nextItem.getViewType() == RowType.HEADER_ITEM.ordinal()) {

                if (divider != null) {
                    divider.setVisibility(View.GONE);
                }
            }
        }
        return view;
    }
}