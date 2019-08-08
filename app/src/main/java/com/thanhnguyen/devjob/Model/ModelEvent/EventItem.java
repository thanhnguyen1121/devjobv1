package com.thanhnguyen.devjob.Model.ModelEvent;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EventItem implements Serializable {

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
    @SerializedName("avatar_event")
    @Expose
    private String avatarEvent;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("speakers")
    @Expose
    private String speakers;
    @SerializedName("tag_event")
    @Expose
    private String tagEvent;
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

    public String getAvatarEvent() {
        return avatarEvent;
    }

    public void setAvatarEvent(String avatarEvent) {
        this.avatarEvent = avatarEvent;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpeakers() {
        return speakers;
    }

    public void setSpeakers(String speakers) {
        this.speakers = speakers;
    }

    public String getTagEvent() {
        return tagEvent;
    }

    public void setTagEvent(String tagEvent) {
        this.tagEvent = tagEvent;
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
