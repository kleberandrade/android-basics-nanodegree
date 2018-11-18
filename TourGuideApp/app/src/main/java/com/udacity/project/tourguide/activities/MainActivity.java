package com.udacity.project.tourguide.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.udacity.project.tourguide.R;
import com.udacity.project.tourguide.adapters.ViewPagerAdapter;
import com.udacity.project.tourguide.fragments.CourseFragment;
import com.udacity.project.tourguide.fragments.EventFragment;
import com.udacity.project.tourguide.fragments.NewsFragment;
import com.udacity.project.tourguide.fragments.SchoolFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressWarnings("WeakerAccess")
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new NewsFragment(), getString(R.string.news));
        viewPagerAdapter.addFragment(new EventFragment(), getString(R.string.event));
        viewPagerAdapter.addFragment(new SchoolFragment(), getString(R.string.School));
        viewPagerAdapter.addFragment(new CourseFragment(), getString(R.string.course));

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
