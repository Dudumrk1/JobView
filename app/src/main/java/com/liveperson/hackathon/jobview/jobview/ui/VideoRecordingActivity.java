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
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
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
    private ProgressDialog mProgress;
    private StorageReference mStorageRef;
    public static String realPath = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View contentView = inflater.inflate(R.layout.activity_video_recording, null, false);
        drawer.addView(contentView, 0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mStorageRef = FirebaseStorage.getInstance().getReference("jobView");

        mButton = (Button) findViewById(R.id.recordVideo);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakeVideoIntent();
            }
        });

        Button uploadBtn = (Button) findViewById(R.id.uploadVideoBtn);
        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (realPath != null) {
                    uploadVideo(realPath);
                    Snackbar snackbar = Snackbar.make(contentView, "הסרטון שותף בהצלחה!", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    Snackbar snackbar = Snackbar.make(contentView, "אנא הקליטו סרטון", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });

        Button cancelBtn = (Button) findViewById(R.id.cancelVideoBtn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Snackbar snackbar = Snackbar.make(contentView, "הסרטון לא הועלה", Snackbar.LENGTH_LONG);
//                snackbar.show();
                onBackPressed();
            }
        });
    }

    private void dispatchTakeVideoIntent() {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
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

            Uri realUri = Uri.parse(realPath);
            VideoView videoView = (VideoView) findViewById(R.id.takeVideoView);
            //Creating MediaController
            MediaController mediaController= new MediaController(this);
            mediaController.setAnchorView(videoView);

            //Setting MediaController and URI, then starting the videoView
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(realUri);
            videoView.requestFocus();
            videoView.start();
        }
    }

    public String getRealPathFromURI(Context context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = {MediaStore.Images.Media.DATA};
            cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private void downloadVideo(String pathToLook) {
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

    private void uploadVideo(String fileName) {
        mProgress = new ProgressDialog(this);
        mProgress.setMessage("Uploading Video...");
        mProgress.show();
        Uri file = Uri.fromFile(new File(fileName));
        StorageReference riversRef = mStorageRef.child("newVideo_" + System.currentTimeMillis() + ".mp4");
        riversRef.putFile(file).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
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
