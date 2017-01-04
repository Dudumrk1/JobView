package com.liveperson.hackathon.jobview.jobview.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ui.ResultCodes;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.liveperson.hackathon.jobview.jobview.R;
import com.liveperson.hackathon.jobview.jobview.controller.SessionManager;
import com.liveperson.hackathon.jobview.jobview.dataObjects.OccupationalDomain;
import com.liveperson.hackathon.jobview.jobview.dataObjects.User;
import com.liveperson.hackathon.jobview.jobview.utils.PreferenceManager;
import com.liveperson.hackathon.jobview.jobview.utils.StringUtils;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "SplashActivity";

    private static final int RC_SIGN_IN = 12345;

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2000;

    View mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mRootView = findViewById(R.id.splash_layout);

        PreferenceManager.initializeInstance(getApplicationContext());
        FirebaseAuth auth = FirebaseAuth.getInstance();
        final FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser == null) {
            // not signed in
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .build(),
                    RC_SIGN_IN);
        } else {




            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startDashboard(currentUser);

                    // close this activity
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }
    }

    private void startDashboard(FirebaseUser currentUser) {
        String email = currentUser.getEmail();
        String displayName = currentUser.getDisplayName();
        String uid = currentUser.getUid();
        Log.d(TAG, "email: " + email + ", displayName: " + displayName + ", uid: " + uid);
        //TODO - create user and save to DB
        SessionManager.getInstance().updateUser(new User(uid, displayName, email));

        Intent i = new Intent(SplashActivity.this, BaseDrawerActivity.class);
        startActivity(i);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // RC_SIGN_IN is the request code you passed into startActivityForResult(...) when starting the sign in flow
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                // user is signed in!
                Snackbar.make(mRootView, "Log-in ended successfully", Snackbar.LENGTH_LONG).show();
                FirebaseAuth auth = FirebaseAuth.getInstance();
                final FirebaseUser currentUser = auth.getCurrentUser();
                startDashboard(currentUser);
                return;
            }

            // Sign in canceled
            if (resultCode == RESULT_CANCELED) {
                Snackbar.make(mRootView, "Log-in was canceled", Snackbar.LENGTH_LONG).show();
                return;
            }

            // No network
            if (resultCode == ResultCodes.RESULT_NO_NETWORK) {
                Snackbar.make(mRootView, "Log-in failed - No Network", Snackbar.LENGTH_LONG).show();
                return;
            }

            // User is not signed in. Maybe just wait for the user to press
            // "sign in" again, or show a message.
        }
    }

}
