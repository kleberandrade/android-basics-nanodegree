package com.project.udacity.freemusicapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.project.udacity.freemusicapp.R;


public class BaseActivity extends AppCompatActivity {

    protected void changeActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

}
