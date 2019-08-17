package com.thanhnguyen.devjob.View.FragmentView.FragmentCandidateDashBoard.FragmentDashBoard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thanhnguyen.devjob.Adapter.AdapterDashboard;
import com.thanhnguyen.devjob.Model.ModelDashboard.Applies;
import com.thanhnguyen.devjob.Model.ModelDashboard.Datum;
import com.thanhnguyen.devjob.Model.ModelDashboard.LoginStatus;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentDashBoard extends Fragment {

    @BindView(R.id.rcv_item_db)
    RecyclerView rcv;
    @BindView(R.id.spinnerNumber)
    Spinner spinnerNumber;
    @BindView(R.id.spinnerSort)
    Spinner spinnerSort;
    @BindView(R.id.spinnerSelect)
    Spinner spinnerSelect;
    @BindView(R.id.edtSearch)
    EditText editTextSearch;
    @BindView(R.id.tvApplies)
    TextView tvAplies;
    private AdapterDashboard adapterDashboard;
    private List<Datum> datumList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard,container,false);
        ButterKnife.bind(this,view);
        setUI();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        datumList = new ArrayList<>();

        ApiUtil.getData().getAllDatumInfo(Constant.token,10,"asc").enqueue(new Callback<LoginStatus>() {
            @Override
            public void onResponse(Call<LoginStatus> call, Response<LoginStatus> response) {
                if (response.isSuccessful()){
                    Log.d("yay", response.body()+"");
                    datumList.addAll(response.body().getApplies().getData());
                }else {
                    Log.d("ya",response.errorBody()+"");
                }
            }

            @Override
            public void onFailure(Call<LoginStatus> call, Throwable t) {

            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        adapterDashboard = new AdapterDashboard(datumList,getContext());
        rcv.setLayoutManager(layoutManager);
        rcv.setAdapter(adapterDashboard);

    }

    private void setUI() {
        ArrayAdapter<String> adapterNum = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.array_number));
        adapterNum.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNumber.setAdapter(adapterNum);

        ArrayAdapter<String> adapterSort = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.array_sort));
        adapterSort.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSort.setAdapter(adapterSort);

        ArrayAdapter<String> adapterSelect = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.array_interview));
        adapterSelect.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSelect.setAdapter(adapterSelect);
    }
}
