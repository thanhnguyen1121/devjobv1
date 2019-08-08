package com.thanhnguyen.devjob.Model.ModelHome;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountSkill {

    @SerializedName("cate_id")
    @Expose
    private Integer cateId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("count")
    @Expose
    private Integer count;

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
