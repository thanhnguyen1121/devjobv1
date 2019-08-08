package com.thanhnguyen.devjob.Model.ModelJob;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobItem implements Comparable<JobItem>{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("company_id")
    @Expose
    private Integer companyId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("salary_min")
    @Expose
    private String salaryMin;
    @SerializedName("salary_max")
    @Expose
    private String salaryMax;
    @SerializedName("level_job")
    @Expose
    private Integer levelJob;
    @SerializedName("requirement")
    @Expose
    private String requirement;
    @SerializedName("benefit")
    @Expose
    private String benefit;
    @SerializedName("bonus")
    @Expose
    private Integer bonus;
    @SerializedName("location_id")
    @Expose
    private Integer locationId;
    @SerializedName("views")
    @Expose
    private String views;
    @SerializedName("confirm")
    @Expose
    private Integer confirm;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("about_money")
    @Expose
    private Integer aboutMoney;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("user_id_update")
    @Expose
    private String userIdUpdate;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("deal")
    @Expose
    private Integer deal;
    @SerializedName("feature")
    @Expose
    private Integer feature;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("jobs_id")
    @Expose
    private String jobsId;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("job_id")
    @Expose
    private Integer jobId;
    @SerializedName("cate_id")
    @Expose
    private Integer cateId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_company")
    @Expose
    private String companyName;
    @SerializedName("address_job")
    @Expose
    private String address_job;

    public String getAddress_job() {
        return address_job;
    }

    public void setAddress_job(String address_job) {
        this.address_job = address_job;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(String salaryMin) {
        this.salaryMin = salaryMin;
    }

    public String getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(String salaryMax) {
        this.salaryMax = salaryMax;
    }

    public Integer getLevelJob() {
        return levelJob;
    }

    public void setLevelJob(Integer levelJob) {
        this.levelJob = levelJob;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public Integer getConfirm() {
        return confirm;
    }

    public void setConfirm(Integer confirm) {
        this.confirm = confirm;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAboutMoney() {
        return aboutMoney;
    }

    public void setAboutMoney(Integer aboutMoney) {
        this.aboutMoney = aboutMoney;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getUserIdUpdate() {
        return userIdUpdate;
    }

    public void setUserIdUpdate(String userIdUpdate) {
        this.userIdUpdate = userIdUpdate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeal() {
        return deal;
    }

    public void setDeal(Integer deal) {
        this.deal = deal;
    }

    public Integer getFeature() {
        return feature;
    }

    public void setFeature(Integer feature) {
        this.feature = feature;
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

    public String getJobsId() {
        return jobsId;
    }

    public void setJobsId(String jobsId) {
        this.jobsId = jobsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

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

    @Override
    public int compareTo(JobItem o) {
        return( o.bonus -  this.getBonus());
    }
}