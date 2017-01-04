package com.liveperson.hackathon.jobview.jobview.ui;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.liveperson.hackathon.jobview.jobview.R;

public class VideoRecordingActivity extends BaseDrawerActivity {
    static final int REQUEST_VIDEO_CAPTURE = 1;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_video_recording, null, false);
        drawer.addView(contentView, 0);


//        setContentView(R.layout.activity_video_recording);


//        //Hide record layout buttons
//        Button audioLayoutButton = (Button) findViewById(R.id.moveToRecordLayout);
//        audioLayoutButton.setVisibility(View.GONE);
//        Button videoLayoutButton = (Button) findViewById(R.id.moveToRecordVideoLayout);
//        videoLayoutButton.setVisibility(View.GONE);

        mButton = (Button) findViewById(R.id.recordVideo);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakeVideoIntent();
            }
        });

    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        //Hide recording layout buttons:
//        Button audioLayoutButton = (Button) findViewById(R.id.moveToRecordLayout);
//        audioLayoutButton.setVisibility(View.GONE);
//        Button videoLayoutButton = (Button) findViewById(R.id.moveToRecordVideoLayout);
//        videoLayoutButton.setVisibility(View.GONE);
//    }


    private void dispatchTakeVideoIntent() {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }
}
