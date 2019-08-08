package com.thanhnguyen.devjob.Model.ModelCompany;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompanyModel {

    @SerializedName("datas")
    @Expose
    private CompanyInfo datas;
    @SerializedName("countCompany")
    @Expose
    private Integer countCompany;

    public CompanyInfo getDatas() {
        return datas;
    }

    public void setDatas(CompanyInfo datas) {
        this.datas = datas;
    }

    public Integer getCountCompany() {
        return countCompany;
    }

    public void setCountCompany(Integer countCompany) {
        this.countCompany = countCompany;
    }

}
