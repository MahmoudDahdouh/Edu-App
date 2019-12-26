package com.mahmoud.dahdouh.eduapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.mahmoud.dahdouh.eduapp.Fragment.DialogAddNew;
import com.mahmoud.dahdouh.eduapp.R;

public class ProfileActivity extends AppCompatActivity {
    private ImageView btn_back;
    private LinearLayout add_new;
    private LinearLayout log_out;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        auth = FirebaseAuth.getInstance();
        log_out = findViewById(R.id.profile_log_out);
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                startActivity(new Intent(ProfileActivity.this, RegisterActivity.class));
                finish();
            }
        });

        backBtn();
        addNewBtn();
    }

    private void backBtn() {
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void addNewBtn() {
        add_new = findViewById(R.id.profile_add_new);
        add_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProfileActivity.this, "Add new", Toast.LENGTH_SHORT).show();
                DialogAddNew addNew = new DialogAddNew();
                addNew.show(getSupportFragmentManager(), "add_new _dialog");
            }
        });
    }


}
