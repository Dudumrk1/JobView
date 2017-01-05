package com.liveperson.hackathon.jobview.jobview.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.liveperson.hackathon.jobview.jobview.R;

import java.io.File;
import java.io.IOException;

public class AudioRecordingActivity extends AppCompatActivity {
    Button mRecordButton;
    MediaRecorder mRecorder;
    String mFileName = null;
    TextView mRecordLabel;
//    StorageReference mStorage;
    private StorageReference mStorageRef;
    private ProgressDialog mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View contentView = inflater.inflate(R.layout.activity_audio_recording_trial, null, false);
//        drawer.addView(contentView, 0);
        setContentView(R.layout.activity_audio_recording_trial);

//        //hide record layout buttons
//        Button audioLayoutButton = (Button) findViewById(R.id.moveToRecordLayout);
//        audioLayoutButton.setVisibility(View.GONE);
//        Button videoLayoutButton = (Button) findViewById(R.id.moveToRecordVideoLayout);
//        videoLayoutButton.setVisibility(View.GONE);

        mRecordButton = (Button) findViewById(R.id.audioRecord);
        mRecordLabel = (TextView) findViewById(R.id.audioRecordLabel);
        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName += "/audio.3gp";

        //UPLOAD
        mStorageRef = FirebaseStorage.getInstance().getReference();

        mRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    startRecording();
                } catch(Exception e){
                    e.printStackTrace();
                }
                mRecordButton.setEnabled(false);
                try{
                    Thread.sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                stopRecording();
                mRecordButton.setEnabled(true);
                mRecordLabel.setText("Finished recording audio..");
//                setContentView(R.layout.activity_main_drawer);
//                Intent i = new Intent(AudioRecordingActivity.this, BaseDrawerActivity.class);
//                startActivity(i);
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



    private void uploadAudio(){
        mProgress.setMessage("Uploading Audio...");
        mProgress.show();

        StorageReference filepath = mStorageRef.child("Audio").child("new_audio.3gp");
        Uri uri = Uri.fromFile(new File(mFileName));
        filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>(){
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot){
                mProgress.dismiss();
                mRecordLabel.setText("Uploading finished");
            }
        });
    }



    private void startRecording() throws IOException{
        mRecorder = new MediaRecorder();
        mRecordLabel.setText("Recording Audio...");
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mRecorder.setOutputFile(mFileName);
        mRecorder.prepare();
        mRecorder.start();
    }

    private void stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
//        uploadAudio();
    }
}
