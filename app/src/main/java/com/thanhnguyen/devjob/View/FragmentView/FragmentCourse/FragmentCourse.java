package com.thanhnguyen.devjob.View.FragmentView.FragmentCourse;

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

import com.thanhnguyen.devjob.Adapter.AdapterFragmentCourse;
import com.thanhnguyen.devjob.Adapter.AdapterMainRcvBlog;
import com.thanhnguyen.devjob.Model.ModelCourse.CourseInfo;
import com.thanhnguyen.devjob.Model.ModelCourse.CourseItem;
import com.thanhnguyen.devjob.Presenter.FragmentCoursePresenter.FragmentCoursePresenterImp;
import com.thanhnguyen.devjob.Presenter.FragmentCoursePresenter.FragmentCoursePresenterLogic;
import com.thanhnguyen.devjob.Presenter.Interface.ItemRcvClickListener;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.ActivityView.CourseDetailActivity.CourseDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentCourse extends Fragment implements FragmentCourseViewImp, ItemRcvClickListener {
    private RecyclerView fragmentCoreRcv;

    private AdapterFragmentCourse adapterFragmentCourse;
    private FragmentCoursePresenterImp presenter;
    private List<CourseItem> courseItemList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course, container, false);
        fragmentCoreRcv = view.findViewById(R.id.fragment_course_rcv);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new FragmentCoursePresenterLogic(this);
        presenter.getData(Constant.token);
        courseItemList = new ArrayList<>();


    }

    private void createRcvCourse(List<CourseItem> courseItemList) {
        adapterFragmentCourse = new AdapterFragmentCourse(courseItemList,this);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        fragmentCoreRcv.setLayoutManager(manager);
        fragmentCoreRcv.setAdapter(adapterFragmentCourse);
    }

    @Override
    public void getListCourse(List<CourseItem> courseItemList) {
        this.courseItemList = courseItemList;
        createRcvCourse(this.courseItemList);
    }

    @Override
    public void getError(String error) {

        Log.d("aaa", "getError: " + error);
    }

    @Override
    public void clickedItem(int position) {
        Intent intent = new Intent(getActivity(), CourseDetailActivity.class);
        intent.putExtra("course", courseItemList.get(position));
        startActivity(intent);
    }


}
