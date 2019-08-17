package com.thanhnguyen.devjob.Presenter.FragmentJobPresenter;

import android.util.Log;

import com.thanhnguyen.devjob.Model.ModelJob.Cate;
import com.thanhnguyen.devjob.Model.ModelJob.Company;
import com.thanhnguyen.devjob.Model.ModelJob.CountLevel;
import com.thanhnguyen.devjob.Model.ModelJob.CountSkill;
import com.thanhnguyen.devjob.Model.ModelJob.JobInfo;
import com.thanhnguyen.devjob.Model.ModelJob.JobItem;
import com.thanhnguyen.devjob.Model.ModelJob.Jobs;
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.FragmentView.FragmentJob.FragmentJobViewImp;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentJobLogic implements FragmentJobImp {

    FragmentJobViewImp faFragmentJobViewImp;

    public FragmentJobLogic(FragmentJobViewImp faFragmentJobViewImp) {
        this.faFragmentJobViewImp = faFragmentJobViewImp;
    }

    @Override
    public void getAllJobInfor(int bonus, int total, String search) {
        ApiUtil.getData().getAllJobInfo(Constant.token, search, bonus, total).enqueue(new Callback<JobInfo>() {
            @Override
            public void onResponse(Call<JobInfo> call, Response<JobInfo> response) {
                if (response.isSuccessful()) {
                    Log.d("ddd", "sucess: " + response.body());
                    List<CountSkill> countSkillList = new ArrayList<>();
                    List<CountLevel> countLevelList = new ArrayList<>();
                    countSkillList = response.body().getCountSkill();
                    countLevelList = response.body().getCountLevel();

                    List<JobItem> jobsList = response.body().getJobs().getData();
                    List<Company> listCompany = response.body().getCompanies();
                    List<Cate> listCate = response.body().getCates();
                    faFragmentJobViewImp.getJobItems(jobsList, listCompany,
                            countLevelList, countSkillList, listCate);
                }
            }

            @Override
            public void onFailure(Call<JobInfo> call, Throwable t) {
                Log.d("aaa", "onFailure: " + t.getMessage());
            }
        });
    }

    @Override
    public void getJobByFilter(String url, int bonus, int level, int skill) {
        if (bonus != 0) {
            url += "&bonus=" + bonus;
        }
        if (level != 0) {
            url += "&filterLevel[]=" + level;
        }
        if (skill != 0) {
            url += "&filterSkill[]=" + (skill);
        }

        url +="&totalPage=50";
        Log.d("aaa", "getJobByFilter: " + url);
        ApiUtil.getData().getJobFilter(url).enqueue(new Callback<JobInfo>() {
            @Override
            public void onResponse(Call<JobInfo> call, Response<JobInfo> response) {
                if (response.isSuccessful()) {
                    Log.d("aaa", "onResponse: "+ response);
                    List<JobItem> jobItemList = response.body().getJobs().getData();
                    List<Company> companyList = response.body().getCompanies();
                    List<String> listCountSkillName = new ArrayList<>();
                    List<String> listCountLevelName = new ArrayList<>();
                    List<CountSkill> countSkillList = response.body().getCountSkill();
                    List<Cate> listCate = response.body().getCates();
                    for (CountSkill item : countSkillList) {
                        listCountSkillName.add(item.getName());
                    }
                    List<CountLevel> countLevelList = response.body().getCountLevel();
                    for (CountLevel item : countLevelList) {
                        listCountLevelName.add(item.getName());
                    }
                    faFragmentJobViewImp.getJobItemsFilter(jobItemList, companyList, listCate);
                }
            }

            @Override
            public void onFailure(Call<JobInfo> call, Throwable t) {
                Log.d("aaa", "onFailure: " + t.getMessage());
            }
        });
    }

    @Override
    public void getJobByFilter(String url) {
        ApiUtil.getData().getJobFilter(url).enqueue(new Callback<JobInfo>() {
            @Override
            public void onResponse(Call<JobInfo> call, Response<JobInfo> response) {
                if(response.isSuccessful()){
                    faFragmentJobViewImp.getJobItemsFilter(response.body().getJobs().getData(),
                            response.body().getCompanies(),
                            response.body().getCates());
                }
            }

            @Override
            public void onFailure(Call<JobInfo> call, Throwable t) {
                faFragmentJobViewImp.getError(t.getMessage());
            }
        });
    }

}
