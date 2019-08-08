package com.thanhnguyen.devjob.View.FragmentView.FragmentCourse;

import com.thanhnguyen.devjob.Model.ModelCourse.CourseItem;

import java.util.List;

public interface FragmentCourseViewImp {
    void getListCourse(List<CourseItem> courseItemList);
    void getError(String error);
}
