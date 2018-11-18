package com.udacity.project.tourguide.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.project.tourguide.R;
import com.udacity.project.tourguide.adapters.EventAdapter;
import com.udacity.project.tourguide.models.Event;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressWarnings("WeakerAccess")
public class EventFragment extends Fragment {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    public EventFragment() {

    }

    private List<Event> generateEventList(){
        List<Event> eventList = new ArrayList<>();
        eventList.add(new Event(getString(R.string.event_name_1), getString(R.string.event_date_1), R.drawable.halloween));
        eventList.add(new Event(getString(R.string.event_name_2), getString(R.string.event_date_2), R.drawable.iniciacao_cientifica));
        return eventList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        ButterKnife.bind(this, view);

        List<Event> eventList = generateEventList();

        RecyclerView.LayoutManager layout = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layout);

        EventAdapter adapter = new EventAdapter(view.getContext(), eventList);
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL));

        return view;
    }
}
