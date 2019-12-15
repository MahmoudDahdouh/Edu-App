package com.mahmoud.dahdouh.eduapp.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mahmoud.dahdouh.eduapp.Adapter.RegisterAdapter;
import com.mahmoud.dahdouh.eduapp.R;

public class RegisterActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private TextView tv_register_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //inflate
        tabLayout = findViewById(R.id.tablayout_register);
        viewPager = findViewById(R.id.viewpager_register);
        tv_register_title = findViewById(R.id.tv_login_register);

        //
        RegisterAdapter registerAdapter = new RegisterAdapter(this);
        viewPager.setAdapter(registerAdapter);


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

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tv_register_title.setText(getText(R.string.log_in));
                        break;
                    case 1:
                        tv_register_title.setText(getText(R.string.sign_up));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}
