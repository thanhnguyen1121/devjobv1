package com.thanhnguyen.devjob.Presenter.LoginPresenter;

import android.util.Log;

import com.thanhnguyen.devjob.Model.UserModel.UserStatus;
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.ActivityView.LoginActivity.LoginActivityViewImp;

import java.util.List;
import java.util.Map;

import okhttp3.Headers;
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
                        Log.d("aaa", "onResponse: " + response.body());
                        loginActivityViewImp.getUserStatus(response.body());
                        Headers headers = response.headers();
                        Map<String, List<String>> headerList = headers.toMultimap();
                        List<String> listCookie = headerList.get("set-cookie");

                        String cookie = listCookie.get(listCookie.size()-1);
                        Constant.setCookie(cookie);
                    }

                    @Override
                    public void onFailure(Call<UserStatus> call, Throwable t) {
                        loginActivityViewImp.getError(t.getMessage());
                    }
                });

    }

    @Override
    public void switchUserInterface(int role) {
        switch (role){
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}
