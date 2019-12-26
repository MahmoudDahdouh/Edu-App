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

public class SignupFragment extends Fragment {
    private EditText ed_username, ed_email, ed_password;
    private Button btn_sign_up;
    private FirebaseAuth auth;

    public SignupFragment() {
    }

    public SignupFragment newInstance() {
        return new SignupFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_signup, container, false);

        // inflate
        ed_email = layout.findViewById(R.id.ed_sign_up_email);
        ed_password = layout.findViewById(R.id.ed_sign_up_password);
        ed_username = layout.findViewById(R.id.ed_sign_up_username);
        btn_sign_up = layout.findViewById(R.id.btn_sign_up);

        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed_email.getText().toString().trim().equals("")
                        || ed_password.getText().toString().trim().equals("")
                        || ed_username.getText().toString().trim().equals("")) {
                    Toast.makeText(getContext(), "Fill the field", Toast.LENGTH_SHORT).show();
                    return;
                }
                String email = ed_email.getText().toString();
                String password = ed_password.getText().toString();

                auth = FirebaseAuth.getInstance();
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(getContext(), MainActivity.class));
                            getActivity().finish();
                            Toast.makeText(getContext(), "User Created", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), "Error: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });


        return layout;
    }

}
