package com.mahmoud.dahdouh.eduapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mahmoud.dahdouh.eduapp.Fragment.DialogAddNew;
import com.mahmoud.dahdouh.eduapp.R;

public class ProfileActivity extends AppCompatActivity {
    private ImageView btn_back;
    private LinearLayout add_new;
    private LinearLayout log_out;
    private FirebaseAuth auth;
    DatabaseReference dataRef;
    private TextView tv_username, tv_school_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        tv_username = findViewById(R.id.tv_profile_username);
        tv_school_name = findViewById(R.id.tv_profile_school_name);

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
        getData();
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

    private void getData() {
        // get data
        final String currentUserId = auth.getCurrentUser().getUid();
        dataRef = FirebaseDatabase.getInstance()
                .getReference().child("application/users/" + currentUserId);
        // Attach a listener to read the data at our posts reference
        dataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String school_name = dataSnapshot.child("username").getValue(String.class);
                tv_username.setText(school_name);

                String school_location = dataSnapshot.child("school_name").getValue(String.class);
                tv_school_name.setText(school_location);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }

}
