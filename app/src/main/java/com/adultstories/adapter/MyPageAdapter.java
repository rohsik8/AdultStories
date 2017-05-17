package com.adultstories.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class MyPageAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragments;
    private String[] tabs = { "A", "B","C","D"};

    public MyPageAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        // Generate title based on item position
//            return tabs[position];
//    }

}
