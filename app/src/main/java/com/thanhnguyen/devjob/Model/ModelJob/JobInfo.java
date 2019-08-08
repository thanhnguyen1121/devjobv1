package com.thanhnguyen.devjob.Model.ModelJob;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobInfo {

    @SerializedName("filter")
    @Expose
    private Object filter;
    @SerializedName("search")
    @Expose
    private Object search;
    @SerializedName("location")
    @Expose
    private Object location;
    @SerializedName("filterLevel")
    @Expose
    private Object filterLevel;
    @SerializedName("countSkill")
    @Expose
    private List<CountSkill> countSkill = null;
    @SerializedName("countLevel")
    @Expose
    private List<CountLevel> countLevel = null;
    @SerializedName("countTypeOfWork")
    @Expose
    private List<CountTypeOfWork> countTypeOfWork = null;
    @SerializedName("countSalary1")
    @Expose
    private CountSalary1 countSalary1;
    @SerializedName("countSalary2")
    @Expose
    private CountSalary2 countSalary2;
    @SerializedName("countSalary3")
    @Expose
    private CountSalary3 countSalary3;
    @SerializedName("countSalary4")
    @Expose
    private CountSalary4 countSalary4;
    @SerializedName("countSalary5")
    @Expose
    private CountSalary5 countSalary5;
    @SerializedName("totalJob")
    @Expose
    private Integer totalJob;
    @SerializedName("jobs")
    @Expose
    private Jobs jobs;
    @SerializedName("companies")
    @Expose
    private List<Company> companies = null;
    @SerializedName("cates")
    @Expose
    private List<Cate> cates = null;

    public Object getFilter() {
        return filter;
    }

    public void setFilter(Object filter) {
        this.filter = filter;
    }

    public Object getSearch() {
        return search;
    }

    public void setSearch(Object search) {
        this.search = search;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public Object getFilterLevel() {
        return filterLevel;
    }

    public void setFilterLevel(Object filterLevel) {
        this.filterLevel = filterLevel;
    }

    public List<CountSkill> getCountSkill() {
        return countSkill;
    }

    public void setCountSkill(List<CountSkill> countSkill) {
        this.countSkill = countSkill;
    }

    public List<CountLevel> getCountLevel() {
        return countLevel;
    }

    public void setCountLevel(List<CountLevel> countLevel) {
        this.countLevel = countLevel;
    }

    public List<CountTypeOfWork> getCountTypeOfWork() {
        return countTypeOfWork;
    }

    public void setCountTypeOfWork(List<CountTypeOfWork> countTypeOfWork) {
        this.countTypeOfWork = countTypeOfWork;
    }

    public CountSalary1 getCountSalary1() {
        return countSalary1;
    }

    public void setCountSalary1(CountSalary1 countSalary1) {
        this.countSalary1 = countSalary1;
    }

    public CountSalary2 getCountSalary2() {
        return countSalary2;
    }

    public void setCountSalary2(CountSalary2 countSalary2) {
        this.countSalary2 = countSalary2;
    }

    public CountSalary3 getCountSalary3() {
        return countSalary3;
    }

    public void setCountSalary3(CountSalary3 countSalary3) {
        this.countSalary3 = countSalary3;
    }

    public CountSalary4 getCountSalary4() {
        return countSalary4;
    }

    public void setCountSalary4(CountSalary4 countSalary4) {
        this.countSalary4 = countSalary4;
    }

    public CountSalary5 getCountSalary5() {
        return countSalary5;
    }

    public void setCountSalary5(CountSalary5 countSalary5) {
        this.countSalary5 = countSalary5;
    }

    public Integer getTotalJob() {
        return totalJob;
    }

    public void setTotalJob(Integer totalJob) {
        this.totalJob = totalJob;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<Cate> getCates() {
        return cates;
    }

    public void setCates(List<Cate> cates) {
        this.cates = cates;
    }

}