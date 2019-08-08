package com.thanhnguyen.devjob.Model.ModelCompanyDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Detail {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("cover")
    @Expose
    private String cover;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("about")
    @Expose
    private String about;
    @SerializedName("website")
    @Expose
    private Object website;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("human_resource")
    @Expose
    private Integer humanResource;
    @SerializedName("facebook")
    @Expose
    private Object facebook;
    @SerializedName("twitter")
    @Expose
    private Object twitter;
    @SerializedName("youtube")
    @Expose
    private Object youtube;
    @SerializedName("follow")
    @Expose
    private Object follow;
    @SerializedName("type")
    @Expose
    private Object type;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("amountJob")
    @Expose
    private Integer amountJob;
    @SerializedName("sumViews")
    @Expose
    private Integer sumViews;
    @SerializedName("amountApplies")
    @Expose
    private Integer amountApplies;
    @SerializedName("amountSaved")
    @Expose
    private Integer amountSaved;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Object getWebsite() {
        return website;
    }

    public void setWebsite(Object website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getHumanResource() {
        return humanResource;
    }

    public void setHumanResource(Integer humanResource) {
        this.humanResource = humanResource;
    }

    public Object getFacebook() {
        return facebook;
    }

    public void setFacebook(Object facebook) {
        this.facebook = facebook;
    }

    public Object getTwitter() {
        return twitter;
    }

    public void setTwitter(Object twitter) {
        this.twitter = twitter;
    }

    public Object getYoutube() {
        return youtube;
    }

    public void setYoutube(Object youtube) {
        this.youtube = youtube;
    }

    public Object getFollow() {
        return follow;
    }

    public void setFollow(Object follow) {
        this.follow = follow;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getAmountJob() {
        return amountJob;
    }

    public void setAmountJob(Integer amountJob) {
        this.amountJob = amountJob;
    }

    public Integer getSumViews() {
        return sumViews;
    }

    public void setSumViews(Integer sumViews) {
        this.sumViews = sumViews;
    }

    public Integer getAmountApplies() {
        return amountApplies;
    }

    public void setAmountApplies(Integer amountApplies) {
        this.amountApplies = amountApplies;
    }

    public Integer getAmountSaved() {
        return amountSaved;
    }

    public void setAmountSaved(Integer amountSaved) {
        this.amountSaved = amountSaved;
    }

}