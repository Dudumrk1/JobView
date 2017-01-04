package com.liveperson.hackathon.jobview.jobview.ui;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.liveperson.hackathon.jobview.jobview.R;
import com.liveperson.hackathon.jobview.jobview.dataObjects.OccupationalDomain;
import com.liveperson.hackathon.jobview.jobview.dataObjects.User;
import com.liveperson.hackathon.jobview.jobview.utils.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonalDetailsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.name_profile)
    EditText mNameView;

    @BindView(R.id.email_profile)
    EditText mEmailView;

    String mOccDomain;

    @BindView(R.id.save_profile)
    FloatingActionButton mSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_detailes);
        ButterKnife.bind(this);

        Spinner spinner = (Spinner) findViewById(R.id.domainSpinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.OccupationalDomain, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mNameView.getText().toString();
                String email = mEmailView.getText().toString();

                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(mOccDomain) &&
                        !TextUtils.isEmpty(email) && StringUtils.validateEmailAddress(email)) {
                    new User(name, email, new OccupationalDomain(mOccDomain));

                    Intent i = new Intent(PersonalDetailsActivity.this, BaseDrawerActivity.class);
                    startActivity(i);
                }else{
                    Snackbar.make(mNameView, "Please fill all the relevant fields", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

    }


    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        mOccDomain = parent.getItemAtPosition(pos).toString();

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}
