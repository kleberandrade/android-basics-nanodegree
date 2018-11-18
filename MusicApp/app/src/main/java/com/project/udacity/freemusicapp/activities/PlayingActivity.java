package com.project.udacity.freemusicapp.activities;

import android.os.Bundle;
import android.view.View;

import com.project.udacity.freemusicapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlayingActivity extends BaseActivity {

    @Override
    protected void onCreate(final Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_playing);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.fab)
    public void changePaymentOnClick(View view) {
        changeActivity(PaymentActivity.class);
    }

    public void changeHomeOnClick(View view) {
        changeActivity(HomeActivity.class);
    }

    public void changeBrowseOnClick(View view) {
        changeActivity(BrowseActivity.class);
    }
}
