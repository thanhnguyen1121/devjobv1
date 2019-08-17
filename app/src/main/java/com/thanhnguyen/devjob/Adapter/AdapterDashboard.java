package com.thanhnguyen.devjob.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thanhnguyen.devjob.Model.ModelCompany.CompanyItem;
import com.thanhnguyen.devjob.Model.ModelDashboard.Datum;
import com.thanhnguyen.devjob.R;

import java.util.List;

public class AdapterDashboard extends RecyclerView.Adapter<AdapterDashboard.ViewHolder>{

    public List<Datum> itemList;

    public AdapterDashboard(List<Datum> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    Context context;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rcv_dashboard,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvJob.setText(itemList.get(position).getTitle());
        holder.tvDate.setText(itemList.get(position).getCreatedAt());
        holder.tvStatus.setText(itemList.get(position).getStatus());
        holder.tvSalary.setText(itemList.get(position).getSalaryMin()+" - "+itemList.get(position).getSalaryMax());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNumber,tvJob, tvDate, tvSalary,tvStatus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNumber = itemView.findViewById(R.id.tvNum);
            tvJob = itemView.findViewById(R.id.tvJobName);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvSalary = itemView.findViewById(R.id.tvSalary);
            tvStatus = itemView.findViewById(R.id.tvStatus);
        }
    }
}
