package com.udacity.project.tourguide.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.udacity.project.tourguide.R;
import com.udacity.project.tourguide.models.School;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.SchoolViewHolder>
{
    private final Context context;
    private final List<School> schoolList;

    public SchoolAdapter(Context context, List<School> schoolList) {
        this.context = context;
        this.schoolList = schoolList;
    }

    @NonNull
    @Override
    public SchoolViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_school, viewGroup, false);
        return new SchoolViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolViewHolder schoolViewHolder, int position) {
        School school = schoolList.get(position);
        schoolViewHolder.nameField.setText(school.getName());
        schoolViewHolder.addressField.setText(school.getAddress());
        schoolViewHolder.phoneField.setText(school.getPhone());
        schoolViewHolder.imageView.setImageResource(school.getImageId());
    }

    @Override
    public int getItemCount() {
        return schoolList.size();
    }

    public static class SchoolViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView nameField;

        @BindView(R.id.phone)
        TextView phoneField;

        @BindView(R.id.address)
        TextView addressField;

        @BindView(R.id.image)
        ImageView imageView;

        SchoolViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

