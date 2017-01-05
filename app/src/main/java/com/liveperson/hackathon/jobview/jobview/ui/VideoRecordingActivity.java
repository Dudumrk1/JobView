package com.liveperson.hackathon.jobview.jobview.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.liveperson.hackathon.jobview.jobview.R;

import java.io.File;
import java.io.IOException;

public class VideoRecordingActivity extends BaseDrawerActivity {

    static final int REQUEST_VIDEO_CAPTURE = 1;
    private Button mButton;
    private VideoView mVideoView;
    private ProgressDialog mProgress;
    private StorageReference mStorageRef;
    public static String realPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_video_recording, null, false);
        drawer.addView(contentView, 0);
        mStorageRef = FirebaseStorage.getInstance().getReference("jobView");

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
//            takeVideoIntent.putExtra(MediaStore.EXTRA_OUTPUT, getImageUri(takeVideoIntent));
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }

    }

    private Uri getImageUri(Intent intent) {
        // Store image in dcim
        // Here you can change yourinternal storage path to store those images..
        File file = new File(Environment.getExternalStorageDirectory() + "/DCIM", intent.getDataString());
        Uri imgUri = Uri.fromFile(file);

        return imgUri;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Uri videoUri = intent.getData();
            realPath = getRealPathFromURI(getApplicationContext(), videoUri);
//            Toast toast = Toast.makeText(getApplicationContext(), intent.getDataString(), Toast.LENGTH_LONG);
//            toast.show();
//            mVideoView.setVideoURI(videoUri);


            uploadVideo(realPath);

//            com.liveperson.hackathon.jobview.jobview.controller.SessionManager.getInstance().
        }

    }

    public String getRealPathFromURI(Context context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = { MediaStore.Images.Media.DATA };
            cursor = context.getContentResolver().query(contentUri,  proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private void downloadVideo(String pathToLook){
        StorageReference islandRef = mStorageRef.child(pathToLook);
        mProgress = new ProgressDialog(this);
        mProgress.setMessage("Downloading Video...");
        mProgress.show();
        File localFile = null;
        try {
            localFile = File.createTempFile("videos_" + System.currentTimeMillis(), "mp4");
            islandRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    mProgress.dismiss();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    mProgress.dismiss();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void uploadVideo(String fileName){
        mProgress = new ProgressDialog(this);
        mProgress.setMessage("Uploading Video...");
        mProgress.show();
        Uri file = Uri.fromFile(new File(fileName));
        StorageReference riversRef = mStorageRef.child("newVideo_" + System.currentTimeMillis() + ".mp4");
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
