package com.thanhnguyen.devjob.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.thanhnguyen.devjob.Model.ModelCourse.CourseItem;
import com.thanhnguyen.devjob.Presenter.Interface.ItemRcvClickListener;
import com.thanhnguyen.devjob.R;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterFragmentCourse extends RecyclerView.Adapter<AdapterFragmentCourse.ItemVieHolder> {

    private List<CourseItem> courseItems;
    private ItemRcvClickListener listener;
    private View view;

    public AdapterFragmentCourse(List<CourseItem> courseItems, ItemRcvClickListener listener) {
        this.courseItems = courseItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemVieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_rcv_course, null);
        return new ItemVieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemVieHolder holder, int position) {
        CourseItem courseItem = courseItems.get(position);
        Glide.with(view).load(courseItem.getAvatarC()).into(holder.imgLogo);
        holder.tvTitle.setText(courseItem.getTitle());
        holder.tvAuth.setText(courseItem.getTeacher());
        holder.tvSubcontent.setText(courseItem.getContentShortCut());
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
        return courseItems.size();
    }

    public class ItemVieHolder extends RecyclerView.ViewHolder {
        private ImageView imgLogo;
        private TextView tvTitle, tvAuth, tvSubcontent;
        private RelativeLayout rlParent;

        public ItemVieHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.img_item_course_logo);
            tvTitle = itemView.findViewById(R.id.tv_item_rcv_course_title);
            tvAuth = itemView.findViewById(R.id.tv_item_rcv_course_auth);
            tvSubcontent = itemView.findViewById(R.id.tv_item_rcv_course_subcontent);
            rlParent = itemView.findViewById(R.id.rl_parent);
        }
    }
}
