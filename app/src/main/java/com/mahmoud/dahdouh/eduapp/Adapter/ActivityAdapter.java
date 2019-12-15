package com.mahmoud.dahdouh.eduapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoud.dahdouh.eduapp.Model.Activity;
import com.mahmoud.dahdouh.eduapp.R;

import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter {


    private List<Activity> data;

    public ActivityAdapter(List<Activity> data) {
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @NonNull
    @Override
    public ActivityAdapter.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_activity, parent, false);

        return new ActivityAdapter.RecyclerHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ActivityAdapter.RecyclerHolder myHolder = (ActivityAdapter.RecyclerHolder) holder;
        myHolder.bind(position);

    }

    class RecyclerHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView school;
        private ImageView type;

        RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.activity_item_name);
            school = itemView.findViewById(R.id.activity_item_school_name);
            type = itemView.findViewById(R.id.activity_item_image);
        }

        void bind(int position) {
            name.setText(data.get(position).getName());
            school.setText(data.get(position).getSchool());
            type.setImageResource(data.get(position).getType());
        }

    }
}
