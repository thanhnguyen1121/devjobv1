package com.thanhnguyen.devjob.Presenter.FragmentCompanyPresenter;

import android.util.Log;

import com.thanhnguyen.devjob.Model.ModelCompany.CompanyModel;
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.FragmentView.FragmentCompany.FragmentCompanyViewImp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragementCompayLogic implements FragmentCompanyImp {
    private FragmentCompanyViewImp fragmentCompanyViewImp;

    public FragementCompayLogic(FragmentCompanyViewImp fragmentCompanyViewImp) {
        this.fragmentCompanyViewImp = fragmentCompanyViewImp;
    }

    @Override
    public void getListCompany(String token, String location, int totalPage, String companyName) {
        ApiUtil.getData().getAllCompanyModelInfo(token, location, totalPage, companyName)
                .enqueue(new Callback<CompanyModel>() {
                    @Override
                    public void onResponse(Call<CompanyModel> call, Response<CompanyModel> response) {
                        if(response.isSuccessful()){
                            Log.d("aaa", "onResponse: " + response.body());
                           fragmentCompanyViewImp.getListCompany(response.body().getDatas().getData());
                        }else{
                            Log.d("aaa", "onResponse: " + "Lỗi");
                        }
                    }

                    @Override
                    public void onFailure(Call<CompanyModel> call, Throwable t) {
                        fragmentCompanyViewImp.getErrorWhenGetData(t.getMessage());
                    }});
    }
}
