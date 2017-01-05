package com.liveperson.hackathon.jobview.jobview.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.liveperson.hackathon.jobview.jobview.R;
import com.liveperson.hackathon.jobview.jobview.dataObjects.ReviewMetric;

import java.util.ArrayList;

/**
 * Created by liorr on 1/5/17.
 */

public class ReviewMetricAdapter extends ArrayAdapter<ReviewMetric> {

//    private static class ViewHolder {
//        private TextView itemView;
//        private RatingBar ratingBar;
//    }


    @Override
    public int getCount() {
        return items.size();
    }

    Context context;
    ArrayList<ReviewMetric> items;

    public ReviewMetricAdapter(Context context, ArrayList<ReviewMetric> items) {
        super(context, 0, items);
        this.context = context;
        this.items = items;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder viewHolder;
        ReviewMetric item = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.metric_row, parent, false);
        }

        TextView itemView = (TextView) convertView.findViewById(R.id.reviewMetricText);
        RatingBar ratingBar = (RatingBar) convertView.findViewById(R.id.reviewMetricRatingBar);

        if (item != null) {
            itemView.setText(item.getReviewMetricText());
        }

        return convertView;
    }

    /*
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext())
                    .inflate(R.layout.metric_row, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.itemView = (TextView) convertView.findViewById(R.id.reviewMetricText);
            viewHolder.ratingBar = (RatingBar) convertView.findViewById(R.id.reviewMetricRatingBar);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ReviewMetric item = getItem(position);
        if (item != null) {
            viewHolder.itemView.setText(item.getReviewMetricText());
        }

        return convertView;
    }
     */
}