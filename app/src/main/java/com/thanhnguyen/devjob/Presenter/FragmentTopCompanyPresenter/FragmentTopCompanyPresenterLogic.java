package com.thanhnguyen.devjob.Presenter.FragmentTopCompanyPresenter;

import com.thanhnguyen.devjob.Model.ModelHome.HomeInfo;
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.FragmentView.FragmentTopCompany.FragmentTopCompanyViewImp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentTopCompanyPresenterLogic implements FragmentTopCompanyPresenterImp {

    private FragmentTopCompanyViewImp presenter;

    public FragmentTopCompanyPresenterLogic(FragmentTopCompanyViewImp presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getData(String token) {
        ApiUtil.getData().getAllTopCompany(token).enqueue(new Callback<HomeInfo>() {
            @Override
            public void onResponse(Call<HomeInfo> call, Response<HomeInfo> response) {
                if(response.isSuccessful()){
                    presenter.getData(response.body().getTopCompanies());
                }
            }

            @Override
            public void onFailure(Call<HomeInfo> call, Throwable t) {
                presenter.getError(t.getMessage());
            }
        });
    }
}
