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
import com.udacity.project.tourguide.adapters.SchoolAdapter;
import com.udacity.project.tourguide.models.School;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressWarnings("WeakerAccess")
public class SchoolFragment extends Fragment {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    public SchoolFragment() {

    }

    private List<School> generateSchoolList(){
        List<School> schoolList = new ArrayList<>();
        schoolList.add(new School(getString(R.string.school_name_1), getString(R.string.school_address_1), getString(R.string.school_phone_1), R.drawable.fatec_americana));
        schoolList.add(new School(getString(R.string.school_name_2), getString(R.string.school_address_2), getString(R.string.school_phone_2), R.drawable.fatec_campinas));
        return schoolList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        ButterKnife.bind(this, view);

        List<School> schoolList = generateSchoolList();

        RecyclerView.LayoutManager layout = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layout);

        SchoolAdapter adapter = new SchoolAdapter(view.getContext(), schoolList);
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL));

        return view;
    }
}
