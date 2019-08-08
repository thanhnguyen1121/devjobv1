package com.thanhnguyen.devjob.Model.ModelBlog;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BlogInfo {

    @SerializedName("blogs")
    @Expose
    private Blogs blogs;

    public Blogs getBlogs() {
        return blogs;
    }

    public void setBlogs(Blogs blogs) {
        this.blogs = blogs;
    }

}