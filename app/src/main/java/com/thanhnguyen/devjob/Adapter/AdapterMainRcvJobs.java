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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.OnClick;

public class AdapterMainRcvJobs extends RecyclerView.Adapter<AdapterMainRcvJobs.ItemViewHolder> {

    private List<JobItem> jobItemList;
    private List<Company> companyList;
    private ItemRcvClickListener listener;
    List<CountSkill> countSkillList;
    View view;

    public AdapterMainRcvJobs(List<JobItem> jobItemList, List<Company> companyList,
                              ItemRcvClickListener listener, List<CountSkill> countSkillList) {
        this.jobItemList = jobItemList;
        this.companyList = companyList;
        this.listener = listener;
        this.countSkillList = countSkillList;
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
            holder.txtIsHotJob.setRotation(-45);
            holder.txtIsHotJob.setVisibility(View.VISIBLE);
        } else {
            holder.txtIsHotJob.setVisibility(View.GONE);
        }

        holder.imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialogConfirm();
            }
        });

        if (jobItem.getSalaryMin() != null || jobItem.getSalaryMin() != null) {
            holder.txtDeal.setText(jobItem.getSalaryMin() + "-" + jobItem.getSalaryMax() + " USD");
        } else {
            if (jobItem.getDeal() == 1) {
                holder.txtDeal.setText("Deal");
            }
        }


        CountSkill skill = getCountSkillByCateId(jobItem.getCateId(), countSkillList);

        holder.txtLaguageName.setText(skill.getName());
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
        private ImageView imgLogoCompany, imgFavorite, txtIsHotJob;
        private TextView txtCompanyName, txtTiltle, txtAddress, txtDeal, txtTimeStart,
                txtLaguageName;
        private LinearLayout lnMain;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogoCompany = itemView.findViewById(R.id.item_rcv_main_jobs_avatar);
            txtTiltle = itemView.findViewById(R.id.item_rcv_main_jobs_title);
            txtAddress = itemView.findViewById(R.id.item_rcv_main_jobs_address);
            txtDeal = itemView.findViewById(R.id.item_rcv_main_jobs_deal);
            txtTimeStart = itemView.findViewById(R.id.item_rcv_main_jobs_timestart);
            txtLaguageName = itemView.findViewById(R.id.item_rcv_main_jobs_language);
            lnMain = itemView.findViewById(R.id.item_rcv_main_jobs_lnMain);
            txtCompanyName = itemView.findViewById(R.id.item_rcv_main_jobs_company_name);
            imgFavorite = itemView.findViewById(R.id.item_rcv_main_jobs_favorite);
            txtIsHotJob = itemView.findViewById(R.id.item_rcv_main_job_is_hot);
        }
    }

    //    private Company getCompany(int idCompany, List<Company> companyList) {
//        for (Company item : companyList
//        ) {
//            if (idCompany == item.getId()) {
//                return item;
//            }
//        }
//        return null;
//    }
    private Company getCompany(String companyaName, List<Company> companyList) {
        for (Company item : companyList
        ) {
            if (companyaName.equals(item.getName())) {
                return item;
            }
        }
        return null;
    }

    private CountSkill getCountSkillByCateId(int id, List<CountSkill> countSkillList) {
        for (CountSkill item : countSkillList
        ) {
            if (id == item.getCateId()) {
                return item;
            }
        }
        return null;
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
