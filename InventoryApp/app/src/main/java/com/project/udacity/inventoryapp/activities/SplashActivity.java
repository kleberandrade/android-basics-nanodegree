package com.project.udacity.inventoryapp.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.project.udacity.inventoryapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressWarnings("WeakerAccess")
public class SplashActivity extends AppCompatActivity implements Runnable {

    private static final int DELAY_MILLIS = 2000;

    @BindView(R.id.logo_title)
    TextView mLogoTitleText;

    @BindView(R.id.logo_subtitle)
    TextView mLogoSubtitleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        initializeAnimation();

        Handler handle = new Handler();
        handle.postDelayed(this, DELAY_MILLIS);
    }

    private void initializeAnimation() {
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        mLogoTitleText.startAnimation(fadeAnimation);
        mLogoSubtitleText.startAnimation(fadeAnimation);
    }

    private void changeToMainActivity() {
        Intent intent = new Intent(SplashActivity.this, CatalogBookActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void run() {
        changeToMainActivity();
    }
}
