package com.thanhnguyen.devjob.Model.ModelCourse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CourseInfo {

    @SerializedName("courses")
    @Expose
    private Courses courses;

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

}