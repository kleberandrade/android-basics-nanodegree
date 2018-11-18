package com.project.udacity.freemusicapp.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.project.udacity.freemusicapp.R;
import com.project.udacity.freemusicapp.adapters.MusicAdapter;
import com.project.udacity.freemusicapp.models.Music;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressWarnings("WeakerAccess")
public class BrowseActivity extends BaseActivity {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        ButterKnife.bind(this);

        initializeRecyclerView();
    }

    public void changePlayingOnClick(View view) {
        changeActivity(PlayingActivity.class);
    }

    public void changeHomeOnClick(View view) {
        changeActivity(HomeActivity.class);
    }

    private void initializeRecyclerView() {
        List<Music> musicList = generateMusicList();

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layout);

        MusicAdapter adapter = new MusicAdapter(this, musicList);
        recyclerView.setAdapter(adapter);
    }

    private List<Music> generateMusicList() {
        List<Music> musicList = new ArrayList<>();
        musicList.add(new Music("BenSound", "Happiness", "4:42"));
        musicList.add(new Music("NeXt Day", "Sadness", "4:02"));
        musicList.add(new Music("CodeYard Band", "Crazyness", "3:30"));
        musicList.add(new Music("FeelIt", "This is awesome", "1:42"));
        musicList.add(new Music("BetterGo", "You will win!", "2:42"));
        musicList.add(new Music("Chosens", "Pleased to meet ya", "4:31"));
        musicList.add(new Music("The Kingdom", "Never again", "3:22"));
        musicList.add(new Music("Feets on the Ground", "Hold me back", "2:07"));
        return musicList;
    }
}
