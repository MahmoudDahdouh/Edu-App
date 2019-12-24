package com.mahmoud.dahdouh.eduapp.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoud.dahdouh.eduapp.Adapter.NotificationAdapter;
import com.mahmoud.dahdouh.eduapp.Model.Notification;
import com.mahmoud.dahdouh.eduapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {

    private View layout;
    private RecyclerView notificationRecycler;
    private NotificationAdapter notificationAdapter;
    private List<Notification> notifications;

    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_notification, container, false);
        setNotificationRecycler();
        // Inflate the layout for this fragment
        return layout;
    }


    private void setNotificationRecycler() {
        notificationRecycler = layout.findViewById(R.id.notification_recycler);

        setDatalist();

        notificationAdapter = new NotificationAdapter(notifications);

        // on item click
        notificationAdapter.setOnItemClickListener(new NotificationAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final View view, int position) {
                DialogNotification dialog = new DialogNotification();

                dialog.setArguments(sendBundle(position));
                dialog.setOnMaskAsRead(new DialogNotification.OnMaskAsReadClickListener() {
                    @Override
                    public void maskAsReadClick(int position) {
                        notifications.get(position).setRead(true);
                        //view.setBackgroundResource(R.color.green);
                    }
                });
                dialog.show(getFragmentManager(), "hello");

            }
        });

        notificationRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        notificationRecycler.setAdapter(notificationAdapter);
    }

    private void setDatalist() {
        notifications = new ArrayList<>();

        notifications.add(new Notification("First School", "New teacher",
                "Dec 12, 2019",
                getString(R.string.hi) + getString(R.string.hi) + getString(R.string.hi) + getString(R.string.hi)));
        notifications.add(new Notification("Second School", "New event",
                "Nov 25, 2019",
                getString(R.string.hi)));
        notifications.add(new Notification("Third School", "Party for Student",
                "Dec 10, 2019",
                getString(R.string.hi)));
        notifications.add(new Notification("Fourth School", "New teacher",
                "Dec 12, 2019",
                getString(R.string.hi)));
        notifications.add(new Notification("Fifth School", "New event",
                "Nov 25, 2019",
                getString(R.string.hi)));
        notifications.add(new Notification("Sixth School", "New event",
                "Nov 25, 2019",
                getString(R.string.hi)));
        notifications.add(new Notification("Seventh School", "Party",
                "Dec 10, 2019",
                getString(R.string.hi)));
        notifications.add(new Notification("Eighth School", "New teacher",
                "Dec 12, 2019",
                getString(R.string.hi)));
        notifications.add(new Notification("Ninth School", "New event",
                "Nov 25, 2019",
                "There is a new event will come next week"));
        notifications.add(new Notification("Tenth School", "Party for Student",
                "Dec 10, 2019",
                "There is a party you can come with your friends in the large hall"));
        notifications.add(new Notification("Eleventh School", "New teacher",
                "Dec 12, 2019",
                "There is a new teacher will come next week"));
        notifications.add(new Notification("Twelfth School", "New event",
                "Nov 25, 2019",
                "There is a new event will come next week"));
        notifications.add(new Notification("Thirteenth School", "Party",
                "Dec 10, 2019",
                "There is a party you can come with your friends"));
        notifications.add(new Notification("Fourteenth School", "Party",
                "Dec 10, 2019",
                "There is a party you can come with your friends"));
        notifications.add(new Notification("Fifteenth School", "Party",
                "Dec 10, 2019",
                "There is a party you can come with your friends"));

    }

    private Bundle sendBundle(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("name", notifications.get(position).getSchoolName());
        bundle.putString("title", notifications.get(position).getNotificationTitle());
        bundle.putString("content", notifications.get(position).getNotificationDescription());
        bundle.putString("time", notifications.get(position).getNotificationTime());
        bundle.putInt("position", position);
        return bundle;
    }

}
