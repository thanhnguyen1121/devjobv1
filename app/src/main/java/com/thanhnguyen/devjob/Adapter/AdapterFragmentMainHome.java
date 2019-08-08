package com.thanhnguyen.devjob.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class AdapterFragmentMainHome extends FragmentStatePagerAdapter {

    List<Fragment> listFragment;
    List<String> listNameFragment;


    public AdapterFragmentMainHome(FragmentManager fm, List<Fragment> listFragment,
                                   List<String> listNameFragment) {
        super(fm);
        this.listFragment = listFragment;
        this.listNameFragment = listNameFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return this.listFragment.get(position);
    }

    @Override
    public int getCount() {
        return this.listNameFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.listNameFragment.get(position);
    }
}
