package com.thanhnguyen.devjob.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.thanhnguyen.devjob.Model.ModelJobDetail.ModelJobDetailJobRelate;
import com.thanhnguyen.devjob.Presenter.Interface.ItemRcvClickListener;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.Utils.Constant;

import java.util.List;

import butterknife.ButterKnife;

public class AdapterJobRelate extends RecyclerView.Adapter<AdapterJobRelate.ItemViewHolder> {
    private List<ModelJobDetailJobRelate> raRelateList;
    private ItemRcvClickListener listener;


    public AdapterJobRelate(List<ModelJobDetailJobRelate> raRelateList, ItemRcvClickListener listener) {
        this.raRelateList = raRelateList;
        this.listener = listener;
    }

    View view;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_rcv_job_relate, null);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        ButterKnife.bind(this, view);
        return new AdapterJobRelate.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ModelJobDetailJobRelate jobItem = raRelateList.get(position);
        Log.d("aaa", "onBindViewHolder: " + jobItem);
        if (jobItem.getFeature() == 1) {
            holder.txtIsHotJob.setRotation(-45);
            holder.txtIsHotJob.setVisibility(View.VISIBLE);
            holder.rlIsShowHotJob.setVisibility(View.VISIBLE);
        } else {
            holder.txtIsHotJob.setVisibility(View.GONE);
            holder.rlIsShowHotJob.setVisibility(View.GONE);
        }


        Glide.with(view).load(jobItem.getLogo())
                .placeholder(R.drawable.ic_empty_file)
                .error(R.drawable.ic_empty_file).fitCenter()
                .into(holder.imgLogo);
        holder.txtTitle.setText(jobItem.getTitle());
        holder.txtCompanyName.setText(jobItem.getName());
        holder.txtLoction.setText(jobItem.getAddress());
        holder.txtBonus.setText(jobItem.getBonus() + "");
        holder.txtTimeAgo.setText(Constant.xuLyThoiGian(jobItem.getStartTime()));

        int listSkillSize = jobItem.getModelJobDetailSkills().size();
        switch (listSkillSize) {
            case 1:
                holder.txtSkillTag1.setText(jobItem.getModelJobDetailSkills().get(0).getName());
                break;
            case 2:
                holder.txtSKillTag2.setVisibility(View.VISIBLE);
                holder.txtSkillTag1.setText(jobItem.getModelJobDetailSkills().get(0).getName());
                holder.txtSKillTag2.setText(jobItem.getModelJobDetailSkills().get(1).getName());
                break;
            case 3:
                holder.txtSKillTag2.setVisibility(View.VISIBLE);
                holder.txtSkillTag3.setVisibility(View.VISIBLE);
                holder.txtSkillTag1.setText(jobItem.getModelJobDetailSkills().get(0).getName());
                holder.txtSKillTag2.setText(jobItem.getModelJobDetailSkills().get(1).getName());
                holder.txtSkillTag3.setText(jobItem.getModelJobDetailSkills().get(2).getName());
                break;
        }

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
        return raRelateList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView txtIsHotJob, txtTitle, txtCompanyName, txtLoction, txtBonus,
                txtTimeAgo, txtSkillTag1, txtSKillTag2, txtSkillTag3;
        private RelativeLayout rlIsShowHotJob, rlParent;
        private ImageView imgLogo, imgSave;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.item_rcv_relate_job_avatar);
            imgSave = itemView.findViewById(R.id.item_rcv_relate_job_favorite);
            txtIsHotJob = itemView.findViewById(R.id.relate_job_txt_hot_job);
            txtTitle = itemView.findViewById(R.id.item_rcv_relate_job_title);
            txtCompanyName = itemView.findViewById(R.id.item_rcv_relate_job_company_name);
            txtLoction = itemView.findViewById(R.id.item_rcv_relate_job_address);
            txtBonus = itemView.findViewById(R.id.item_rcv_relate_job_bonus);
            txtTimeAgo = itemView.findViewById(R.id.item_rcv_relate_job_timestart);
            txtSkillTag1 = itemView.findViewById(R.id.item_rcv_relate_job_language1);
            txtSKillTag2 = itemView.findViewById(R.id.item_rcv_relate_job_language2);
            txtSkillTag3 = itemView.findViewById(R.id.item_rcv_relate_job_language3);
            rlIsShowHotJob = itemView.findViewById(R.id.rl_is_hot_job);
            imgSave = itemView.findViewById(R.id.item_rcv_relate_job_favorite);
            rlParent = itemView.findViewById(R.id.rl_relate_job_item);
        }
    }
}
