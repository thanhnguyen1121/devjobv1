package com.thanhnguyen.devjob.Presenter.JobDetailPresenter;

import android.util.Log;

import com.thanhnguyen.devjob.Model.ModelJobDetail.ModelJobDetailJobDetail;
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.ActivityView.JobDetail.JobDetailViewImp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobDetailPresenterLogic implements JobDetailPresenterImp {

    private JobDetailViewImp jobDetailViewImp;

    public JobDetailPresenterLogic(JobDetailViewImp jobDetailViewImp) {
        this.jobDetailViewImp = jobDetailViewImp;
    }

    @Override
    public void getJobDetailInfor(String slug, String token) {
        ApiUtil.getData().getJobDetail(slug, token).enqueue(new Callback<ModelJobDetailJobDetail>() {
            @Override
            public void onResponse(Call<ModelJobDetailJobDetail> call, Response<ModelJobDetailJobDetail> response) {
                if(response.isSuccessful()){
                    jobDetailViewImp.getData(response.body().getDetail(), response.body().getCompany());
                }
            }

            @Override
            public void onFailure(Call<ModelJobDetailJobDetail> call, Throwable t) {
               jobDetailViewImp.getError(t.getMessage());
            }
        });
    }
}
