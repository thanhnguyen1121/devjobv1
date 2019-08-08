package com.thanhnguyen.devjob.Retrofit;

import retrofit2.Retrofit;

public class ApiUtil {
    public final static String BaseUrl = "https://devjob.co/";
    private final static String BaseUrl1 = "http://www.mocky.io/";
    public static DataClient getData(){
        return RetrofitAPI.getRetrofit(BaseUrl).create(DataClient.class);
    }
}
