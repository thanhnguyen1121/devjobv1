package com.thanhnguyen.devjob.Model.ModelMapJob;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Job {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lng")
    @Expose
    private String lng;
    @SerializedName("deal")
    @Expose
    private Integer deal;
    @SerializedName("salary_min")
    @Expose
    private Object salaryMin;
    @SerializedName("salary_max")
    @Expose
    private Object salaryMax;
    @SerializedName("feature")
    @Expose
    private Integer feature;
    @SerializedName("bonus")
    @Expose
    private Integer bonus;
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Integer getDeal() {
        return deal;
    }

    public void setDeal(Integer deal) {
        this.deal = deal;
    }

    public Object getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(Object salaryMin) {
        this.salaryMin = salaryMin;
    }

    public Object getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(Object salaryMax) {
        this.salaryMax = salaryMax;
    }

    public Integer getFeature() {
        return feature;
    }

    public void setFeature(Integer feature) {
        this.feature = feature;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}