package com.thanhnguyen.devjob.View.ActivityView.JobDetail;

import com.thanhnguyen.devjob.Model.ModelJobDetail.ModeJobDetailCompany;
import com.thanhnguyen.devjob.Model.ModelJobDetail.ModelJobDetailDetail;

public interface JobDetailViewImp {
    void getData(ModelJobDetailDetail detail, ModeJobDetailCompany company);
    void getError(String mes);
}
