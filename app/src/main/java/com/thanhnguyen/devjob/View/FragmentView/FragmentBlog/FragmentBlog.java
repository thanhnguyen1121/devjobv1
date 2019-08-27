package com.thanhnguyen.devjob.View.FragmentView.FragmentBlog;

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

import com.thanhnguyen.devjob.Adapter.AdapterMainRcvBlog;
import com.thanhnguyen.devjob.Model.ModelBlog.BlogItem;
import com.thanhnguyen.devjob.Presenter.FragmentBlogPresenter.FragmentBlogPresenterImp;
import com.thanhnguyen.devjob.Presenter.FragmentBlogPresenter.FragmentBlogPresenterLogic;
import com.thanhnguyen.devjob.Presenter.Interface.ItemRcvClickListener;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.ActivityView.BlogDetailActivity.BlogDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentBlog extends Fragment implements FragmentBlogViewImp, ItemRcvClickListener, SwipeRefreshLayout.OnRefreshListener {
    CircleImageView mainEventsImgUserAvatar;
    @BindView(R.id.main_blog_rcv)
    RecyclerView mainBlogRcv;
    @BindView(R.id.fragment_blog_swipe)
    SwipeRefreshLayout fragmentBlogSwipe;


    private List<BlogItem> blogItemList;
    private AdapterMainRcvBlog adapterMainRcvBlog;
    private FragmentBlogPresenterImp fragmentBlogPresenterImp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blog, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        blogItemList = new ArrayList<>();
        fragmentBlogPresenterImp = new FragmentBlogPresenterLogic(this);
        fragmentBlogPresenterImp.getData(Constant.token);
        fragmentBlogSwipe.setRefreshing(true);
        fragmentBlogSwipe.setOnRefreshListener(this);

    }


    @Override
    public void getListBlog(List<BlogItem> blogItemList) {
        fragmentBlogSwipe.setRefreshing(false);
        this.blogItemList = blogItemList;
        createMainRcv(this.blogItemList);
    }

    @Override
    public void getError(String mes) {
        Log.d("aaa", "getError: " + mes);
    }

    @Override
    public void clickedItem(int position) {
        Intent intent = new Intent(getContext(), BlogDetailActivity.class);
        intent.putExtra("blog", blogItemList.get(position));
        startActivity(intent);
    }


    private void createMainRcv(List<BlogItem> blogItemList) {
        adapterMainRcvBlog = new AdapterMainRcvBlog(blogItemList, this);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        mainBlogRcv.setLayoutManager(manager);
        mainBlogRcv.setAdapter(adapterMainRcvBlog);
    }

    @Override
    public void onRefresh() {
        fragmentBlogPresenterImp.getData(Constant.token);
    }
}
