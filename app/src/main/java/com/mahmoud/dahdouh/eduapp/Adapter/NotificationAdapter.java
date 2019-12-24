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

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationHolder> {

    private List<Notification> data;

    public NotificationAdapter(List<Notification> data) {
        this.data = data;
    }

    // OnItemCLick
    private OnItemClickListener mListener;

    @NonNull
    @Override
    public NotificationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_notification, parent, false);
        return new NotificationHolder(view);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationHolder holder, int position) {
        holder.bind(position);

        //if (data.get(position).isRead()) {
        //holder.cardView.setBackgroundResource(R.color.green);
        System.out.println("BindView : " + position + "  " + data.get(position).isRead());

        //}
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    class NotificationHolder extends RecyclerView.ViewHolder {

        //private CardView cardView;
        private TextView schoolName;
        private TextView title;
        private TextView time;
        private TextView description;

        public NotificationHolder(@NonNull final View itemView) {
            super(itemView);

            schoolName = itemView.findViewById(R.id.notif_item_school_name);
            title = itemView.findViewById(R.id.msg_item_username);
            time = itemView.findViewById(R.id.notif_item_time);
            description = itemView.findViewById(R.id.notif_item_description);
            // cardView = itemView.findViewById(R.id.notif_item_cardview);


            System.out.println("card view ");

            // on item click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //data.get(getAdapterPosition()).setRead(true);

                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(v, getAdapterPosition());
                        }
                    }
                }
            });
        }

        void bind(int position) {
            schoolName.setText(data.get(position).getSchoolName());
            title.setText(data.get(position).getNotificationTitle());
            time.setText(data.get(position).getNotificationTime());
            description.setText(data.get(position).getNotificationDescription());

           /* if (data.get(position).isRead())
                itemView.setBackgroundResource(R.color.green);
*/
        }
    }
}
