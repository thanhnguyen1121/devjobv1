package com.thanhnguyen.devjob.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.thanhnguyen.devjob.Model.ModelEvent.EventInfo;
import com.thanhnguyen.devjob.Model.ModelEvent.EventItem;
import com.thanhnguyen.devjob.Presenter.Interface.ItemRcvClickListener;
import com.thanhnguyen.devjob.R;

import java.util.List;

public class AdapterMainRcvEvent extends RecyclerView.Adapter<AdapterMainRcvEvent.ItemViewHolder> {

    private List<EventItem> eventItemList;
    private ItemRcvClickListener listener;
    private View view;
    public AdapterMainRcvEvent(List<EventItem> eventItemList, ItemRcvClickListener listener) {
        this.eventItemList = eventItemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_rcv_main_event, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        EventItem eventItem =eventItemList.get(position);
        Glide.with(view).load(eventItem.getAvatarEvent()).into(holder.imgbg);
        holder.txtTitle.setText("Start Invalid date End " + eventItem.getDay());
        holder.txtTag.setText(eventItem.getSpeakers());
        holder.txtSubContent.setText(eventItem.getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
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
        return eventItemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgbg;
        private TextView txtTitle, txtTag, txtSubContent;
        private CardView cardView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgbg = itemView.findViewById(R.id.item_rcv_main_event_img_imgview);
            txtTitle = itemView.findViewById(R.id.item_rcv_main_event_txtTitle);
            txtTag = itemView.findViewById(R.id.item_rcv_main_event_txtTag);
            txtSubContent = itemView.findViewById(R.id.item_rcv_main_event_txtSubContent);
            cardView = itemView.findViewById(R.id.item_rcv_main_event_cardview);
        }
    }
}
