package com.liveperson.hackathon.jobview.jobview.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.liveperson.hackathon.jobview.jobview.R;

import java.io.File;

import static java.security.AccessController.getContext;

public class VideoRecordingActivity extends BaseDrawerActivity {

    static final int REQUEST_VIDEO_CAPTURE = 1;
    private Button mButton;
    private VideoView mVideoView;
    private ProgressDialog mProgress;
    private StorageReference mStorageRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_video_recording, null, false);
        drawer.addView(contentView, 0);
        mStorageRef = FirebaseStorage.getInstance().getReference();

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
//            takeVideoIntent.putExtra(MediaStore.EXTRA_OUTPUT, getImageUri());
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }

    }

//    private Uri getImageUri() {
//        // Store image in dcim
//        // Here you can change yourinternal storage path to store those images..
//        File file = new File(Environment.getExternalStorageDirectory() + "/DCIM", CAPTURE_TITLE);
//        Uri imgUri = Uri.fromFile(file);
//
//        return imgUri;
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Uri videoUri = intent.getData();
//            Toast toast = Toast.makeText(getApplicationContext(), intent.getDataString(), Toast.LENGTH_LONG);
//            toast.show();
//            mVideoView.setVideoURI(videoUri);
            uploadAudio(intent.getDataString());
//            com.liveperson.hackathon.jobview.jobview.controller.SessionManager.getInstance().
        }

    }

    private void uploadAudio(String fileName){
        mProgress = new ProgressDialog(this);
        mProgress.setMessage("Uploading Video...");
        mProgress.show();

        Uri file = Uri.fromFile(new File(fileName));
        StorageReference riversRef = mStorageRef.child("newVideo.mp4");
        riversRef.putFile(file).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>(){
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot){
                mProgress.dismiss();
            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                mProgress.dismiss();
            }
        });
    }
}
