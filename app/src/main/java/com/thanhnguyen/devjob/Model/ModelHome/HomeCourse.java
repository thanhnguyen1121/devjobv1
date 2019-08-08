package com.thanhnguyen.devjob.Model.ModelHome;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeCourse {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("contentShortCut")
    @Expose
    private String contentShortCut;
    @SerializedName("teacher")
    @Expose
    private String teacher;
    @SerializedName("avatarC")
    @Expose
    private String avatarC;

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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getContentShortCut() {
        return contentShortCut;
    }

    public void setContentShortCut(String contentShortCut) {
        this.contentShortCut = contentShortCut;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getAvatarC() {
        return avatarC;
    }

    public void setAvatarC(String avatarC) {
        this.avatarC = avatarC;
    }

}
