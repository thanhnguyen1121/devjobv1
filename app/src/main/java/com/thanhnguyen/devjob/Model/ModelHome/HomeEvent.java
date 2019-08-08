package com.thanhnguyen.devjob.Model.ModelHome;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeEvent {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("contentShortCut")
    @Expose
    private String contentShortCut;
    @SerializedName("avatar_event")
    @Expose
    private String avatarEvent;
    @SerializedName("speakers")
    @Expose
    private String speakers;
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

    public String getAvatarEvent() {
        return avatarEvent;
    }

    public void setAvatarEvent(String avatarEvent) {
        this.avatarEvent = avatarEvent;
    }

    public String getSpeakers() {
        return speakers;
    }

    public void setSpeakers(String speakers) {
        this.speakers = speakers;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}