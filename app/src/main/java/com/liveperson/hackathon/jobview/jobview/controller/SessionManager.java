package com.liveperson.hackathon.jobview.jobview.controller;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.liveperson.hackathon.jobview.jobview.dataObjects.User;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by litalh on 1/4/17.
 */

public  class SessionManager {

    private static SessionManager instance = new SessionManager();
    private static final String SCHEMA_NAME = "jobView";
    private static final String USERS_TABLE_NAME = "users";


    FirebaseDatabase database;
    private SessionManager()
    {
        database = FirebaseDatabase.getInstance();
        database.setPersistenceEnabled(true);

    }

    public static SessionManager getInstance(){

        return instance;
    }

    public void updateUser (User user){
        database.getReference(SCHEMA_NAME).child(USERS_TABLE_NAME).child(user.getUserId()).setValue(user);

    }

    // This getter method is void since the onDataChange is async method
    public void getUser (String userId){

        database.getReference(SCHEMA_NAME).child(USERS_TABLE_NAME).child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Map<String, Object> userMap = (HashMap<String, Object>) dataSnapshot.getValue();
                    String userId = (String) userMap.get("userId");
                    String email = (String) userMap.get("mEmail");
                    String name = (String) userMap.get("mName");
                    User user = new User();
                    user.setUserId(userId);
                    user.setmEmail(email);
                    user.setmName(name);
// if need to update the UI this is the place..

                }


            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {

            }
        });
    }


}

