package com.thanhnguyen.devjob.Presenter.FragmentEventPresenter;

import android.util.Log;

import com.thanhnguyen.devjob.Model.ModelEvent.EventInfo;
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.FragmentView.FragmentEvent.FragmentEvent;
import com.thanhnguyen.devjob.View.FragmentView.FragmentEvent.FragmentEventViewImp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentEventPresenterLogic implements FragmentEventPresenterImp {

    private FragmentEventViewImp fragmentEventViewImp;

    public FragmentEventPresenterLogic(FragmentEventViewImp fragmentEventViewImp) {
        this.fragmentEventViewImp = fragmentEventViewImp;
    }

    @Override
    public void getAllEventPost(String token) {
        ApiUtil.getData().getAllEventInfo(Constant.token).enqueue(new Callback<EventInfo>() {
            @Override
            public void onResponse(Call<EventInfo> call, Response<EventInfo> response) {
                if(response.isSuccessful()){
                    fragmentEventViewImp.getData(response.body().getEvents().getData());
                }
            }

            @Override
            public void onFailure(Call<EventInfo> call, Throwable t) {
                    fragmentEventViewImp.getError(t.getMessage());
            }
        });

    }
}
