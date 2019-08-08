package com.thanhnguyen.devjob.View.ActivityView.JobDetail;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.thanhnguyen.devjob.Model.ModelJobDetail.ModeJobDetailCompany;
import com.thanhnguyen.devjob.Model.ModelJobDetail.ModelJobDetailDetail;
import com.thanhnguyen.devjob.Presenter.JobDetailPresenter.JobDetailPresenterImp;
import com.thanhnguyen.devjob.Presenter.JobDetailPresenter.JobDetailPresenterLogic;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.Utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JobDetailActivity extends AppCompatActivity implements JobDetailViewImp {

    @BindView(R.id.jobs_detail_txtName)
    TextView jobsDetailTxtName;
    @BindView(R.id.jobs_detail_txtTitle)
    TextView jobsDetailTxtTitle;
    @BindView(R.id.jobs_detail_txtTag1)
    TextView jobsDetailTxtTag1;
    @BindView(R.id.jobs_detail_txtLocation)
    TextView jobsDetailTxtLocation;
    @BindView(R.id.jobs_detail_txtBonus)
    TextView jobsDetailTxtBonus;
    @BindView(R.id.jobs_detail_txtSalary)
    TextView jobsDetailTxtSalary;
    @BindView(R.id.jobs_detail_txtJobType)
    TextView jobsDetailTxtJobType;
    @BindView(R.id.jobs_detail_txtDeadline)
    TextView jobsDetailTxtDeadline;
    @BindView(R.id.jobs_detail_txtDescription)
    TextView jobsDetailTxtDescription;
    @BindView(R.id.jobs_detail_txtBenefit)
    TextView jobsDetailTxtBenefit;
    @BindView(R.id.jobs_detail_txtRequirement)
    TextView jobsDetailTxtRequirement;

    private JobDetailPresenterImp jobDetailPresenterImp;
    private float x1,x2;
    static final int MIN_DISTANCE = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String slug = intent.getStringExtra("slug");
        jobDetailPresenterImp = new JobDetailPresenterLogic(this);
        jobDetailPresenterImp.getJobDetailInfor(slug, Constant.token);


    }


    @Override
    public void getData(ModelJobDetailDetail detail, ModeJobDetailCompany company) {
        jobsDetailTxtName.setText(company.getName());
        jobsDetailTxtTitle.setText(detail.getTitle());
        jobsDetailTxtTag1.setText(detail.getName());
        jobsDetailTxtLocation.setText(detail.getAddress());
        jobsDetailTxtBonus.setText(detail.getBonus() + "$");
        if (detail.getSalaryMin() != null && detail.getSalaryMax() != null) {
            jobsDetailTxtSalary.setText(detail.getSalaryMin() + "~" + detail.getSalaryMax() + "$");
        } else {
            jobsDetailTxtSalary.setText("None");
        }

        if (detail.getType() == 1) {
            jobsDetailTxtJobType.setText("FullTime");
        } else {
            jobsDetailTxtJobType.setText("PartTime");
        }

        jobsDetailTxtDeadline.setText(Constant.xuLyThoiGian(detail.getStartTime()));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            jobsDetailTxtDescription.setText(Html.fromHtml(detail.getDescription(), Html.FROM_HTML_MODE_COMPACT));
            jobsDetailTxtBenefit.setText(Html.fromHtml(detail.getBenefit(), Html.FROM_HTML_MODE_COMPACT));
            jobsDetailTxtRequirement.setText(Html.fromHtml(detail.getRequirement(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            jobsDetailTxtDescription.setText(Html.fromHtml(detail.getDescription()));
            jobsDetailTxtBenefit.setText(Html.fromHtml(detail.getBenefit()));
            jobsDetailTxtRequirement.setText(Html.fromHtml(detail.getRequirement()));

        }

    }

    @Override
    public void getError(String mes) {

    }

    @OnClick({R.id.jobs_detail_imgback, R.id.job_detail_apply, R.id.job_detail_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.jobs_detail_imgback:
                this.finish();
                break;
            case R.id.job_detail_apply:
                Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.job_detail_save:
                Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
