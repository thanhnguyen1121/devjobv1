package com.thanhnguyen.devjob.View.FragmentView.FragmentTopJob;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.thanhnguyen.devjob.Adapter.AdapterMainRcvJobs;
import com.thanhnguyen.devjob.Model.ModelJob.Cate;
import com.thanhnguyen.devjob.Model.ModelJob.Company;
import com.thanhnguyen.devjob.Model.ModelJob.CountLevel;
import com.thanhnguyen.devjob.Model.ModelJob.CountSkill;
import com.thanhnguyen.devjob.Model.ModelJob.JobItem;
import com.thanhnguyen.devjob.Presenter.FragmentJobPresenter.FragmentJobImp;
import com.thanhnguyen.devjob.Presenter.FragmentJobPresenter.FragmentJobLogic;
import com.thanhnguyen.devjob.Presenter.Interface.ItemRcvClickListener;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.View.ActivityView.JobDetail.JobDetailActivity;
import com.thanhnguyen.devjob.View.FragmentView.FragmentJob.FragmentJobViewImp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentTopJob extends Fragment implements ItemRcvClickListener, FragmentJobViewImp, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.fragment_top_jobs_rcv_list)
    RecyclerView fragmentTopJobsRcvList;
    @BindView(R.id.fragment_top_job_swipeRefreshLayout)
    SwipeRefreshLayout fragmentTopJobSwipeRefreshLayout;

    private AdapterMainRcvJobs adapterMainRcvJobs;
    private List<JobItem> jobItemList;
    private List<Company> companyList;
    private FragmentJobImp presenter;

    private int check;

    public FragmentTopJob(int check) {
        this.check = check;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_job, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.companyList = new ArrayList<>();
        this.jobItemList = new ArrayList<>();
        presenter = new FragmentJobLogic(this);
        presenter.getAllJobInfor(0, 10, "");
        fragmentTopJobSwipeRefreshLayout.setRefreshing(true);
       fragmentTopJobSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void clickedItem(int position) {
        Intent intent = new Intent(getContext(), JobDetailActivity.class);
        intent.putExtra("slug", jobItemList.get(position).getSlug());
        startActivity(intent);
    }

    @Override
    public void getJobItems(List<JobItem> jobItemList, List<Company> companyList,
                            List<CountLevel> levelName, List<CountSkill> skillName, List<Cate> cateList) {
       if(!jobItemList.isEmpty()){
           fragmentTopJobSwipeRefreshLayout.setRefreshing(false);
           this.jobItemList = jobItemList;
           this.companyList = companyList;

           if (check == 1) {
               Collections.sort(this.jobItemList);
               createRcv(jobItemList, companyList, cateList);
           } else {
               createRcv(jobItemList, companyList, cateList);
           }
       }
    }

    @Override
    public void getJobItemsFilter(List<JobItem> jobItemList, List<Company> companyList,
                                  List<Cate> cateList) {

    }

    @Override
    public void getError(String error) {
    }

    private void createRcv(List<JobItem> jobItemList, List<Company> companyList, List<Cate> cateList) {
        adapterMainRcvJobs = new AdapterMainRcvJobs(jobItemList, companyList, this, cateList);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        fragmentTopJobsRcvList.setLayoutManager(manager);
        fragmentTopJobsRcvList.setAdapter(adapterMainRcvJobs);
        fragmentTopJobsRcvList.hasFixedSize();
    }

    @Override
    public void onRefresh() {
        presenter.getAllJobInfor(0, 10, "");
    }
}
