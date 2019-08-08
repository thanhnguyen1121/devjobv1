package com.thanhnguyen.devjob.Presenter.FragmentEventDetailPresenter;

import com.thanhnguyen.devjob.Model.ModelEventDetail.ModeEventDetailInfo;
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.ActivityView.EventPostDetailActivity.EventPostDetailViewImp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentEventDetailLogic implements FragmentEventDetailImp {

    private EventPostDetailViewImp eventPostDetailViewImp;

    public FragmentEventDetailLogic(EventPostDetailViewImp eventPostDetailViewImp) {
        this.eventPostDetailViewImp = eventPostDetailViewImp;
    }

    @Override
    public void getEventDetail(String token, String slug) {
        ApiUtil.getData().getEventPostDetail(Constant.token,slug).enqueue(new Callback<ModeEventDetailInfo>() {
            @Override
            public void onResponse(Call<ModeEventDetailInfo> call, Response<ModeEventDetailInfo> response) {
                if(response.isSuccessful()){
                    eventPostDetailViewImp.getData(response.body().getEvent());
                }
            }

            @Override
            public void onFailure(Call<ModeEventDetailInfo> call, Throwable t) {
                    eventPostDetailViewImp.getError(t.getMessage());
            }
        });
    }
}
