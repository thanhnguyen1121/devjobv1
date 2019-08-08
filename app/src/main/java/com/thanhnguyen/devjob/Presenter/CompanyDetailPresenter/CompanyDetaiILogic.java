package com.thanhnguyen.devjob.Presenter.CompanyDetailPresenter;

import android.util.Log;

import com.thanhnguyen.devjob.Model.ModelCompanyDetail.ModelCompanyDetail;
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.ActivityView.CompanyDetailActivity.CompanyDetailViewImp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompanyDetaiILogic implements CompanyDetailImp {
    private CompanyDetailViewImp companyDetailViewImp;

    public CompanyDetaiILogic(CompanyDetailViewImp companyDetailViewImp) {
        this.companyDetailViewImp = companyDetailViewImp;
    }

    @Override
    public void getData(String token, int id, int paginate) {
        ApiUtil.getData().getModelCompanyDetail(token, id, paginate)
                .enqueue(new Callback<ModelCompanyDetail>() {
                    @Override
                    public void onResponse(Call<ModelCompanyDetail> call, Response<ModelCompanyDetail> response) {
                        if(response.isSuccessful()){
                            companyDetailViewImp.getData(response.body().getDetail(), response.body().getThumbnail()
                            ,response.body().getCompanyDetailJob().getData());
                        }
                    }

                    @Override
                    public void onFailure(Call<ModelCompanyDetail> call, Throwable t) {
                        companyDetailViewImp.getError(t.getMessage());
                    }
                });

    }
}
