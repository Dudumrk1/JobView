package com.liveperson.hackathon.jobview.jobview.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.liveperson.hackathon.jobview.jobview.R;
import com.liveperson.hackathon.jobview.jobview.dataObjects.ReviewMetric;

import static android.view.View.TEXT_DIRECTION_RTL;

/**
 * Created by dudu on 1/5/17.
 */

public class MetricItemView implements ListItem {
    ReviewMetric metric;

    public MetricItemView(ReviewMetric metric) {
        this.metric = metric;
    }

    @Override
    public String getKey() {
        return metric.getReviewMetricId();
    }

    @Override
    public String getValue() {
        return metric.getReviewMetricText();
    }

    @Override
    public String getType() {
        return "metric";
    }

    @Override
    public int getViewType() {
        return ListItemAdapter.RowType.LIST_ITEM.ordinal();
    }

    @Override
    public View getView(LayoutInflater inflater, View convertView) {
        View view;
        if (convertView == null) {
            view = (View) inflater.inflate(R.layout.metric_row, null);
            // Do some initialization
        } else {
            view = convertView;
        }

        TextView textView = (TextView) view.findViewById(R.id.reviewMetricText);
        textView.setText(metric.getReviewMetricText());
        textView.setTextDirection(TEXT_DIRECTION_RTL);

        return view;
    }
}
