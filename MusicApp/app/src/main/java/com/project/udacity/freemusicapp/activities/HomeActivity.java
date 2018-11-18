package com.project.udacity.freemusicapp.activities;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.project.udacity.freemusicapp.R;
import com.project.udacity.freemusicapp.adapters.CategoryAdapter;
import com.project.udacity.freemusicapp.models.Category;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@SuppressWarnings("WeakerAccess")
public class HomeActivity extends BaseActivity {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        initializeRecyclerView();
    }

    private void initializeRecyclerView() {
        List<Category> categoryList = generateCategoryList();

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        CategoryAdapter adapter = new CategoryAdapter(this, categoryList);
        recyclerView.setAdapter(adapter);
    }

    private List<Category> generateCategoryList() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(getString(R.string.acoustic)));
        categoryList.add(new Category(getString(R.string.rock)));
        categoryList.add(new Category(getString(R.string.electronic)));
        categoryList.add(new Category(getString(R.string.world)));
        categoryList.add(new Category(getString(R.string.funky)));
        categoryList.add(new Category(getString(R.string.corporate)));
        return categoryList;
    }


    @OnClick(R.id.nowPlayingButton)
    public void changePlayingOnClick(View view) {
        changeActivity(PlayingActivity.class);
    }

    @OnClick(R.id.browseButton)
    public void changeBrowseOnClick(View view) {
        changeActivity(BrowseActivity.class);
    }
}
