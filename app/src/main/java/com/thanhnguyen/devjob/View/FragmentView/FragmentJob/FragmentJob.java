package com.thanhnguyen.devjob.View.FragmentView.FragmentJob;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.jaredrummler.materialspinner.MaterialSpinner;
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
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.ActivityView.JobDetail.JobDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class FragmentJob extends Fragment implements FragmentJobViewImp, ItemRcvClickListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.main_jobs_key_words)
    EditText mainJobsKeyWords;
    @BindView(R.id.main_job_rcv)
    RecyclerView mainJobRcv;
    @BindView(R.id.fragment_job_swipeRefresh)
    SwipeRefreshLayout spRefresh;
    @BindView(R.id.main_job_img_view_search_more)
    ImageView imgSearchMore;
    @BindView(R.id.ln_show_search_more)
    LinearLayout lnShowSearchMore;
    @BindView(R.id.sp_jobfragment_bonus)
    MaterialSpinner spJobfragmentBonus;
    @BindView(R.id.sp_jobfragment_level)
    MaterialSpinner spJobfragmentLevel;
    @BindView(R.id.sp_jobfragment_skill)
    MaterialSpinner spJobfragmentSkill;
    @BindView(R.id.sp_jobfragment_location)
    MaterialSpinner spJobfragmentLocation;


    private AdapterMainRcvJobs adapterMainRcvJobs;
    private Context context;
    private List<JobItem> jobItemList;
    private List<Company> companyList;
    private List<CountLevel> listLevel;
    private List<CountSkill> listSkill;
    private List<Cate> listCates;
    private String url;
    private boolean isShowSearch = false;
    private FragmentJobImp fragmentJobImp;
    private int bonus = 0, total = 50, level = 0, skill = 0;
    private int positionBonus = 0;
    private int positionLevel = 0;
    private int positionSkill = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_job, container, false);
        context = container.getContext();
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentJobImp = new FragmentJobLogic(this);
        fragmentJobImp.getAllJobInfor(bonus, total, "");
        jobItemList = new ArrayList<>();
        companyList = new ArrayList<>();
        listLevel = new ArrayList<>();
        listSkill = new ArrayList<>();
        listCates = new ArrayList<>();
        spRefresh.setOnRefreshListener(this);


    }

    @OnClick({R.id.main_jobs_img_view_search, R.id.main_job_img_view_search_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.main_jobs_img_view_search:
                fragmentJobImp.getAllJobInfor(bonus, total, mainJobsKeyWords.getText().toString().trim());
                break;
            case R.id.main_job_img_view_search_more:
                if (isShowSearch == false) {
                    imgSearchMore.setRotation(-45);
                    lnShowSearchMore.setVisibility(View.VISIBLE);
                    isShowSearch = true;
                } else {
                    imgSearchMore.setRotation(0);
                    lnShowSearchMore.setVisibility(View.GONE);
                    isShowSearch = false;
                }
                break;
        }
    }

    @Override
    public void getJobItems(List<JobItem> jobItemList, List<Company> companyList,
                            List<CountLevel> levelName, List<CountSkill> skillName, List<Cate> cateList) {
        this.jobItemList = jobItemList;
        createRcvMainJobs(jobItemList, companyList, cateList);
        this.listSkill = skillName;
        this.listLevel = levelName;
        setOptionSearch(this.listLevel, this.listSkill);
    }

    @Override
    public void getJobItemsFilter(List<JobItem> jobItemList, List<Company> companyList, List<Cate> cateList) {
        if (jobItemList.isEmpty()) {
            Toast.makeText(context, "Không có công việc bạn cần tìm", Toast.LENGTH_SHORT).show();
            createRcvMainJobs(jobItemList, companyList, cateList);
        } else {
            createRcvMainJobs(jobItemList, companyList, cateList);
        }

    }

    @Override
    public void getError(String error) {
        Log.d("aaa", "getError: " + error);
    }

    private void createRcvMainJobs(List<JobItem> jobItemList, List<Company> companyList, List<Cate> cateList) {

        adapterMainRcvJobs = new AdapterMainRcvJobs(jobItemList, companyList, this, cateList);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.VERTICAL);
        mainJobRcv.setLayoutManager(manager);
        mainJobRcv.setAdapter(adapterMainRcvJobs);

    }

    @Override
    public void clickedItem(int position) {
        Intent intent = new Intent(getContext(), JobDetailActivity.class);
        intent.putExtra("slug", jobItemList.get(position).getSlug());
        startActivity(intent);
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == Constant.REQUEST_CODE_SEARCH_MORE && resultCode == Constant.RESULT_CODE_SEARCH_MORE && data != null) {
//            int bonus = data.getIntExtra("bonus", 0);
//            int level = data.getIntExtra("level", 0);
//            int skill = data.getIntExtra("skill", 0);
//
//            url = ApiUtil.BaseUrl + "api/job/job-listings?token=" + Constant.token;
//            fragmentJobImp.getJobByFilter(url, bonus, level, skill);
//        }
//    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isShowSearch = false;
                lnShowSearchMore.setVisibility(View.GONE);
                fragmentJobImp.getAllJobInfor(bonus, total, "");
                spRefresh.setRefreshing(false);
            }
        }, 1000);
    }

    private void setOptionSearch(List<CountLevel> levelName, List<CountSkill> skillName) {
        List<String> listNameSkill = new ArrayList<>();
        List<String> listNameLevel = new ArrayList<>();
        listNameLevel.add("All");
        listNameSkill.add("All");
        for (CountSkill item : skillName) {
            listNameSkill.add(item.getName());
        }
        for (CountLevel item : levelName) {
            listNameLevel.add(item.getName());
        }
        spJobfragmentBonus.setItems("All", "Default", "Bonus");
        spJobfragmentSkill.setItems(listNameSkill);
        spJobfragmentLevel.setItems(listNameLevel);


        spJobfragmentBonus.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                positionBonus = position;
                //String url1 = xuLyUrl(positionBonus, positionLevel, positionSkill, levelName, skillName);
                fragmentJobImp.getJobByFilter(xuLyUrl(positionBonus, positionLevel, positionSkill, levelName, skillName));
            }
        });
        spJobfragmentSkill.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                positionSkill = position;
                //String url = xuLyUrl(positionBonus, positionLevel, positionSkill, levelName, skillName);
                fragmentJobImp.getJobByFilter(xuLyUrl(positionBonus, positionLevel, positionSkill, levelName, skillName));
            }
        });

        spJobfragmentLevel.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                positionLevel = position;
                //String url = xuLyUrl(positionBonus, positionLevel, positionSkill, levelName, skillName);
                fragmentJobImp.getJobByFilter(xuLyUrl(positionBonus, positionLevel, positionSkill, levelName, skillName));
            }
        });
    }

    private String xuLyUrl(int positionBonus, int positionLevel, int positionSkill,
                           List<CountLevel> levelName, List<CountSkill> skillName) {
        String url = ApiUtil.BaseUrl + "api/job/job-listings?token=" + Constant.token + "&totalPage=50";
        if (positionBonus != 0 && positionLevel != 0 && positionSkill != 0) {

            return url + "&bonus=" + positionBonus + "&filterSkill[]=" + skillName.get(positionSkill - 1).getCateId()
                    + "&filterLevel[]=" + levelName.get(positionLevel - 1).getLevelJob();

        } else if (positionLevel == 0 && positionSkill != 0) {

            return url + "&bonus=" + positionBonus + "&filterSkill[]=" + skillName.get(positionSkill - 1).getCateId();

        } else if (positionBonus != 0 && positionLevel != 0) {
            return url + "&bonus=" + positionBonus + "&filterLevel[]=" + levelName.get(positionLevel - 1).getLevelJob();
        } else if (positionBonus != 0) {

            return url + "&bonus=" + positionBonus;

        } else if (positionLevel != 0 && positionSkill != 0) {

            return url + "&filterSkill[]=" + skillName.get(positionSkill - 1).getCateId() +
                    "&filterLevel[]=" + levelName.get(positionLevel - 1).getLevelJob();

        } else if ( positionLevel == 0) {

            return url;

        } else if (positionBonus != 0 && positionLevel == 0 && positionSkill != 0) {

            return url + "&bonus=" + positionBonus + "&filterSkill[]=" + skillName.get(positionSkill - 1).getCateId();

        } else {

            return url + "&filterLevel[]=" + levelName.get(positionLevel - 1).getLevelJob();

        }
    }
}
