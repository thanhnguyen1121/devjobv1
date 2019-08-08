package com.thanhnguyen.devjob.View.FragmentView.FragmentBlog;

import com.thanhnguyen.devjob.Model.ModelBlog.BlogItem;

import java.util.List;

public interface FragmentBlogViewImp {
    void getListBlog(List<BlogItem> blogItemList);
    void getError(String mes);
}
