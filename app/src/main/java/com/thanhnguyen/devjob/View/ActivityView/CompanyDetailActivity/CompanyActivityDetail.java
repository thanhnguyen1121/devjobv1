package com.thanhnguyen.devjob.View.ActivityView.CompanyDetailActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.thanhnguyen.devjob.Adapter.AdapterCompanyModelDetail;
import com.thanhnguyen.devjob.Adapter.SamplePagerAdapter;
import com.thanhnguyen.devjob.Model.ModelCompany.CompanyItem;
import com.thanhnguyen.devjob.Model.ModelCompanyDetail.CompanyDetailJobItem;
import com.thanhnguyen.devjob.Model.ModelCompanyDetail.Detail;
import com.thanhnguyen.devjob.Model.ModelCompanyDetail.Thumbnail;
import com.thanhnguyen.devjob.Presenter.CompanyDetailPresenter.CompanyDetaiILogic;
import com.thanhnguyen.devjob.Presenter.CompanyDetailPresenter.CompanyDetailImp;
import com.thanhnguyen.devjob.Presenter.Interface.ItemRcvClickListener;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.ActivityView.JobDetail.JobDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import me.relex.circleindicator.CircleIndicator;

public class CompanyActivityDetail extends AppCompatActivity implements CompanyDetailViewImp, ItemRcvClickListener {

    @BindView(R.id.company_detail_txtname)
    TextView companyDetailTxtname;
    @BindView(R.id.company_detail_txtlocation)
    TextView companyDetailTxtlocation;
    @BindView(R.id.company_detail_txtteamSize)
    TextView companyDetailTxtteamSize;
    @BindView(R.id.company_detail_txtflower)
    TextView companyDetailTxtflower;
    @BindView(R.id.company_detail_txtCategroly)
    TextView companyDetailTxtCategroly;
    @BindView(R.id.company_detail_txtPostJobs)
    TextView companyDetailTxtPostJobs;
    @BindView(R.id.company_detail_txtAllViews)
    TextView companyDetailTxtAllViews;
    @BindView(R.id.company_detail_txtAbout)
    TextView companyDetailTxtAbout;
    @BindView(R.id.company_detail_rcv)
    RecyclerView companyDetailRcv;
    @BindView(R.id.company_detail_deImgLogo)
    CircleImageView imgLogo;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.indicator)
    CircleIndicator indicator;
    @BindView(R.id.img_empty)
    ImageView imgEmpty;

    private CompanyItem companyItem;
    private CompanyDetailImp companyDetailImp;
    private AdapterCompanyModelDetail adapterMainRcvJobs;
    private List<CompanyDetailJobItem> companyDetailJobItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        companyItem = (CompanyItem) intent.getSerializableExtra("company");
        companyDetailImp = new CompanyDetaiILogic(this);
        companyDetailImp.getData(Constant.token, companyItem.getId(), 5);
        companyDetailJobItems = new ArrayList<>();
        companyDetailTxtname.requestFocus();
        companyDetailTxtname.setFocusableInTouchMode(true);

    }


    @Override
    public void getData(Detail detail, List<Thumbnail> thumbnailList,
                        List<CompanyDetailJobItem> companyDetailJobItemList) {
        this.companyDetailJobItems = companyDetailJobItemList;
        companyDetailTxtname.setText(detail.getName());
        companyDetailTxtlocation.setText(detail.getAddress());
        companyDetailTxtteamSize.setText(detail.getHumanResource() != null ?
                detail.getHumanResource() + " people" : "0 people");
        Glide.with(this).load(detail.getLogo())
                .error(R.drawable.ic_user_border)
                .into(imgLogo);
        companyDetailTxtflower.setText(detail.getAmountApplies() + " followers");
        companyDetailTxtPostJobs.setText(detail.getAmountJob() + " jobs");
        companyDetailTxtAllViews.setText(detail.getSumViews() + " views");

        if(detail.getAbout() != null){
            companyDetailTxtAbout.setText(detail.getAbout());
        }else{
            companyDetailTxtAbout.setText("Empty");
        }


        if (!thumbnailList.isEmpty()) {
            viewPager.setVisibility(View.VISIBLE);
            indicator.setVisibility(View.VISIBLE);
            imgEmpty.setVisibility(View.GONE);
            SamplePagerAdapter samplePagerAdapter = new SamplePagerAdapter(thumbnailList);
            viewPager.setAdapter(samplePagerAdapter);
            indicator.setViewPager(viewPager);
        }else{
            imgEmpty.setVisibility(View.VISIBLE);
            indicator.setVisibility(View.GONE);
            viewPager.setVisibility(View.GONE);
            imgEmpty.setImageResource(R.drawable.ic_empty_file);
        }


        createRcvJob(companyDetailJobItemList, detail);
    }

    @Override
    public void getError(String ErrorMes) {

    }


    private void createRcvJob(List<CompanyDetailJobItem> companyDetailJobItemList, Detail detail) {
        adapterMainRcvJobs = new AdapterCompanyModelDetail(companyDetailJobItemList, detail, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        companyDetailRcv.setLayoutManager(manager);
        companyDetailRcv.setAdapter(adapterMainRcvJobs);

    }


    @Override
    public void clickedItem(int position) {
        Intent intent = new Intent(CompanyActivityDetail.this, JobDetailActivity.class);
        intent.putExtra("slug", companyDetailJobItems.get(position).getSlug());
        startActivity(intent);
    }

    @OnClick(R.id.company_detail_imgback)
    public void onViewClicked() {
        this.finish();
    }
}
