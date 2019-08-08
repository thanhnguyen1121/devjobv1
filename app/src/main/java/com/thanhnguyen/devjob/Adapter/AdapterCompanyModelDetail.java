package com.thanhnguyen.devjob.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.thanhnguyen.devjob.Model.ModelCompanyDetail.CompanyDetailJobItem;
import com.thanhnguyen.devjob.Model.ModelCompanyDetail.Detail;
import com.thanhnguyen.devjob.Model.ModelJob.Company;
import com.thanhnguyen.devjob.Presenter.Interface.ItemRcvClickListener;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.Utils.Constant;

import java.util.List;

public class AdapterCompanyModelDetail extends RecyclerView.Adapter<AdapterCompanyModelDetail.ItemViewHolder> {
    private List<CompanyDetailJobItem> jobItemList;
    private Detail detail;
    private ItemRcvClickListener listener;
    View view;

    public AdapterCompanyModelDetail(List<CompanyDetailJobItem> jobItemList, Detail detail,ItemRcvClickListener listener) {
        this.jobItemList = jobItemList;
        this.detail = detail;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AdapterCompanyModelDetail.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_company_model_detail, null);
        return new AdapterCompanyModelDetail.ItemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        CompanyDetailJobItem jobItem = jobItemList.get(position);;

        Glide.with(view).load(detail.getLogo()).into(holder.imgLogoCompany);
        holder.txtTiltle.setText( jobItem.getTitle());
        holder.txtAddress.setText(jobItem.getAddress());
        holder.txdtTag1.setText(jobItem.getName());
        switch (jobItem.getType()){
            case 0:
                break;
            case 1:
                holder.txtWorkTime.setText("FullTime");
                break;
            case 2:
                break;
            case 3:
                holder.txtWorkTime.setText("Contract");
                break;
            case 4:
                holder.txtWorkTime.setText("Temprorary");
                break;
        }
        holder.txtTimeAgo.setText(Constant.xuLyThoiGian(jobItem.getStartTime()));
        holder.lnMain.setOnClickListener(new View.OnClickListener() {
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
        return jobItemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgLogoCompany;
        private TextView txtTiltle, txdtTag1,txtAddress, txtWorkTime, txtTimeAgo;
        private LinearLayout lnMain;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogoCompany = itemView.findViewById(R.id.item_rcv_company_model_detail_avatar);
            txtTiltle = itemView.findViewById(R.id.item_rcv_company_model_detail_title);
            txtAddress = itemView.findViewById(R.id.item_rcv_company_model_detail_location);
            txdtTag1 = itemView.findViewById(R.id.item_rcv_company_model_detail_tag1);
            txtWorkTime = itemView.findViewById(R.id.item_rcv_company_model_detail_timework);
            txtTimeAgo = itemView.findViewById(R.id.item_rcv_company_model_detail_timeago);
            lnMain = itemView.findViewById(R.id.item_company_model_main_ln);
        }
    }

}
