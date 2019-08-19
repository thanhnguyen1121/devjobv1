package com.thanhnguyen.devjob.Model.ModelJobDetail;


import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelJobDetailJobDetail {

    @SerializedName("detail")
    @Expose
    private ModelJobDetailDetail detail;
    @SerializedName("company")
    @Expose
    private ModeJobDetailCompany company;
    @SerializedName("job_relate")
    @Expose
    private List<ModelJobDetailJobRelate> ModelJobDetailJobRelate = null;
    @SerializedName("ModelJobDetailTags")
    @Expose
    private List<ModelJobDetailTag> ModelJobDetailTags = null;
    @SerializedName("r")
    @Expose
    private Integer r;
    @SerializedName("user_data")
    @Expose
    private String userData;
    @SerializedName("default_cv")
    @Expose
    private Integer defaultCv;
    @SerializedName("saved")
    @Expose
    private Integer saved;
    @SerializedName("applied")
    @Expose
    private List<Object> applied = null;
    @SerializedName("apply")
    @Expose
    private Integer apply;

    public ModelJobDetailDetail getDetail() {
        return detail;
    }

    public void setDetail(ModelJobDetailDetail detail) {
        this.detail = detail;
    }

    public ModeJobDetailCompany getCompany() {
        return company;
    }

    public void setCompany(ModeJobDetailCompany company) {
        this.company = company;
    }

    public List<ModelJobDetailJobRelate> getModelJobDetailJobRelate() {
        return ModelJobDetailJobRelate;
    }

    public void setModelJobDetailJobRelate(List<ModelJobDetailJobRelate> ModelJobDetailJobRelate) {
        this.ModelJobDetailJobRelate = ModelJobDetailJobRelate;
    }

    public List<ModelJobDetailTag> getModelJobDetailTags() {
        return ModelJobDetailTags;
    }

    public void setModelJobDetailTags(List<ModelJobDetailTag> ModelJobDetailTags) {
        this.ModelJobDetailTags = ModelJobDetailTags;
    }

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }

    public Integer getDefaultCv() {
        return defaultCv;
    }

    public void setDefaultCv(Integer defaultCv) {
        this.defaultCv = defaultCv;
    }

    public Integer getSaved() {
        return saved;
    }

    public void setSaved(Integer saved) {
        this.saved = saved;
    }

    public List<Object> getApplied() {
        return applied;
    }

    public void setApplied(List<Object> applied) {
        this.applied = applied;
    }

    public Integer getApply() {
        return apply;
    }

    public void setApply(Integer apply) {
        this.apply = apply;
    }

}