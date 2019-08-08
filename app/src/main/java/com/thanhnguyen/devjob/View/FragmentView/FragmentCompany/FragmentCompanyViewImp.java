package com.thanhnguyen.devjob.View.FragmentView.FragmentCompany;



import com.thanhnguyen.devjob.Model.ModelCompany.CompanyItem;

import java.util.List;

public interface FragmentCompanyViewImp {
    void getListCompany(List<CompanyItem> companyItemList);
    void getErrorWhenGetData(String mes);
}
