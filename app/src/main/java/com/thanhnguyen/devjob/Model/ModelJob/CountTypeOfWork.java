package com.thanhnguyen.devjob.Model.ModelJob;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountTypeOfWork {

    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("count")
    @Expose
    private Integer count;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}