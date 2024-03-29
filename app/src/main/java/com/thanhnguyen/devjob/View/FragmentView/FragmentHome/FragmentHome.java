package com.thanhnguyen.devjob.View.FragmentView.FragmentHome;

import android.os.Bundle;
import android.util.Log;
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
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.FragmentView.FragmentTopJob.FragmentTopJob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentHome extends Fragment {

    CircleImageView mainHomeImgUserAvatar;
    @BindView(R.id.home_tablayout)
    TabLayout homeTablayout;
    @BindView(R.id.home_viewpager)
    ViewPager homeViewpager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
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

        listFragment.add(new FragmentTopJob(1));
        listFragment.add(new FragmentTopJob(2));

        List<String> listTitle = Arrays.asList("Reward Job", "Feature Job");
        AdapterFragmentMainHome fragmentMainHome = new AdapterFragmentMainHome(manager, listFragment, listTitle);
        homeViewpager.setAdapter(fragmentMainHome);
        homeTablayout.setupWithViewPager(homeViewpager);
        homeViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(homeTablayout));
        homeTablayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(homeViewpager));
    }
}
