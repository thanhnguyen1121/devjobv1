package com.thanhnguyen.devjob.View.FragmentView.FragmentTopCompany;

import com.thanhnguyen.devjob.Model.ModelHome.TopCompany;

import java.util.List;

public interface FragmentTopCompanyViewImp {
    void getData(List<TopCompany> topCompanies);
    void getError(String mes);
}
