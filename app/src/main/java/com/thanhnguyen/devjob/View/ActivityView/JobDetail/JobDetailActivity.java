package com.thanhnguyen.devjob.View.ActivityView.JobDetail;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.text.Html;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thanhnguyen.devjob.Adapter.AdapterJobRelate;
import com.thanhnguyen.devjob.Model.ModelJobDetail.ModeJobDetailCompany;
import com.thanhnguyen.devjob.Model.ModelJobDetail.ModelJobDetailDetail;
import com.thanhnguyen.devjob.Model.ModelJobDetail.ModelJobDetailJobRelate;
import com.thanhnguyen.devjob.Presenter.Interface.ItemRcvClickListener;
import com.thanhnguyen.devjob.Presenter.JobDetailPresenter.JobDetailPresenterImp;
import com.thanhnguyen.devjob.Presenter.JobDetailPresenter.JobDetailPresenterLogic;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.Utils.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JobDetailActivity extends AppCompatActivity implements JobDetailViewImp,
        ItemRcvClickListener, GestureDetector.OnGestureListener {

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
    @BindView(R.id.jobs_detail_imgback)
    ImageView jobsDetailImgback;
    @BindView(R.id.ln_jobs_detail_address)
    LinearLayout lnJobsDetailAddress;
    @BindView(R.id.rl_job_detail_header)
    RelativeLayout rlJobDetailHeader;
    @BindView(R.id.job_detail_rcv_job_relate)
    RecyclerView jobDetailRcvJobRelate;
    @BindView(R.id.jobs_detail_scollview)
    NestedScrollView scrollView;
    @BindView(R.id.ln_controll_button)
    LinearLayout lnControll;

    private JobDetailPresenterImp jobDetailPresenterImp;
    private List<ModelJobDetailJobRelate> relateList;
    private int Ymin = 100, speed = 400;
    private int heightHeader;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String slug = intent.getStringExtra("slug");
        jobDetailPresenterImp = new JobDetailPresenterLogic(this);
        jobDetailPresenterImp.getJobDetailInfor(slug, Constant.token);

        gestureDetector = new GestureDetector(this, this);

        scrollView.setOnTouchListener((v, event) -> gestureDetector.onTouchEvent(event));
        rlJobDetailHeader.post(new Runnable() {
            @Override
            public void run() {
                heightHeader = rlJobDetailHeader.getMeasuredHeight();
            }
        });

        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (scrollView != null) {
                    if (scrollView.getScrollY()==0) {
                        jobsDetailTxtName.setVisibility(View.VISIBLE);
                        lnJobsDetailAddress.setVisibility(View.VISIBLE);
                        rlJobDetailHeader.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, heightHeader));
                    }
                }
            }
        });
    }


    @Override
    public void getData(ModelJobDetailDetail detail, ModeJobDetailCompany company,
                        List<ModelJobDetailJobRelate> relateList) {
        jobsDetailTxtName.setText(company.getName());
        jobsDetailTxtTitle.setText(detail.getTitle());
        jobsDetailTxtTag1.setText(detail.getName());
        jobsDetailTxtLocation.setText(detail.getAddress());
        jobsDetailTxtBonus.setText(detail.getBonus() + "$");
        if (detail.getSalaryMin() != 0 && detail.getSalaryMax() != 0) {
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

        createRcvRelateJob(relateList);
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

    private void createRcvRelateJob(List<ModelJobDetailJobRelate> raRelateList) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.HORIZONTAL);
        jobDetailRcvJobRelate.setLayoutManager(manager);
        jobDetailRcvJobRelate.setAdapter(new AdapterJobRelate(raRelateList, this));
    }


    @Override
    public void clickedItem(int position) {

    }


    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //up

        if (e1.getY() - e2.getY() > Ymin) {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int) RelativeLayout.LayoutParams.WRAP_CONTENT,
                    (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.leftMargin = 20;
            params.topMargin = 20;
            params.bottomMargin = 20;
            params.rightMargin = 20;
            params.addRule(RelativeLayout.CENTER_VERTICAL);
            jobsDetailImgback.setLayoutParams(params);
            jobsDetailTxtName.setVisibility(View.GONE);
            lnJobsDetailAddress.setVisibility(View.GONE);
            jobsDetailTxtTitle.setTypeface(null, Typeface.BOLD);
            rlJobDetailHeader.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));


        }
        //down
        if (e2.getY() - e1.getY() > Ymin ) {

        }
        if(lnJobsDetailAddress.getVisibility() == View.GONE){
            lnControll.setVisibility(View.VISIBLE);
        }else{
            lnControll.setVisibility(View.GONE);
        }
        return true;
    }

}
