package com.mahmoud.dahdouh.eduapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class RegisterActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tabLayout = findViewById(R.id.tablayout_register);
        viewPager = findViewById(R.id.viewpager_register);

        PagerAdapter pagerAdapter = new PagerAdapter(this);


        viewPager.setAdapter(pagerAdapter);


        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position) {
                            case 0:
                                tab.setText(getText(R.string.log_in));
                                break;
                            case 1:
                                tab.setText(getText(R.string.sign_up));
                                break;
                        }
                    }
                }).attach();


    }
}
