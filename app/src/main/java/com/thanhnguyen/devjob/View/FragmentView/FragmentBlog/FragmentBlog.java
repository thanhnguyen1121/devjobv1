package com.thanhnguyen.devjob.View.FragmentView.FragmentBlog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thanhnguyen.devjob.Adapter.AdapterMainRcvBlog;
import com.thanhnguyen.devjob.Model.ModelBlog.BlogInfo;
import com.thanhnguyen.devjob.Model.ModelBlog.BlogItem;
import com.thanhnguyen.devjob.Presenter.FragmentBlogPresenter.FragmentBlogPresenterImp;
import com.thanhnguyen.devjob.Presenter.FragmentBlogPresenter.FragmentBlogPresenterLogic;
import com.thanhnguyen.devjob.Presenter.Interface.ItemRcvClickListener;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.Retrofit.ApiUtil;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.ActivityView.BlogDetailActivity.BlogDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentBlog extends Fragment implements FragmentBlogViewImp, ItemRcvClickListener {
    CircleImageView mainEventsImgUserAvatar;
    @BindView(R.id.main_blog_rcv)
    RecyclerView mainBlogRcv;

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

    }


    @Override
    public void getListBlog(List<BlogItem> blogItemList) {
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
}
