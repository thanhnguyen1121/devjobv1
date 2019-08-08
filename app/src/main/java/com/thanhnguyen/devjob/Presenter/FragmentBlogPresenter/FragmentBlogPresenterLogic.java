package com.thanhnguyen.devjob.Presenter.FragmentBlogPresenter;

import com.thanhnguyen.devjob.Model.ModelBlog.BlogInfo;
import com.thanhnguyen.devjob.Presenter.FragmentEventDetailPresenter.FragmentEventDetailImp;
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.View.FragmentView.FragmentBlog.FragmentBlogViewImp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentBlogPresenterLogic implements FragmentBlogPresenterImp {
    private FragmentBlogViewImp fragmentBlogViewImp;

    public FragmentBlogPresenterLogic(FragmentBlogViewImp fragmentBlogViewImp) {
        this.fragmentBlogViewImp = fragmentBlogViewImp;
    }

    @Override
    public void getData(String token) {
        ApiUtil.getData().getAllPostBlogInfo(token).enqueue(new Callback<BlogInfo>() {
            @Override
            public void onResponse(Call<BlogInfo> call, Response<BlogInfo> response) {
                if(response.isSuccessful()){
                    fragmentBlogViewImp.getListBlog(response.body().getBlogs().getData());
                }
            }

            @Override
            public void onFailure(Call<BlogInfo> call, Throwable t) {
                    fragmentBlogViewImp.getError(t.getMessage());
            }
        });
    }
}
