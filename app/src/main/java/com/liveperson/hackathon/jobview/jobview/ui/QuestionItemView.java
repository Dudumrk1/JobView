package com.liveperson.hackathon.jobview.jobview.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.liveperson.hackathon.jobview.jobview.R;
import com.liveperson.hackathon.jobview.jobview.dataObjects.Question;

import static android.view.View.TEXT_DIRECTION_RTL;

/**
 * Created by dudu on 1/5/17.
 */

public class QuestionItemView implements ListItem {
    Question mQuestion;

    public QuestionItemView(Question question) {
        mQuestion = question;
    }

    public Question getQuestion() {
        return mQuestion;
    }

    @Override
    public String getKey() {
        return mQuestion.getQuestionId();
    }

    @Override
    public String getValue() {
        return mQuestion.getQuestionText();
    }

    @Override
    public String getType() {
        return "question";
    }

    @Override
    public int getViewType() {
        return ListItemAdapter.RowType.LIST_ITEM.ordinal();
    }

    @Override
    public View getView(LayoutInflater inflater, View convertView) {
        View view;
        if (convertView == null) {
            view = (View) inflater.inflate(R.layout.list_item, null);
            // Do some initialization
        } else {
            view = convertView;
        }

        TextView textView = (TextView) view.findViewById(R.id.list_item_text);
        textView.setText(mQuestion.getQuestionText());
        textView.setTextDirection(TEXT_DIRECTION_RTL);

        return view;
    }
}
