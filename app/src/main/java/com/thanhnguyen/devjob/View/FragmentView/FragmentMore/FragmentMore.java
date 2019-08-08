package com.thanhnguyen.devjob.View.FragmentView.FragmentMore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.thanhnguyen.devjob.Adapter.AdapterFragmentMainHome;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.View.FragmentView.FragmentCourse.FragmentCourse;
import com.thanhnguyen.devjob.View.FragmentView.FragmentEvent.FragmentEvent;
import com.thanhnguyen.devjob.View.FragmentView.FragmentTopJob.FragmentTopJob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentMore extends Fragment {
    @BindView(R.id.more_tablayout)
    TabLayout moreTablayout;
    @BindView(R.id.more_viewpager)
    ViewPager moreViewpager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createControll();
    }

    private void createControll() {
        FragmentManager manager = getFragmentManager();
        List<Fragment> listFragment = new ArrayList<>();

        listFragment.add(new FragmentEvent());
        listFragment.add(new FragmentCourse());

        List<String> listTitle = Arrays.asList("Event", "Course");
        AdapterFragmentMainHome fragmentMainHome = new AdapterFragmentMainHome(manager, listFragment, listTitle);
        moreViewpager.setAdapter(fragmentMainHome);
        moreTablayout.setupWithViewPager(moreViewpager);
        moreViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(moreTablayout));
        moreTablayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(moreViewpager));
    }

}
