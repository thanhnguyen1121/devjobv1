package com.thanhnguyen.devjob.Model.ModelJob;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountSalary2 {

    @SerializedName("salary_max")
    @Expose
    private Object salaryMax;
    @SerializedName("count")
    @Expose
    private Integer count;

    public Object getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(Object salaryMax) {
        this.salaryMax = salaryMax;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
