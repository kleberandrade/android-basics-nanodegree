package com.project.udacity.freemusicapp.activities;

import android.os.Bundle;
import android.view.View;

import com.project.udacity.freemusicapp.R;

public class PaymentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
    }

    public void changeHomeOnClick(View view) {
        changeActivity(HomeActivity.class);
    }

    public void changePlayingOnClick(View view) {
        changeActivity(PlayingActivity.class);
    }

    public void changeBrowseOnClick(View view) {
        changeActivity(BrowseActivity.class);
    }

    public void changePaymentOnClick(View view) {
        changeActivity(PaymentActivity.class);
    }
}
