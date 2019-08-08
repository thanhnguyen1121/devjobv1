package com.thanhnguyen.devjob.Presenter.FragmentJobPresenter;

import com.thanhnguyen.devjob.Model.ModelJob.Jobs;

import java.util.List;

public interface FragmentJobImp {
     void getAllJobInfor(int bonus, int total, String search);

     void getJobByFilter(String baseUrl, int bonus,int level, int skill);
}
