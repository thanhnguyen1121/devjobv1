package com.thanhnguyen.devjob.Adapter;

import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.thanhnguyen.devjob.Model.ModelCompanyDetail.Thumbnail;
import com.thanhnguyen.devjob.R;

import java.util.List;
import java.util.Random;

public class SamplePagerAdapter extends PagerAdapter {

    private final Random random = new Random();
    private int mSize;

    private List<Thumbnail> thumbnailList;

    public SamplePagerAdapter(List<Thumbnail> thumbnailList) {
        this.thumbnailList = thumbnailList;
    }


    @Override
    public int getCount() {
        return thumbnailList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup view, int position, @NonNull Object object) {
        view.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup view, int position) {

        LayoutInflater inflater = LayoutInflater.from(view.getContext());
        View layout = inflater.inflate(R.layout.item_gallery, null);
        ImageView imgGallery = layout.findViewById(R.id.item_company_detail_imgGalley);
        Glide.with(view).load(thumbnailList.get(position).getName()).into(imgGallery);
        view.addView(layout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        return layout;
    }

    public void addItem() {
        mSize++;
        notifyDataSetChanged();
    }

    public void removeItem() {
        mSize--;
        mSize = mSize < 0 ? 0 : mSize;

        notifyDataSetChanged();
    }
}