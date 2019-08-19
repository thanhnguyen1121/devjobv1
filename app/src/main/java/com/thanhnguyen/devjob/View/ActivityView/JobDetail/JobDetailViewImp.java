package com.thanhnguyen.devjob.View.ActivityView.JobDetail;

import com.thanhnguyen.devjob.Model.ModelJobDetail.ModeJobDetailCompany;
import com.thanhnguyen.devjob.Model.ModelJobDetail.ModelJobDetailDetail;
import com.thanhnguyen.devjob.Model.ModelJobDetail.ModelJobDetailJobRelate;

import java.util.List;

public interface JobDetailViewImp {
    void getData(ModelJobDetailDetail detail, ModeJobDetailCompany company, List<ModelJobDetailJobRelate> ralate);
    void getError(String mes);
}
