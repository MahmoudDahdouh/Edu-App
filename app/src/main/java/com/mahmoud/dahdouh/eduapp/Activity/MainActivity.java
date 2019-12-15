package com.mahmoud.dahdouh.eduapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mahmoud.dahdouh.eduapp.Fragment.HomeFragment;
import com.mahmoud.dahdouh.eduapp.Fragment.LoginFragment;
import com.mahmoud.dahdouh.eduapp.Fragment.SignupFragment;
import com.mahmoud.dahdouh.eduapp.R;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mainBottomNavigationView;
    private Toolbar toolbar;
    private ImageView btm_profile;
    //private TabLayout tab;
    //private ViewPager2 viewPager;
    //private MainViewpagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inflate
        mainBottomNavigationView = findViewById(R.id.main_btm_navi);
        toolbar = findViewById(R.id.toolbar);

        btm_profile = toolbar.findViewById(R.id.btn_profile);
        btm_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });


        openFragment(new HomeFragment());

        mainBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.main_btm_home:
                        openFragment(new HomeFragment());
                        break;
                    case R.id.main_btm_messages:
                        openFragment(new LoginFragment());
                        break;
                    case R.id.main_btm_class:
                        openFragment(new SignupFragment());
                        break;
                    case R.id.main_btm_notification:
                        openFragment(new HomeFragment());
                        break;
                }
                return true;
            }
        });


    }


    private void openFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, fragment)
                .commit();
    }
}


// legacy code

        /* Viewpager 2 in bottom
        viewPager = findViewById(R.id.main_viewpager);


        tab = findViewById(R.id.test_tab);

        adapter = new MainViewpagerAdapter(this);
        viewPager.setAdapter(adapter);
        new TabLayoutMediator(tab, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setIcon(R.drawable.ic_home_btm);
                        break;
                    case 1:
                        tab.setIcon(R.drawable.ic_classes_btm);
                        break;
                    case 2:
                        tab.setIcon(R.drawable.ic_messages_btm);
                        break;
                    case 3:
                        tab.setIcon(R.drawable.ic_profile_btm_);
                        break;
                }
            }
        }).attach();*/