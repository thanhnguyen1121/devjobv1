package com.thanhnguyen.devjob.Adapter;

import android.app.Dialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.thanhnguyen.devjob.Model.ModelJob.Cate;
import com.thanhnguyen.devjob.Model.ModelJob.Company;
import com.thanhnguyen.devjob.Model.ModelJob.CountSkill;
import com.thanhnguyen.devjob.Model.ModelJob.JobItem;
import com.thanhnguyen.devjob.Presenter.Interface.ItemRcvClickListener;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.Utils.Constant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.OnClick;

public class AdapterMainRcvJobs extends RecyclerView.Adapter<AdapterMainRcvJobs.ItemViewHolder> {

    private List<JobItem> jobItemList;
    private List<Company> companyList;
    private ItemRcvClickListener listener;
    List<Cate> cateList;
    View view;

    public AdapterMainRcvJobs(List<JobItem> jobItemList, List<Company> companyList,
                              ItemRcvClickListener listener, List<Cate> cateList) {
        this.jobItemList = jobItemList;
        this.companyList = companyList;
        this.listener = listener;
        this.cateList = cateList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_rcv_main_jobs, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        JobItem jobItem = jobItemList.get(position);
//        Company company = getCompany(jobItem.getCompanyId(), companyList);
        Company company = getCompany(jobItem.getCompanyName(), companyList);
        Glide.with(view).load(company.getLogo()).into(holder.imgLogoCompany);
        holder.txtCompanyName.setText(company.getName());
        holder.txtTiltle.setText(jobItem.getTitle());
        holder.txtTimeStart.setText(Constant.xuLyThoiGian(jobItem.getStartTime()));
        holder.txtAddress.setText(jobItem.getAddress_job());

        if (jobItem.getFeature() == 1) {
            holder.txtHotJob.setRotation(-45);
            holder.txtHotJob.setVisibility(View.VISIBLE);
            holder.rlIsHotJob.setVisibility(View.VISIBLE);
        } else {
            holder.txtHotJob.setVisibility(View.GONE);
            holder.rlIsHotJob.setVisibility(View.GONE);
        }


        if (jobItem.getSalaryMin() != null || jobItem.getSalaryMin() != null) {
            holder.txtDeal.setText(jobItem.getSalaryMin() + "-" + jobItem.getSalaryMax() + " USD");
        } else {
            if (jobItem.getDeal() == 1) {
                holder.txtDeal.setText("Deal");
            }
        }


        List<Cate> listTag = getCountSkillByCateId(jobItem.getJobId(), cateList);
        int listTagSize = listTag.size();
        switch (listTagSize) {
            case 1:
                holder.txtLaguageName1.setText(listTag.get(0).getName());
                break;
            case 2:
                holder.txtLaguageName2.setVisibility(View.VISIBLE);
                holder.txtLaguageName1.setText(listTag.get(0).getName());
                holder.txtLaguageName2.setText(listTag.get(1).getName());
                break;
            case 3:
                holder.txtLaguageName2.setVisibility(View.VISIBLE);
                holder.txtLaguageName3.setVisibility(View.VISIBLE);
                holder.txtLaguageName1.setText(listTag.get(0).getName());
                holder.txtLaguageName2.setText(listTag.get(1).getName());
                holder.txtLaguageName3.setText(listTag.get(2).getName());
                break;
        }


        holder.imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialogConfirm();
            }
        });

        holder.lnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
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
        private ImageView imgLogoCompany, imgFavorite;
        private TextView txtCompanyName, txtTiltle, txtAddress, txtDeal, txtTimeStart,
                txtLaguageName1, txtLaguageName2, txtLaguageName3, txtHotJob;
        private LinearLayout lnMain;
        private RelativeLayout rlIsHotJob;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogoCompany = itemView.findViewById(R.id.item_rcv_main_jobs_avatar);
            txtTiltle = itemView.findViewById(R.id.item_rcv_main_jobs_title);
            txtAddress = itemView.findViewById(R.id.item_rcv_main_jobs_address);
            txtDeal = itemView.findViewById(R.id.item_rcv_main_jobs_deal);
            txtTimeStart = itemView.findViewById(R.id.item_rcv_main_jobs_timestart);
            txtLaguageName1 = itemView.findViewById(R.id.item_rcv_main_jobs_language1);
            txtLaguageName2 = itemView.findViewById(R.id.item_rcv_main_jobs_language2);
            txtLaguageName3 = itemView.findViewById(R.id.item_rcv_main_jobs_language3);
            lnMain = itemView.findViewById(R.id.item_rcv_main_jobs_lnMain);
            txtCompanyName = itemView.findViewById(R.id.item_rcv_main_jobs_company_name);
            imgFavorite = itemView.findViewById(R.id.item_rcv_main_jobs_favorite);
            txtHotJob = itemView.findViewById(R.id.txt_hot_job);
            rlIsHotJob = itemView.findViewById(R.id.rl_is_hot_job);
        }
    }

    private Company getCompany(String companyaName, List<Company> companyList) {
        for (Company item : companyList
        ) {
            if (companyaName.equals(item.getName())) {
                return item;
            }
        }
        return null;
    }

    private List<Cate> getCountSkillByCateId(int jobId, List<Cate> cateList) {
        List<Cate> temp = new ArrayList<>();
        for (Cate item : cateList) {
            if (jobId == item.getJobId()) {
                temp.add(item);
            }
        }
        return temp;
    }

    private void createDialogConfirm() {
        Dialog dialog = new Dialog(view.getContext());
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_confirm_favorite);
        dialog.setCanceledOnTouchOutside(false);
        Button btnSave = dialog.findViewById(R.id.dialog_confirm_save_btn_save);
        Button btnCancel = dialog.findViewById(R.id.dialog_confirm_save_btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(dialog.getContext(), "Save", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

}
