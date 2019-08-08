package com.thanhnguyen.devjob.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.thanhnguyen.devjob.Model.ModelBlog.BlogItem;
import com.thanhnguyen.devjob.Presenter.Interface.ItemRcvClickListener;
import com.thanhnguyen.devjob.R;

import java.util.List;

public class AdapterMainRcvBlog extends RecyclerView.Adapter<AdapterMainRcvBlog.ItemViewHolder> {

    private List<BlogItem> blogItemList;
    private ItemRcvClickListener listener;
    private View view;
    public AdapterMainRcvBlog(List<BlogItem> blogItemList, ItemRcvClickListener listener) {
        this.blogItemList = blogItemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_rcv_main_blog, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        BlogItem blogItem = blogItemList.get(position);
        Glide.with(view).load(blogItem.getAvatarBlog()).into(holder.imgLogo);
        holder.txtSubContent.setText(blogItem.getContentShortCut());
        holder.txtTitile.setText(blogItem.getTitle());


        String datetime = blogItem.getCreatedAt();
        String []date = datetime.split(" ");
        holder.txtTime.setText(date[0]);
        holder.txtView.setText(blogItem.getViewCount() +"");
        holder.rlParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.clickedItem(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return blogItemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogo;
        RelativeLayout rlParent;
        TextView txtTitile, txtSubContent, txtTime, txtView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.imageView);
            rlParent = itemView.findViewById(R.id.rl_item_rcv_main_blog);
            txtTitile = itemView.findViewById(R.id.item_rcv_main_blog_tv_title);
            txtSubContent = itemView.findViewById(R.id.item_rcv_main_blog_tv_subcontent);
            txtView = itemView.findViewById(R.id.item_rcv_main_blog_tv_view);
            txtTime = itemView.findViewById(R.id.item_rcv_main_blog_tv_time);
        }
    }
}
