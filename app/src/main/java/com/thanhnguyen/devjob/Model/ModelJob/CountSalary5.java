package com.thanhnguyen.devjob.Model.ModelJob;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountSalary5 {

    @SerializedName("salary_min")
    @Expose
    private Object salaryMin;
    @SerializedName("count")
    @Expose
    private Integer count;

    public Object getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(Object salaryMin) {
        this.salaryMin = salaryMin;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}