package com.mahmoud.dahdouh.eduapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mahmoud.dahdouh.eduapp.Fragment.LoginFragment;
import com.mahmoud.dahdouh.eduapp.Fragment.SignupFragment;

public class PagerAdapter extends FragmentStateAdapter {

    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new LoginFragment();
            case 1:
                return new SignupFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }

}
