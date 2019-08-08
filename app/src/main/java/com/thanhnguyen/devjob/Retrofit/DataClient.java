package com.thanhnguyen.devjob.Retrofit;

import androidx.annotation.FractionRes;

import com.google.gson.annotations.Expose;
import com.thanhnguyen.devjob.Model.ModelBlog.BlogInfo;
import com.thanhnguyen.devjob.Model.ModelCompany.CompanyModel;
import com.thanhnguyen.devjob.Model.ModelCompanyDetail.ModelCompanyDetail;
import com.thanhnguyen.devjob.Model.ModelCourse.CourseInfo;
import com.thanhnguyen.devjob.Model.ModelEvent.EventInfo;
import com.thanhnguyen.devjob.Model.ModelEventDetail.ModeEventDetailInfo;
import com.thanhnguyen.devjob.Model.ModelHome.HomeInfo;
import com.thanhnguyen.devjob.Model.ModelJob.JobInfo;
import com.thanhnguyen.devjob.Model.ModelJobDetail.ModelJobDetailJobDetail;
import com.thanhnguyen.devjob.Model.UserModel.RegisterStatus;
import com.thanhnguyen.devjob.Model.UserModel.UserInfo;
import com.thanhnguyen.devjob.Model.UserModel.UserStatus;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface DataClient {


//
//    @GET("api/job/job-listings")
//    Call<JSONObject> getUserx(@Query("token") String token,
//                              @Query("bonus") int sl,
//                              @Query("totalPage") int total);


    @GET("api/job/job-listings")
    Call<JobInfo> getAllJobInfo(@Query("token") String token,
                                @Query("search") String search,
                                @Query("bonus") int bonus,
                                @Query("totalPage") int totalPage);

    @GET("api/list-companies")
    Call<CompanyModel> getAllCompanyModelInfo(@Query("token") String token,
                                              @Query("location") String location,
                                              @Query("totalPage") int totalPage,
                                              @Query("nameCompany") String nameCompany);

    @GET("api/index/company-landing")
    Call<ModelCompanyDetail> getModelCompanyDetail(@Query("token") String token,
                                                   @Query("id") int id,
                                                   @Query("paginate") int paginate);

    @GET("api/job/detail")
    Call<ModelJobDetailJobDetail> getJobDetail(@Query("slug") String slug,
                                               @Query("token") String token);

    //lấy dữ liệu từ event.

    @GET("api/event")
    Call<EventInfo> getAllEventInfo(@Query("token") String token);

    @GET("api/event/event-detail")
    Call<ModeEventDetailInfo> getEventPostDetail(@Query("token") String token,
                                                 @Query("slug") String slug);

    //Lấy dữ liệu từ blog;
    @GET("api/blog")
    Call<BlogInfo> getAllPostBlogInfo(@Query("token") String token);

    //Lấy dữ liệu từ Course;
    @GET("api/courses")
    Call<CourseInfo> getAllPostCourseInfo(@Query("token") String token);

    //get top company
    @GET("api/home")
    Call<HomeInfo> getAllTopCompany(@Query("token") String token);

    //login
    @FormUrlEncoded
    @POST("api/login")
    Call<UserStatus> getLoginStatus(@Field("token") String token,
                                    @Field("email") String email,
                                    @Field("password") String password);

    //register
    @FormUrlEncoded
    @POST("api/signup")
    Call<RegisterStatus> getRegisterStatus(@Field("companyName") String companyName,
                                           @Field("email") String email,
                                           @Field("password") String password,
                                           @Field("phone") String phone,
                                           @Field("repassword") String repassword,
                                           @Field("role") int role,
                                           @Field("token") String token,
                                           @Field("username") String username);


    //test get data from job filter
    @GET
    Call<JobInfo> getJobFilter(@Url String url);

}
