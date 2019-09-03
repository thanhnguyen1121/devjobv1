package com.thanhnguyen.devjob.Model.ModelEmployer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmployeeDashbroadInfor {

    @SerializedName("jobs")
    @Expose
    private EmployeeDashbroadJobs jobs;
    @SerializedName("noti")
    @Expose
    private Integer noti;

    public EmployeeDashbroadJobs getJobs() {
        return jobs;
    }

    public void setJobs(EmployeeDashbroadJobs jobs) {
        this.jobs = jobs;
    }

    public Integer getNoti() {
        return noti;
    }

    public void setNoti(Integer noti) {
        this.noti = noti;
    }

}