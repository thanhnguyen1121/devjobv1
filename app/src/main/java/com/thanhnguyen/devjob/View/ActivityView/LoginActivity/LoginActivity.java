package com.thanhnguyen.devjob.View.ActivityView.LoginActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.thanhnguyen.devjob.Model.LoginPresenter.LoginPresenterImp;
import com.thanhnguyen.devjob.Model.LoginPresenter.LoginPresenterLogic;
import com.thanhnguyen.devjob.Model.ModelEmployer.EmployeeDashbroadJobs;
import com.thanhnguyen.devjob.Model.StatusAfterLogin;
import com.thanhnguyen.devjob.Model.UserModel.UserLoginInfo;
import com.thanhnguyen.devjob.Model.UserModel.UserStatus;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.ActivityView.RegisterActivity.RegisterActivity;

import org.json.JSONObject;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements LoginActivityViewImp {

    @BindView(R.id.login_txtEmail)
    EditText loginTxtEmail;
    @BindView(R.id.login_txtpass)
    EditText loginTxtpass;
    @BindView(R.id.login_cb_remember)
    CheckBox loginCbRemember;

    private LoginPresenterImp loginPresenterImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Constant.sharedPreferences = getSharedPreferences("userInfor", MODE_PRIVATE);
        loginTxtpass.setText(Constant.sharedPreferences.getString("pass", ""));
        loginTxtEmail.setText(Constant.sharedPreferences.getString("email", ""));
        loginCbRemember.setChecked(Constant.sharedPreferences.getBoolean("isChecked", false));
        loginPresenterImp = new LoginPresenterLogic(this);
    }


    @OnClick({R.id.login_txtForgotPass, R.id.login_btnLogin, R.id.login_txtRegister})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.login_txtForgotPass:
                break;
            case R.id.login_btnLogin:

                loginPresenterImp.login(Constant.token, loginTxtEmail.getText().toString().trim(),
                        loginTxtpass.getText().toString().trim());
                break;
            case R.id.login_txtRegister:
                intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent, Constant.REQUEST_CODE_REGISTER);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == Constant.REQUEST_CODE_REGISTER && resultCode == Constant.RESULT_CODE_REGISTER && data != null) {

        }
    }

    private void saveUserEmaiAndPass(boolean isChecked) {

        SharedPreferences.Editor editor = Constant.sharedPreferences.edit();
        if (isChecked == true) {
            editor.putString("email", loginTxtEmail.getText().toString().trim());
            editor.putString("pass", loginTxtpass.getText().toString().trim());
            editor.putBoolean("isChecked", true);
            editor.commit();
        } else {
            editor.remove("email");
            editor.remove("pass");
            editor.remove("isChecked");
            editor.commit();
        }
    }

    @Override
    public void getUserStatus(UserStatus userStatus) {

        Log.d("aaa", "getUserStatus: " + userStatus.toString());
        if (userStatus.getId() == null) {
            Toast.makeText(this, "Sai tên tài khoản hoặc mật khẩu!", Toast.LENGTH_SHORT).show();
        } else {
            saveUserEmaiAndPass(loginCbRemember.isChecked());
            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

//            ApiUtil.getData().getEmployerDashBroadInfor(Constant.token, 10, "asc")
//                    .enqueue(new Callback<EmployeeDashbroadJobs>() {
//                @Override
//                public void onResponse(Call<EmployeeDashbroadJobs> call, Response<EmployeeDashbroadJobs> response) {
//                    if(response.isSuccessful()){
//                        Log.d("ddd", "onResponse: " + response.body());
//                    }else{
//                        Log.d("ddd", "onResponse: " + response.errorBody());
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<EmployeeDashbroadJobs> call, Throwable t) {
//                    Log.d("ddd", "onFailure: " + t.getMessage());
//                }
//            });

        }
    }

    @Override
    public void getError(String mes) {

    }


}
