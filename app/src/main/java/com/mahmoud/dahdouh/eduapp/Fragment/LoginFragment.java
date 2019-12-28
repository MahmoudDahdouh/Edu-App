package com.mahmoud.dahdouh.eduapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.mahmoud.dahdouh.eduapp.Activity.MainActivity;
import com.mahmoud.dahdouh.eduapp.R;

public class LoginFragment extends Fragment {
    private Button continue_as_a_guest, btn_log_in;
    private EditText ed_email, ed_password;
    private View layout;
    private FirebaseAuth auth;

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
        ed_email = layout.findViewById(R.id.ed_log_in_email);
        ed_password = layout.findViewById(R.id.ed_log_in_password);
        btn_log_in = layout.findViewById(R.id.btn_log_in);

        auth = FirebaseAuth.getInstance();

        continue_as_a_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });
        btn_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed_email.getText().toString().trim().equals("")
                        || ed_password.getText().toString().trim().equals("")) {
                    Toast.makeText(getContext(), "Fill the field", Toast.LENGTH_SHORT).show();
                    return;
                }

                String email = ed_email.getText().toString().trim();
                String password = ed_password.getText().toString().trim();

                auth = FirebaseAuth.getInstance();
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(getContext(), MainActivity.class));
                            getActivity().finish();
                            Toast.makeText(getContext(), "User Created", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(),
                                    "Error: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        return layout;
    }

}
