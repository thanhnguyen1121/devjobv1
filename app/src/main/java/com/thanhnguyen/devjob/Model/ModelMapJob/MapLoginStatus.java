package com.thanhnguyen.devjob.Model.ModelMapJob;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MapLoginStatus {

    @SerializedName("jobs")
    @Expose
    private List<Job> jobs = null;
    @SerializedName("count")
    @Expose
    private List<Count> count = null;

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Count> getCount() {
        return count;
    }

    public void setCount(List<Count> count) {
        this.count = count;
    }

}