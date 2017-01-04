package com.liveperson.hackathon.jobview.jobview.ui;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.liveperson.hackathon.jobview.jobview.R;

/**
 * Created by liorr on 1/4/17.
 */

public class GuidanceFragment extends Fragment {

    private int numPage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_guidance, container, false);

        TypedArray imagesArray = getResources().obtainTypedArray(R.array.guidanceImagesArray);
        String[] stringArray = getArguments().getStringArray("StringArray");
        numPage = getArguments().getInt("PageNumber");

        ImageView leftArrow = (ImageView) rootView.findViewById(R.id.guidanceLeftArrow);
        leftArrow.setImageDrawable((numPage == 0) ? getResources().getDrawable(R.drawable.left_arrow_inactive) :
                getResources().getDrawable(R.drawable.left_arrow_active));

        ImageView rightArrow = (ImageView) rootView.findViewById(R.id.guidanceRightArrow);
        rightArrow.setImageDrawable((numPage == stringArray.length - 1) ? getResources().getDrawable(R.drawable.right_arrow_inactive) :
                getResources().getDrawable(R.drawable.right_arrow_active));

        ImageView guidanceImage = (ImageView) rootView.findViewById(R.id.guidanceImage);
        guidanceImage.setImageResource(imagesArray.getResourceId(numPage, 0));

        TextView guidanceText = (TextView) rootView.findViewById(R.id.guidanceText);
        guidanceText.setText(stringArray[numPage]);

        imagesArray.recycle();
        return rootView;
    }
}
