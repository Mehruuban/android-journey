package com.mehru.implicitintentexa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerMessengerAdapter extends FragmentPagerAdapter {
    public ViewPagerMessengerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public ViewPagerMessengerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position==0){
            return new ChatFragment();
        } else if (position==1) {
            return new StatusFragment();
        } else {
            return new CallsFragment();
        }
    }


    @Override
    public int getCount() {
        return 3;  // no of Tabs
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0){
            return "Chats";
        } else if (position==1) {
            return "Status";
        }else {
            return "Calls";
        }
    }
}
