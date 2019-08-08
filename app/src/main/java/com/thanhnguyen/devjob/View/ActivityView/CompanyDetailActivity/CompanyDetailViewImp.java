package com.thanhnguyen.devjob.View.ActivityView.CompanyDetailActivity;

import com.thanhnguyen.devjob.Model.ModelCompanyDetail.CompanyDetailJobItem;
import com.thanhnguyen.devjob.Model.ModelCompanyDetail.Detail;
import com.thanhnguyen.devjob.Model.ModelCompanyDetail.Thumbnail;

import java.util.List;

public interface CompanyDetailViewImp {
    void getData(Detail detail, List<Thumbnail> thumbnailList, List<CompanyDetailJobItem> companyDetailJobItemList);
    void getError(String ErrorMes);
}
