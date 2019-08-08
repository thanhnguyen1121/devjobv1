package com.thanhnguyen.devjob.View.FragmentView.FragmentCompany;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thanhnguyen.devjob.Adapter.AdapterMainRcvCompany;
import com.thanhnguyen.devjob.Model.ModelCompany.CompanyItem;
import com.thanhnguyen.devjob.Model.ModelCompany.CompanyModel;
import com.thanhnguyen.devjob.Model.ModelJob.Company;
import com.thanhnguyen.devjob.Presenter.FragmentCompanyPresenter.FragementCompayLogic;
import com.thanhnguyen.devjob.Presenter.FragmentCompanyPresenter.FragmentCompanyImp;
import com.thanhnguyen.devjob.Presenter.Interface.ItemRcvClickListener;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.ActivityView.CompanyDetailActivity.CompanyActivityDetail;
import com.thanhnguyen.devjob.View.ActivityView.CompanyViewSearchMore.CompanySearchMoreActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentCompany extends Fragment implements FragmentCompanyViewImp, ItemRcvClickListener {
    CircleImageView mainCompaniesImgUserAvatar;
    @BindView(R.id.main_companies_key_words)
    EditText mainCompaniesKeyWords;
    @BindView(R.id.main_companies_rcv)
    RecyclerView mainCompaniesRcv;

    private AdapterMainRcvCompany adapterMainRcvCompany;
    private FragmentCompanyImp fragmentCompanyImp;
    List<CompanyItem> companyItemList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_company, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentCompanyImp = new FragementCompayLogic(this);
        fragmentCompanyImp.getListCompany(Constant.token, "", 50, "");
        companyItemList = new ArrayList<>();
    }

    @OnClick({R.id.main_companies_img_view_search, R.id.main_company_img_view_search_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.main_companies_img_view_search:
                fragmentCompanyImp.getListCompany(Constant.token, "",
                        10, mainCompaniesKeyWords.getText().toString().trim());
                break;
            case R.id.main_company_img_view_search_more:
                Intent intent = new Intent(getActivity(), CompanySearchMoreActivity.class);
                startActivityForResult(intent, Constant.REQUEST_CODE_SEARCH_MORE_COMPANY);
                break;
        }
    }

    @Override
    public void getListCompany(List<CompanyItem> companyItemList) {
        this.companyItemList = companyItemList;
        createMainCompanyRcv(companyItemList);
    }

    @Override
    public void getErrorWhenGetData(String mes) {
        Log.e("eee", "getErrorWhenGetData: " + mes);
    }

    private void createMainCompanyRcv(List<CompanyItem> companyItemList) {

        adapterMainRcvCompany = new AdapterMainRcvCompany(companyItemList, this);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        mainCompaniesRcv.setLayoutManager(manager);
        mainCompaniesRcv.setAdapter(adapterMainRcvCompany);
    }

    @Override
    public void clickedItem(int position) {
        Intent intent = new Intent(getActivity(), CompanyActivityDetail.class);
        intent.putExtra("company", companyItemList.get(position));
        startActivity(intent);
    }
}
