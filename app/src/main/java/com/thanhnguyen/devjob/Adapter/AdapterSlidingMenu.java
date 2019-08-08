package com.thanhnguyen.devjob.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thanhnguyen.devjob.Model.ItemSlidingMenu;
import com.thanhnguyen.devjob.Presenter.Interface.ItemRcvClickListener;
import com.thanhnguyen.devjob.R;

import java.util.List;

public class AdapterSlidingMenu extends RecyclerView.Adapter<AdapterSlidingMenu.ItemViewHolder> {

    private Context context;
    private List<ItemSlidingMenu> itemSlidingMenus;
    private List<ItemSlidingMenu> itemSlidingMenusSelected;
    private ItemRcvClickListener listener;

    public AdapterSlidingMenu(Context context, List<ItemSlidingMenu> itemSlidingMenus, List<ItemSlidingMenu> itemSlidingMenusSelected, ItemRcvClickListener listener) {
        this.context = context;
        this.itemSlidingMenus = itemSlidingMenus;
        this.itemSlidingMenusSelected = itemSlidingMenusSelected;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_menu_user, null);
        return new ItemViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        holder.txtContent.setText(itemSlidingMenus.get(position).getContent());
        holder.txtContent.setTextColor(context.getResources().getColor(R.color.colorBlack));
        holder.view.setBackgroundColor(context.getResources().getColor(R.color.colorBlack));
        if (itemSlidingMenus.get(position).isSelected()) {
            holder.imgLogo.setImageResource(itemSlidingMenusSelected.get(position).getImage());
            holder.txtContent.setTextColor(context.getResources().getColor(R.color.colorTextItemSlidingMenu));
            holder.view.setBackgroundColor(context.getResources().getColor(R.color.colorTextItemSlidingMenu));
        } else {
            holder.imgLogo.setImageResource(itemSlidingMenus.get(position).getImage());
        }
        holder.rlItem.setOnClickListener(new View.OnClickListener() {
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
        return itemSlidingMenus.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgLogo;
        private TextView txtContent;
        private RelativeLayout rlItem;
        private View view;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.item_menu_user_icon);
            txtContent = itemView.findViewById(R.id.item_menu_user_txt_content);
            rlItem = itemView.findViewById(R.id.item_menu_user_rl);
            view = itemView.findViewById(R.id.item_menu_line);
        }
    }
}
