package com.thanhnguyen.devjob.Model.LoginPresenter;

import android.util.Log;

import com.thanhnguyen.devjob.Model.UserModel.UserStatus;
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.ActivityView.LoginActivity.LoginActivityViewImp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenterLogic implements LoginPresenterImp {
    private LoginActivityViewImp loginActivityViewImp;

    public LoginPresenterLogic(LoginActivityViewImp loginActivityViewImp) {
        this.loginActivityViewImp = loginActivityViewImp;
    }

    @Override
    public void login(String token, String email, String password) {
        ApiUtil.getData().getLoginStatus(token, email, password)
                .enqueue(new Callback<UserStatus>() {
                    @Override
                    public void onResponse(Call<UserStatus> call, Response<UserStatus> response) {
                        loginActivityViewImp.getUserStatus(response.body());
                    }

                    @Override
                    public void onFailure(Call<UserStatus> call, Throwable t) {
                        loginActivityViewImp.getError(t.getMessage());
                    }
                });

    }
}
