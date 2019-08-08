package com.thanhnguyen.devjob.View.FragmentView.FragmentJob;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.thanhnguyen.devjob.Adapter.AdapterMainRcvJobs;
import com.thanhnguyen.devjob.Model.ModelJob.Cate;
import com.thanhnguyen.devjob.Model.ModelJob.Company;
import com.thanhnguyen.devjob.Model.ModelJob.CountLevel;
import com.thanhnguyen.devjob.Model.ModelJob.CountSkill;
import com.thanhnguyen.devjob.Model.ModelJob.JobInfo;
import com.thanhnguyen.devjob.Model.ModelJob.JobItem;
import com.thanhnguyen.devjob.Presenter.FragmentJobPresenter.FragmentJobImp;
import com.thanhnguyen.devjob.Presenter.FragmentJobPresenter.FragmentJobLogic;
import com.thanhnguyen.devjob.Presenter.Interface.ItemRcvClickListener;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.Utils.MyAsynctask;
import com.thanhnguyen.devjob.View.ActivityView.JobDetail.JobDetailActivity;
import com.thanhnguyen.devjob.View.ActivityView.searchJobOptionActivity.SearchJobOptionActivity;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentJob extends Fragment implements FragmentJobViewImp, ItemRcvClickListener, SwipeRefreshLayout.OnRefreshListener {

    CircleImageView mainJobsImgUserAvatar;
    @BindView(R.id.main_jobs_key_words)
    EditText mainJobsKeyWords;
    @BindView(R.id.main_job_rcv)
    RecyclerView mainJobRcv;
    @BindView(R.id.fragment_job_swipeRefresh)
    SwipeRefreshLayout spRefresh;
    @BindView(R.id.main_job_img_view_search_more)
    ImageView imgSearchMore;

    private AdapterMainRcvJobs adapterMainRcvJobs;
    private Context context;
    private List<JobItem> jobItemList;
    private List<Company> companyList;
    private List<CountLevel> listLevel;
    private List<CountSkill> listSkill;
    private List<Cate> listCates;
    private String url;

    private FragmentJobImp fragmentJobImp;
    private int bonus = 0, total = 50, level = 0, skill = 0;

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
                Intent intent = new Intent(getActivity(), SearchJobOptionActivity.class);

                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("level", (ArrayList<? extends Parcelable>) this.listLevel);
                bundle.putParcelableArrayList("skill", (ArrayList<? extends Parcelable>) this.listSkill);
                intent.putExtra("bundle", bundle);
                startActivityForResult(intent, Constant.REQUEST_CODE_SEARCH_MORE);
                break;
        }
    }

    @Override
    public void getJobItems(List<JobItem> jobItemList, List<Company> companyList,
                            List<CountLevel> levelName, List<CountSkill> skillName) {
        this.jobItemList = jobItemList;
        createRcvMainJobs(jobItemList, companyList, skillName);
        this.listSkill = skillName;
        this.listLevel = levelName;
    }

    @Override
    public void getJobItemsFilter(List<JobItem> jobItemList, List<Company> companyList, List<CountSkill> countSkillList) {
        if(jobItemList.isEmpty()){
            Toast.makeText(context, "Không có công việc bạn cần tìm", Toast.LENGTH_SHORT).show();
            createRcvMainJobs(jobItemList, companyList, countSkillList);
        }else{
            createRcvMainJobs(jobItemList, companyList, countSkillList);
        }

    }

    private void createRcvMainJobs(List<JobItem> jobItemList, List<Company> companyList, List<CountSkill> countSkillList) {

        adapterMainRcvJobs = new AdapterMainRcvJobs(jobItemList, companyList, this, countSkillList);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constant.REQUEST_CODE_SEARCH_MORE && resultCode == Constant.RESULT_CODE_SEARCH_MORE && data != null) {
            int bonus = data.getIntExtra("bonus", 0);
            int level = data.getIntExtra("level", 0);
            int skill = data.getIntExtra("skill", 0);

            url = ApiUtil.BaseUrl + "api/job/job-listings?token=" + Constant.token;
            fragmentJobImp.getJobByFilter(url, bonus, level, skill);
        }
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fragmentJobImp.getAllJobInfor(bonus, total, "");
                spRefresh.setRefreshing(false);
            }
        },1000);
    }
}
