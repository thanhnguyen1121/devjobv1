package com.thanhnguyen.devjob.Model.ModelDashboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginStatus {

    @SerializedName("applies")
    @Expose
    private Applies applies;

    public Applies getApplies() {
        return applies;
    }

    public void setApplies(Applies applies) {
        this.applies = applies;
    }

}