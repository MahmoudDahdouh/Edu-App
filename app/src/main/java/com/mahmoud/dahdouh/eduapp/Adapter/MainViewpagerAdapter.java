package com.mahmoud.dahdouh.eduapp.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mahmoud.dahdouh.eduapp.Fragment.HomeFragment;

public class MainViewpagerAdapter extends FragmentStateAdapter {

    public MainViewpagerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new HomeFragment();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
