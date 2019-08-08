package com.thanhnguyen.devjob.View.FragmentView.FragmentEvent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thanhnguyen.devjob.Adapter.AdapterMainRcvEvent;
import com.thanhnguyen.devjob.Model.ModelEvent.EventInfo;
import com.thanhnguyen.devjob.Model.ModelEvent.EventItem;
import com.thanhnguyen.devjob.Presenter.FragmentEventPresenter.FragmentEventPresenterImp;
import com.thanhnguyen.devjob.Presenter.FragmentEventPresenter.FragmentEventPresenterLogic;
import com.thanhnguyen.devjob.Presenter.Interface.ItemRcvClickListener;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.ActivityView.EventPostDetailActivity.EventPostDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentEvent extends Fragment implements FragmentEventViewImp, ItemRcvClickListener {

    CircleImageView mainEventsImgUserAvatar;
    @BindView(R.id.main_event_rcv)
    RecyclerView mainEventRcv;

    private AdapterMainRcvEvent adapterMainRcvEvent;
    private FragmentEventPresenterImp fragmentEventPresenterImp;
    private List<EventItem> eventItemList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentEventPresenterImp = new FragmentEventPresenterLogic(this);
        fragmentEventPresenterImp.getAllEventPost(Constant.token);

        this.eventItemList = new ArrayList<>();
    }

    private void createRcvEvent(List<EventItem> eventItemList) {
        adapterMainRcvEvent = new AdapterMainRcvEvent(eventItemList, this);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        mainEventRcv.setLayoutManager(manager);
        mainEventRcv.setAdapter(adapterMainRcvEvent);


    }


    @Override
    public void getData(List<EventItem> eventItemList) {
        this.eventItemList = eventItemList;
        createRcvEvent(eventItemList);
    }

    @Override
    public void getError(String mes) {
        Log.d("aaa", "getError: " + mes);
    }

    @Override
    public void clickedItem(int position) {
        Intent intent = new Intent(getActivity(), EventPostDetailActivity.class);
        intent.putExtra("eventdetail", eventItemList.get(position));
        startActivity(intent);
    }
}
