package com.thanhnguyen.devjob.Model.ModelCompanyDetail;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelCompanyDetail {

    @SerializedName("detail")
    @Expose
    private Detail detail;
    @SerializedName("thumbnail")
    @Expose
    private List<Thumbnail> thumbnail = null;
    @SerializedName("jobs")
    @Expose
    private CompanyDetailJob CompanyDetailJob;

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public List<Thumbnail> getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(List<Thumbnail> thumbnail) {
        this.thumbnail = thumbnail;
    }

    public CompanyDetailJob getCompanyDetailJob() {
        return CompanyDetailJob;
    }

    public void setCompanyDetailJob(CompanyDetailJob CompanyDetailJob) {
        this.CompanyDetailJob = CompanyDetailJob;
    }

}
