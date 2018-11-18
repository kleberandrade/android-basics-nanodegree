package com.project.udacity.freemusicapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.udacity.freemusicapp.R;
import com.project.udacity.freemusicapp.models.Music;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {

    private final Context context;
    private final List<Music> musicList;

    public MusicAdapter(Context context, List<Music> musicList) {
        this.context = context;
        this.musicList = musicList;
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_play_music, viewGroup, false);
        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder musicViewHolder, int position) {
        Music music = musicList.get(position);

        musicViewHolder.nameField.setText(music.getArtistName());
        musicViewHolder.trackTitleField.setText(music.getTrackTitle());
        musicViewHolder.trackLengthField.setText(music.getTrackLength());
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    static class MusicViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.artistNameView)
        TextView nameField;

        @BindView(R.id.songTitleView)
        TextView trackTitleField;

        @BindView(R.id.songLengthView)
        TextView trackLengthField;

        MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

