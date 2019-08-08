package com.thanhnguyen.devjob.View.ActivityView.CompanyViewSearchMore;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.thanhnguyen.devjob.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CompanySearchMoreActivity extends AppCompatActivity {

    @BindView(R.id.sp_company_fragment_search_location)
    MaterialSpinner spCompanyFragmentSearchLocation;
    @BindView(R.id.sp_company_fragment_type)
    MaterialSpinner spCompanyFragmentType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_searche_more);
        ButterKnife.bind(this);
        init();
    }

    @OnClick({R.id.img_company_search_option_back, R.id.btn_company_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_company_search_option_back:
                this.finish();
                break;
            case R.id.btn_company_search:
                Toast.makeText(this, "Chưa có api để xử lý!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void init(){
        spCompanyFragmentType.setItems("All", "Procude","OutSource");
    }
}
