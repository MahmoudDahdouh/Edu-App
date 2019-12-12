package com.mahmoud.dahdouh.eduapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mahmoud.dahdouh.eduapp.Fragment.LoginFragment;

public class PagerAdapter extends FragmentStateAdapter {

    public PagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new LoginFragment();

        Bundle args = new Bundle();
        args.putString("msg", "this message from adapter");

        fragment.setArguments(args);

        return fragment;

    }

    @Override
    public int getItemCount() {
        return 100;
    }


}
