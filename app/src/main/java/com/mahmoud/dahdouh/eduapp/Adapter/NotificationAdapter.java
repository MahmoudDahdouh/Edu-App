package com.mahmoud.dahdouh.eduapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoud.dahdouh.eduapp.Model.Notification;
import com.mahmoud.dahdouh.eduapp.R;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter {

    private List<Notification> data;

    public NotificationAdapter(List<Notification> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_notification, parent, false);
        return new NotificationHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NotificationHolder myHolder = (NotificationHolder) holder;
        myHolder.bind(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class NotificationHolder extends RecyclerView.ViewHolder {

        private TextView schoolName;
        private TextView title;
        private TextView time;
        private TextView description;


        public NotificationHolder(@NonNull View itemView) {
            super(itemView);

            schoolName = itemView.findViewById(R.id.notif_item_school_name);
            title = itemView.findViewById(R.id.msg_item_username);
            time = itemView.findViewById(R.id.notif_item_time);
            description = itemView.findViewById(R.id.notif_item_description);
        }

        void bind(int position) {
            schoolName.setText(data.get(position).getSchoolName());
            title.setText(data.get(position).getNotificationTitle());
            time.setText(data.get(position).getNotificationTime());
            description.setText(data.get(position).getNotificationDescription());
        }
    }


}
