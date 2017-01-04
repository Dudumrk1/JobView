package com.liveperson.hackathon.jobview.jobview.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.liveperson.hackathon.jobview.jobview.R;

public class RecordingButtonsActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording_buttons);

        Button moveToRecorder = (Button) findViewById(R.id.moveToRecordLayout);
        moveToRecorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_audio_recording_trial);
                Intent i = new Intent(RecordingButtonsActivity.this, AudioRecordingActivity.class);
                startActivity(i);
            }
        });

        Button moveToVideoRecorder = (Button) findViewById(R.id.moveToRecordVideoLayout);
        moveToVideoRecorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setContentView(R.layout.activity_video_recording);
                Intent i = new Intent(RecordingButtonsActivity.this, VideoRecordingActivity.class);
                startActivity(i);
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return super.onNavigationItemSelected(item);
    }
}
