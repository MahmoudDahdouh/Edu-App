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

        notifications = new ArrayList<>();

        notifications.add(new Notification("First School", "New teacher",
                "Dec 12, 2019",
                "There is a new teacher will come next week"));
        notifications.add(new Notification("High School", "New event",
                "Nov 25, 2019",
                "There is a new event will come next week"));
        notifications.add(new Notification("First School", "Party for Student",
                "Dec 10, 2019",
                "There is a party you can come with your friends in the large hall"));
        notifications.add(new Notification("First School", "New teacher",
                "Dec 12, 2019",
                "There is a new teacher will come next week"));
        notifications.add(new Notification("High School", "New event",
                "Nov 25, 2019",
                "There is a new event will come next week"));
        notifications.add(new Notification("First School", "Party",
                "Dec 10, 2019",
                "There is a party you can come with your friends"));

        notificationAdapter = new NotificationAdapter(notifications);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        notificationRecycler.setLayoutManager(layoutManager);
        notificationRecycler.setAdapter(notificationAdapter);
    }


}
