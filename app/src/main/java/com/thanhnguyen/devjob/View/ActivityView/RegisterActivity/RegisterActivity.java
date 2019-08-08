package com.thanhnguyen.devjob.View.ActivityView.RegisterActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.thanhnguyen.devjob.Model.UserModel.RegisterStatus;
import com.thanhnguyen.devjob.Model.UserModel.UserInfo;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.register_txtEmail)
    EditText registerTxtEmail;
    @BindView(R.id.register_txtPass)
    EditText registerTxtFirstPass;
    @BindView(R.id.register_txt_confirmpass)
    EditText registerTxtPrePass;
    @BindView(R.id.register_rd_cadidate)
    RadioButton registerRdCadidate;
    @BindView(R.id.register_rd_refer)
    RadioButton registerRdRefer;
    @BindView(R.id.register_rd_employee)
    RadioButton registerRdEmployee;
    @BindView(R.id.register_txtFullname)
    EditText registerTxtFullname;
    @BindView(R.id.register_txtSdt)
    EditText registerTxtSdt;
    @BindView(R.id.ln_company_name)
    LinearLayout lnCompanyName;
    @BindView(R.id.register_txtcompanyname)
    TextView registerTxtCompanyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        setViewCompany();
    }

    @OnClick({R.id.register_btnRegister, R.id.register_btnRegisterCancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_btnRegister:
                Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
                int role = -1;
                if(registerRdCadidate.isChecked()){
                    role = 0;
                }
                if(registerRdRefer.isChecked()){
                    role = 1;
                }
                if(registerRdEmployee.isChecked()){
                    role = 2;
                }

                String email = registerTxtEmail.getText().toString().trim();
                String pass = registerTxtFirstPass.getText().toString().trim();
                String repass = registerTxtPrePass.getText().toString().trim();
                String fullName = registerTxtFullname.getText().toString().trim();
                String sdt = registerTxtSdt.getText().toString().trim();
                String companyName = registerTxtCompanyName.getText().toString().trim();

                ApiUtil.getData().getRegisterStatus(companyName,email, pass, sdt, repass, role, Constant.token, fullName)
                        .enqueue(new Callback<RegisterStatus>() {
                            @Override
                            public void onResponse(Call<RegisterStatus> call, Response<RegisterStatus> response) {
                                if(response.isSuccessful()){
                                    Log.d("aaa", "onResponse: "  + response.body());
                                }else{
                                    Log.d("aaa", "onResponse: " + response.body());
                                }
                            }

                            @Override
                            public void onFailure(Call<RegisterStatus> call, Throwable t) {
                                Log.d("aaa", "onFailure: " + t.getMessage());
                            }
                        });


                break;
            case R.id.register_btnRegisterCancel:
                this.finish();
                break;
        }


    }

    private void setViewCompany(){
        registerRdCadidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnCompanyName.setVisibility(View.GONE);
            }
        });

        registerRdRefer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnCompanyName.setVisibility(View.GONE);
            }
        });

        registerRdEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnCompanyName.setVisibility(View.VISIBLE);
            }
        });
    }
}

