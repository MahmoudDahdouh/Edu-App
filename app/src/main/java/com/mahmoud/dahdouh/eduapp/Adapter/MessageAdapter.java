package com.mahmoud.dahdouh.eduapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoud.dahdouh.eduapp.Model.Message;
import com.mahmoud.dahdouh.eduapp.R;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter {

    private List<Message> data;

    public MessageAdapter(List<Message> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_message, parent, false);

        return new MessageHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MessageHolder myHolder = (MessageHolder) holder;
        myHolder.bind(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MessageHolder extends RecyclerView.ViewHolder {

        private TextView schoolName;
        private TextView nof_msgs;
        private TextView username;
        private TextView msg;
        private TextView time;
        private ImageView user_img;


        public MessageHolder(@NonNull View itemView) {
            super(itemView);
            schoolName = itemView.findViewById(R.id.msg_item_school_name);
            nof_msgs = itemView.findViewById(R.id.msg_item_nof_msg);
            time = itemView.findViewById(R.id.msg_item_time);
            msg = itemView.findViewById(R.id.msg_item_msg);
            username = itemView.findViewById(R.id.msg_item_username);
            user_img = itemView.findViewById(R.id.msg_item_profile_img);
        }

        void bind(int position) {
            schoolName.setText(data.get(position).getSchool_name());
            nof_msgs.setText("" + data.get(position).getNof_msgs());
            time.setText(data.get(position).getTime());
            username.setText(data.get(position).getUsername());
            msg.setText(data.get(position).getMsg());
            user_img.setImageResource(data.get(position).getImg_user());
        }
    }


}
