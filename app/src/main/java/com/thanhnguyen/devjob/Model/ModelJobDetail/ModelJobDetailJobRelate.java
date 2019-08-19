package com.thanhnguyen.devjob.Model.ModelJobDetail;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelJobDetailJobRelate {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("feature")
    @Expose
    private Integer feature;
    @SerializedName("bonus")
    @Expose
    private Integer bonus;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("skills")
    @Expose
    private List<ModelJobDetailSkill> ModelJobDetailSkills = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<ModelJobDetailSkill> getModelJobDetailSkills() {
        return ModelJobDetailSkills;
    }

    public void setModelJobDetailSkills(List<ModelJobDetailSkill> ModelJobDetailSkills) {
        this.ModelJobDetailSkills = ModelJobDetailSkills;
    }

}