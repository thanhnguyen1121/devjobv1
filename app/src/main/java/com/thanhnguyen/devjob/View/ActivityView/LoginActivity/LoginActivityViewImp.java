package com.thanhnguyen.devjob.View.ActivityView.LoginActivity;

import com.thanhnguyen.devjob.Model.UserModel.UserStatus;

public interface LoginActivityViewImp {
    void getUserStatus(UserStatus userStatus);
    void getError(String mes);
}
