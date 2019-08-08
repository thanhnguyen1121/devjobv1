package com.thanhnguyen.devjob.Model.ModelHome;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeInfo {
    @SerializedName("top_companies")
    @Expose
    private List<TopCompany> topCompanies = null;


    public List<TopCompany> getTopCompanies() {
        return topCompanies;
    }

    public void setTopCompanies(List<TopCompany> topCompanies) {
        this.topCompanies = topCompanies;
    }

}