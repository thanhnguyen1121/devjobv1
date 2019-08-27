package com.thanhnguyen.devjob.View.FragmentView.FragmentEvent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.thanhnguyen.devjob.Adapter.AdapterMainRcvEvent;
import com.thanhnguyen.devjob.Model.ModelEvent.EventItem;
import com.thanhnguyen.devjob.Presenter.FragmentEventPresenter.FragmentEventPresenterImp;
import com.thanhnguyen.devjob.Presenter.FragmentEventPresenter.FragmentEventPresenterLogic;
import com.thanhnguyen.devjob.Presenter.Interface.ItemRcvClickListener;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.ActivityView.EventPostDetailActivity.EventPostDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentEvent extends Fragment implements FragmentEventViewImp, ItemRcvClickListener, SwipeRefreshLayout.OnRefreshListener {

    CircleImageView mainEventsImgUserAvatar;
    @BindView(R.id.main_event_rcv)
    RecyclerView mainEventRcv;
    @BindView(R.id.fragment_event_swipe)
    SwipeRefreshLayout fragmentEventSwipe;

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
        fragmentEventSwipe.setRefreshing(true);
        this.eventItemList = new ArrayList<>();
        fragmentEventSwipe.setOnRefreshListener(this);
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
        if(!eventItemList.isEmpty()){
            fragmentEventSwipe.setRefreshing(false);
            this.eventItemList = eventItemList;
            createRcvEvent(eventItemList);
        }
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

    @Override
    public void onRefresh() {
        fragmentEventPresenterImp.getAllEventPost(Constant.token);
    }
}
