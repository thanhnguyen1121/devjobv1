package com.thanhnguyen.devjob.Model.ModelBlog;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BlogItem implements Serializable {

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
    @SerializedName("viewCount")
    @Expose
    private Integer viewCount;
    @SerializedName("avatar_blog")
    @Expose
    private String avatarBlog;
    @SerializedName("tag_blog")
    @Expose
    private String tagBlog;
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

    public String getTagBlog() {
        return tagBlog;
    }

    public void setTagBlog(String tagBlog) {
        this.tagBlog = tagBlog;
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
