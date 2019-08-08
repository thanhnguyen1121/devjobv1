package com.thanhnguyen.devjob.View.FragmentView.FragmentEvent;

import com.thanhnguyen.devjob.Model.ModelEvent.EventItem;

import java.util.List;

public interface FragmentEventViewImp {
    void getData(List<EventItem> eventItemList);
    void getError(String mes);
}
