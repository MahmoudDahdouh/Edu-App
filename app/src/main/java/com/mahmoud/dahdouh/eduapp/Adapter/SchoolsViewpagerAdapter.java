package com.mahmoud.dahdouh.eduapp.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoud.dahdouh.eduapp.Model.School;
import com.mahmoud.dahdouh.eduapp.R;

import java.util.ArrayList;

public class SchoolsViewpagerAdapter extends RecyclerView.Adapter<SchoolsViewpagerAdapter.MyViewHolder> {

    private ArrayList<School> schools;

    public SchoolsViewpagerAdapter(ArrayList<School> schools) {
        this.schools = schools;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_school, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return schools.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView schoolName;
        TextView location;
        ImageView schoolImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            schoolName = itemView.findViewById(R.id.school_item_name);
            location = itemView.findViewById(R.id.school_item_location);
            schoolImage = itemView.findViewById(R.id.school_item_image);
        }

        void bind(int position) {
            schoolName.setText(schools.get(position).getName());
            location.setText(schools.get(position).getLocation());
            schoolImage.setImageResource(schools.get(position).getImage());
        }
    }


}
