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
import com.udacity.project.tourguide.adapters.CourseAdapter;
import com.udacity.project.tourguide.models.Course;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressWarnings("WeakerAccess")
public class CourseFragment extends Fragment {

    @BindView(R.id.recycler)
    protected RecyclerView recyclerView;

    public CourseFragment() {

    }

    private List<Course> generateCourseList(){
        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course(getString(R.string.course_name_1), getString(R.string.course_description_1)));
        courseList.add(new Course(getString(R.string.course_name_2), getString(R.string.course_description_2)));
        courseList.add(new Course(getString(R.string.course_name_3), getString(R.string.course_description_3)));
        return courseList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        ButterKnife.bind(this, view);

        List<Course> courseList = generateCourseList();

        RecyclerView.LayoutManager layout = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layout);

        CourseAdapter adapter = new CourseAdapter(view.getContext(), courseList);
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL));

        return view;
    }
}
