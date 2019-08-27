package com.thanhnguyen.devjob.View.ActivityView.MainActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bigscreen.iconictabbar.view.IconicTab;
import com.bigscreen.iconictabbar.view.IconicTabBar;
import com.thanhnguyen.devjob.Model.ModelHome.HomeInfo;
import com.thanhnguyen.devjob.Model.test;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.ActivityView.LoginActivity.LoginActivity;
import com.thanhnguyen.devjob.View.ActivityView.UserActivity.Candidate.CadidateActivity;
import com.thanhnguyen.devjob.View.FragmentView.FragmentBlog.FragmentBlog;
import com.thanhnguyen.devjob.View.FragmentView.FragmentCompany.FragmentCompany;
import com.thanhnguyen.devjob.View.FragmentView.FragmentEvent.FragmentEvent;
import com.thanhnguyen.devjob.View.FragmentView.FragmentHome.FragmentHome;
import com.thanhnguyen.devjob.View.FragmentView.FragmentJob.FragmentJob;
import com.thanhnguyen.devjob.View.FragmentView.FragmentMore.FragmentMore;

import org.json.JSONObject;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashSet;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_img_user_avatar)
    CircleImageView mainImgUserAvatar;
    private IconicTabBar iconicTabBar;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, new FragmentHome());
        fragmentTransaction.commit();
        initBottomNavigation();


    }


    private void initBottomNavigation() {
        iconicTabBar = findViewById(R.id.tab_bar);
        iconicTabBar.setSelectedTab(2);
        iconicTabBar.setOnTabSelectedListener(new IconicTabBar.OnTabSelectedListener() {
            @Override
            public void onSelected(IconicTab tab, int position) {
                initFragment(position);
            }

            @Override
            public void onUnselected(IconicTab tab, int position) {

            }
        });

    }

    private void initFragment(int position) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FragmentJob();
                break;
            case 1:

                fragment = new FragmentCompany();
                break;
            case 2:

                fragment = new FragmentHome();
                break;
            case 3:
                fragment = new FragmentMore();
                break;
            case 4:
                fragment = new FragmentBlog();
                break;
        }
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }

    @OnClick(R.id.main_img_user_avatar)
    public void onViewClicked() {

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);

    }

}
