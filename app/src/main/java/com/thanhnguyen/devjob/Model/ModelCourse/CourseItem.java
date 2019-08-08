package com.thanhnguyen.devjob.Model.ModelCourse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CourseItem implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("contentShortCut")
    @Expose
    private String contentShortCut;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("teacher")
    @Expose
    private String teacher;
    @SerializedName("timeST")
    @Expose
    private String timeST;
    @SerializedName("timeFN")
    @Expose
    private String timeFN;
    @SerializedName("avatarC")
    @Expose
    private String avatarC;
    @SerializedName("tag_course")
    @Expose
    private String tagCourse;
    @SerializedName("admin_id")
    @Expose
    private Integer adminId;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getContentShortCut() {
        return contentShortCut;
    }

    public void setContentShortCut(String contentShortCut) {
        this.contentShortCut = contentShortCut;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTimeST() {
        return timeST;
    }

    public void setTimeST(String timeST) {
        this.timeST = timeST;
    }

    public String getTimeFN() {
        return timeFN;
    }

    public void setTimeFN(String timeFN) {
        this.timeFN = timeFN;
    }

    public String getAvatarC() {
        return avatarC;
    }

    public void setAvatarC(String avatarC) {
        this.avatarC = avatarC;
    }

    public String getTagCourse() {
        return tagCourse;
    }

    public void setTagCourse(String tagCourse) {
        this.tagCourse = tagCourse;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
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

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

}