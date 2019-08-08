package com.thanhnguyen.devjob.View.ActivityView.EventPostDetailActivity;

import com.thanhnguyen.devjob.Model.ModelEvent.EventItem;

public interface EventPostDetailViewImp {
    void getData(EventItem eventItem);
    void getError(String error);
}
