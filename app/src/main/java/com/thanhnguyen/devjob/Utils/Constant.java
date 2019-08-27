package com.thanhnguyen.devjob.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.thanhnguyen.devjob.Model.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;

public class Constant {
    public static String token = "0F405C9DD1DE1021140B07B8CE534693";
    public static SharedPreferences sharedPreferences;
    public static int REQUEST_CODE_REGISTER = 1;
    public static int RESULT_CODE_REGISTER = 2;
    public static int REQUEST_CODE_SEARCH_MORE = 3;
    public static int RESULT_CODE_SEARCH_MORE = 4;
    public static int RESULT_CODE_SEARCH_MORE_COMPANY = 5;
    public static int REQUEST_CODE_SEARCH_MORE_COMPANY = 6;



    public static String xuLyThoiGian(String startTime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            long d2 = formater.parse(startTime).getTime();
            long timeNow = Calendar.getInstance().getTimeInMillis();

            return (Math.abs((timeNow - d2) / (1000 * 60 * 60 * 24)) + 1) + " days ago";
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }
    
}
