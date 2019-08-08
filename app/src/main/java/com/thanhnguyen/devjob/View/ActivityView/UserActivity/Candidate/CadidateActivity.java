package com.thanhnguyen.devjob.View.ActivityView.UserActivity.Candidate;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.thanhnguyen.devjob.Adapter.AdapterSlidingMenu;
import com.thanhnguyen.devjob.Model.ItemSlidingMenu;
import com.thanhnguyen.devjob.Presenter.Interface.ItemRcvClickListener;
import com.thanhnguyen.devjob.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CadidateActivity extends AppCompatActivity implements ItemRcvClickListener {

    @BindView(R.id.user_titles)
    TextView userTitles;
    @BindView(R.id.spinnerTime)
    MaterialSpinner spinnerTime;
    @BindView(R.id.spinnerStatus)
    MaterialSpinner spinnerStatus;


    private SlidingMenu menu;
    private List<ItemSlidingMenu> menuList;
    private List<ItemSlidingMenu> menuListSelected;
    private AdapterSlidingMenu adapterSlidingMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadidate);
        ButterKnife.bind(this);
        //setSupportActionBar(userToolbar);
        menu = new SlidingMenu(this);
        menuList = new ArrayList<>();
        menuListSelected = new ArrayList<>();
        createSlidingMenu(menu);
        spinnerTime.setItems("Oldest", "Lasted");
        spinnerTime.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                Toast.makeText(CadidateActivity.this, item +"", Toast.LENGTH_SHORT).show();
            }
        });
        spinnerStatus.setItems("All","Pending","Rejected Interview","Waiting for interview","Passed interview", "Failed interview");
        spinnerStatus.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                Toast.makeText(CadidateActivity.this, item +"", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createSlidingMenu(SlidingMenu menu) {
        menuList.add(new ItemSlidingMenu(R.drawable.ic_dashboard_black, "DashBoard", true));
        menuList.add(new ItemSlidingMenu(R.drawable.ic_bookmark_bkack, "Favorite", false));
        menuList.add(new ItemSlidingMenu(R.drawable.ic_profile_black, "Profile", false));
        menuList.add(new ItemSlidingMenu(R.drawable.ic_upload_black, "Upload CV", false));
        menuList.add(new ItemSlidingMenu(R.drawable.ic_http_black, "Change Password", false));
        menuList.add(new ItemSlidingMenu(R.drawable.ic_logout_black, "Log out", false));

        menuListSelected.add(new ItemSlidingMenu(R.drawable.ic_dashboard, "DashBoard", true));
        menuListSelected.add(new ItemSlidingMenu(R.drawable.ic_bookmark_blue, "Favorite", false));
        menuListSelected.add(new ItemSlidingMenu(R.drawable.ic_profile_blue, "Profile", false));
        menuListSelected.add(new ItemSlidingMenu(R.drawable.ic_upload_blue, "Upload CV", false));
        menuListSelected.add(new ItemSlidingMenu(R.drawable.ic_http_blue, "Change Password", false));
        menuListSelected.add(new ItemSlidingMenu(R.drawable.ic_logout_blue, "Log out", false));

        menu.setMode(SlidingMenu.LEFT);
        //menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen._5sdp);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.setBehindOffsetRes(R.dimen._100sdp);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.sliding_menu);
        RecyclerView rcvSlidingMenu = menu.findViewById(R.id.rcv_slidingMenu);
        adapterSlidingMenu = new AdapterSlidingMenu(this, menuList, menuListSelected, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        rcvSlidingMenu.setLayoutManager(manager);
        rcvSlidingMenu.setAdapter(adapterSlidingMenu);
    }

    @OnClick(R.id.user_menu)
    public void onViewClicked() {
        menu.toggle();
    }

    @Override
    public void clickedItem(int position) {
        for (ItemSlidingMenu item : menuList) {
            item.setSelected(false);
        }
        menuList.get(position).setSelected(true);
        userTitles.setText(menuList.get(position).getContent());
        adapterSlidingMenu.notifyDataSetChanged();
        menu.toggle();
    }
}
