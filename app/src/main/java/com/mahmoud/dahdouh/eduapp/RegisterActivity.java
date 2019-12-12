package com.mahmoud.dahdouh.eduapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.mahmoud.dahdouh.eduapp.Fragment.LoginFragment;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        ViewPager2 viewPager = findViewById(R.id.viewpager_2);
        PagerAdapter pagerAdapter = new PagerAdapter(new LoginFragment());

        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tablayout);


    }
}
