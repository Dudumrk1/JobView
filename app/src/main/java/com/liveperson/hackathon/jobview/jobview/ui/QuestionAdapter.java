package com.liveperson.hackathon.jobview.jobview.ui;

/**
 * Created by dudu on 1/5/17.
 */

import android.support.v7.widget.RecyclerView;

import com.liveperson.hackathon.jobview.jobview.dataObjects.Question;
import com.liveperson.hackathon.jobview.jobview.dataObjects.QuestionItemView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Adapter holding a list of animal names of type String. Note that each item must be unique.
 */
public abstract class QuestionAdapter<VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH> {
    private ArrayList<QuestionItemView> items = new ArrayList<QuestionItemView>();

    public QuestionAdapter() {
        setHasStableIds(true);
    }

    public void add(QuestionItemView object) {
        items.add(object);
        notifyDataSetChanged();
    }

    public void add(int index, QuestionItemView object) {
        items.add(index, object);
        notifyDataSetChanged();
    }

    public void addAll(Collection<? extends QuestionItemView> collection) {
        if (collection != null) {
            items.addAll(collection);
            notifyDataSetChanged();
        }
    }

    public void addAll(QuestionItemView... items) {
        addAll(Arrays.asList(items));
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public void remove(QuestionItemView object) {
        items.remove(object);
        notifyDataSetChanged();
    }

    public QuestionItemView getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}