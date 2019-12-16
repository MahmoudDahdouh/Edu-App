package com.mahmoud.dahdouh.eduapp.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoud.dahdouh.eduapp.Adapter.MessageAdapter;
import com.mahmoud.dahdouh.eduapp.Model.Message;
import com.mahmoud.dahdouh.eduapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessagesFragment extends Fragment {

    private View layout;
    private RecyclerView msgRecycler;
    private MessageAdapter messageAdapter;
    private List<Message> messages;

    public MessagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_messages, container, false);
        setMessageRecycler();
        // Inflate the layout for this fragment
        return layout;
    }

    private void setMessageRecycler() {
        msgRecycler = layout.findViewById(R.id.messages_recycler);

        messages = new ArrayList<>();

        messages.add(new Message("First School", 2, "John Doe",
                "Can i have my grade", "Dec 12, 2019", R.drawable.temp_profile_img_2));
        messages.add(new Message("High School", 1, "Sandy Shawn",
                "I don't need to go party", "Nov 20, 2019", R.drawable.temp_profile_img_3));
        messages.add(new Message("First School", 2, "John Doe",
                "Can i have my grade", "Dec 12, 2019", R.drawable.temp_profile_img_4));
        messages.add(new Message("High School", 1, "Jack Smith",
                "I don't need to go party", "Nov 20, 2019", R.drawable.temp_profile_img_5));

        messageAdapter = new MessageAdapter(messages);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        msgRecycler.setLayoutManager(layoutManager);
        msgRecycler.setAdapter(messageAdapter);

    }
}