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
import com.thanhnguyen.devjob.Model.ModelCompany.CompanyItem;
import com.thanhnguyen.devjob.Model.ModelJob.Company;
import com.thanhnguyen.devjob.Presenter.Interface.ItemRcvClickListener;
import com.thanhnguyen.devjob.R;

import java.util.List;

public class AdapterMainRcvCompany extends RecyclerView.Adapter<AdapterMainRcvCompany.ItemViewHolder> {

    private List<CompanyItem> companyItemList;
    private ItemRcvClickListener listener;
    View view;

    public AdapterMainRcvCompany(List<CompanyItem> companyItemList, ItemRcvClickListener listener) {
        this.companyItemList = companyItemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_rcv_main_companies, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        CompanyItem companyItem = companyItemList.get(position);
        Glide.with(view).load(companyItem.getLogo())
                .error(R.drawable.ic_user_border)
                .fitCenter()
                .into(holder.imgLogo);
        holder.txtCompanyName.setText(companyItem.getName());
        holder.txtAddress.setText(companyItem.getAddress());
        holder.txtTotalJobl.setText(companyItem.getCount() + "Jobs");
        holder.lnContent.setOnClickListener(new View.OnClickListener() {
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
        return companyItemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgLogo;
        private TextView txtCompanyName, txtAddress, txtTotalJobl;
        private LinearLayout lnContent;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.item_rcv_main_companies_avatar);
            txtCompanyName = itemView.findViewById(R.id.item_rcv_main_compamies_name);
            txtAddress = itemView.findViewById(R.id.item_rcv_main_companies_location);
            txtTotalJobl = itemView.findViewById(R.id.item_rcv_main_companies_totaljob);
            lnContent = itemView.findViewById(R.id.item_rcv_main_companies);
        }
    }
}
