package com.mahmoud.dahdouh.eduapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mahmoud.dahdouh.eduapp.Activity.MainActivity;
import com.mahmoud.dahdouh.eduapp.R;

public class LoginFragment extends Fragment {
    private Button continue_as_a_guest;
    private View layout;

    public LoginFragment() {
    }

    public LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_login, container, false);

        continue_as_a_guest = layout.findViewById(R.id.continue_as_a_guest);
        continue_as_a_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });

        return layout;
    }

}
