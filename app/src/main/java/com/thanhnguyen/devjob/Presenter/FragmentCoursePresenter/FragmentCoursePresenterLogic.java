package com.thanhnguyen.devjob.Presenter.FragmentCoursePresenter;

import android.util.Log;

import com.thanhnguyen.devjob.Model.ModelCourse.CourseInfo;
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.FragmentView.FragmentCourse.FragmentCourse;
import com.thanhnguyen.devjob.View.FragmentView.FragmentCourse.FragmentCourseViewImp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentCoursePresenterLogic implements FragmentCoursePresenterImp{
    private FragmentCourseViewImp fragmentCourseViewImp;

    public FragmentCoursePresenterLogic(FragmentCourseViewImp fragmentCourseViewImp) {
        this.fragmentCourseViewImp = fragmentCourseViewImp;
    }

    @Override
    public void getData(String token) {
        ApiUtil.getData().getAllPostCourseInfo(token).enqueue(new Callback<CourseInfo>() {
            @Override
            public void onResponse(Call<CourseInfo> call, Response<CourseInfo> response) {
                if(response.isSuccessful()){
                    fragmentCourseViewImp.getListCourse(response.body().getCourses().getData());
                }
            }

            @Override
            public void onFailure(Call<CourseInfo> call, Throwable t) {
                fragmentCourseViewImp.getError(t.getMessage());
            }
        });

    }
}
