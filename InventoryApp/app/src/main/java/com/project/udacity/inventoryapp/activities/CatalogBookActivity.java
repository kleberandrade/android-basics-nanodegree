package com.project.udacity.inventoryapp.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.project.udacity.inventoryapp.R;
import com.project.udacity.inventoryapp.adapters.BookAdapter;
import com.project.udacity.inventoryapp.models.Book;
import com.project.udacity.inventoryapp.providers.BookDAO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@SuppressWarnings("WeakerAccess")
public class CatalogBookActivity extends AppCompatActivity {

    private static final String LOG_TAG = CatalogBookActivity.class.getSimpleName();

    @BindView(R.id.recycler)
    RecyclerView mRecycler;

    @BindView(R.id.fab)
    FloatingActionButton mFloatingActionButton;

    @BindView(R.id.empty_list)
    View mEmptyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog_book);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initializeRecyclerView();
    }

    @OnClick(R.id.fab)
    public void addNewBookOnClick(View view){
        Intent intent = new Intent(CatalogBookActivity.this, CreateBookActivity.class);
        startActivity(intent);
    }

    private void initializeRecyclerView(){
        BookDAO bookDAO = new BookDAO(this);
        List<Book> bookList = bookDAO.searchAll();

        BookAdapter mBookAdapter = new BookAdapter(this, bookList);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(layout);
        mRecycler.setAdapter(mBookAdapter);
        mRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        mEmptyList.setVisibility(mBookAdapter.getItemCount() > 0 ? View.INVISIBLE : View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about, menu);
        Log.d(LOG_TAG, "Open menu about");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                openAboutActivity();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openAboutActivity(){
        Intent intent = new Intent(CatalogBookActivity.this, AboutActivity.class);
        startActivity(intent);
    }
}
