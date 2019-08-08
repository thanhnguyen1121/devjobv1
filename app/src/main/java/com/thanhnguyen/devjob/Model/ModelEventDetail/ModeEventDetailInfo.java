package com.thanhnguyen.devjob.Model.ModelEventDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.thanhnguyen.devjob.Model.ModelEvent.EventItem;
import com.thanhnguyen.devjob.Model.ModelEvent.Events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModeEventDetailInfo {

    @SerializedName("event")
    @Expose
    private EventItem event;

    public EventItem getEvent() {
        return event;
    }

    public void setEvent(EventItem event) {
        this.event = event;
    }

}