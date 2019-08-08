package com.thanhnguyen.devjob.View.FragmentView.FragmentTopCompany;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thanhnguyen.devjob.Adapter.AdapterMainRcvCompany;
import com.thanhnguyen.devjob.Model.ModelCompany.CompanyItem;
import com.thanhnguyen.devjob.Model.ModelHome.TopCompany;
import com.thanhnguyen.devjob.Presenter.FragmentTopCompanyPresenter.FragmentTopCompanyPresenterImp;
import com.thanhnguyen.devjob.Presenter.FragmentTopCompanyPresenter.FragmentTopCompanyPresenterLogic;
import com.thanhnguyen.devjob.Presenter.Interface.ItemRcvClickListener;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.ActivityView.CompanyDetailActivity.CompanyActivityDetail;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentTopCompany extends Fragment implements ItemRcvClickListener, FragmentTopCompanyViewImp {
    @BindView(R.id.fragment_top_company_rcv_list)
    RecyclerView fragmentTopCompanyRcvList;
    private AdapterMainRcvCompany adapterMainRcvCompany;
    private List<CompanyItem> companyItems;
    private FragmentTopCompanyPresenterImp presenterImp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_company, container, false);
        ButterKnife.bind(this, view);
        companyItems = new ArrayList<>();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenterImp = new FragmentTopCompanyPresenterLogic(this);
        presenterImp.getData(Constant.token);

    }



    @Override
    public void clickedItem(int position) {
        Intent intent = new Intent(getActivity(), CompanyActivityDetail.class);
        intent.putExtra("company",companyItems.get(position));
        startActivity(intent);
    }

    @Override
    public void getData(List<TopCompany> topCompanies) {
        for (TopCompany item  : topCompanies) {
            this.companyItems.add(new CompanyItem(item.getName(),item.getAddress(),item.getId(),
                    item.getLogo(),item.getCount()));
        }
        createRcvListDs(this.companyItems);
    }

    @Override
    public void getError(String mes) {
        Log.d("aaa", "getError:  "+mes);
    }
    private void createRcvListDs(List<CompanyItem> companyItems) {
        adapterMainRcvCompany = new AdapterMainRcvCompany(companyItems, this);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        fragmentTopCompanyRcvList.setLayoutManager(manager);
        fragmentTopCompanyRcvList.setAdapter(adapterMainRcvCompany);
        fragmentTopCompanyRcvList.hasFixedSize();
    }
}
