package com.thanhnguyen.devjob.Model.ModelEvent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventInfo {

    @SerializedName("events")
    @Expose
    private Events events;

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

}