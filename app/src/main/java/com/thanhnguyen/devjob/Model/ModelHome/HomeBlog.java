package com.thanhnguyen.devjob.Model.ModelHome;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeBlog {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("contentShortCut")
    @Expose
    private String contentShortCut;
    @SerializedName("viewCount")
    @Expose
    private Integer viewCount;
    @SerializedName("avatar_blog")
    @Expose
    private String avatarBlog;
    @SerializedName("created_at")
    @Expose
    private String createdAt;

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

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getAvatarBlog() {
        return avatarBlog;
    }

    public void setAvatarBlog(String avatarBlog) {
        this.avatarBlog = avatarBlog;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}