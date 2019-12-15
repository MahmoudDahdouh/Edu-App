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

import java.util.List;

public class SchoolsAdapter extends RecyclerView.Adapter {


    private List<School> data;

    public SchoolsAdapter(List<School> data) {
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_school, parent, false);

        return new RecyclerHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        RecyclerHolder myHolder = (RecyclerHolder) holder;
        myHolder.bind(position);

    }

    class RecyclerHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView location;
        private ImageView image;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.school_item_name);
            location = itemView.findViewById(R.id.school_item_location);
            image = itemView.findViewById(R.id.school_item_image);
        }

        void bind(int position) {
            name.setText(data.get(position).getName());
            location.setText(data.get(position).getLocation());
            image.setImageResource(data.get(position).getImage());
        }

    }
}
