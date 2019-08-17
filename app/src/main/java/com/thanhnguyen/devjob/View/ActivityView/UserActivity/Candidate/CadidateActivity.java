package com.thanhnguyen.devjob.View.ActivityView.UserActivity.Candidate;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.View.FragmentView.FragmentCandidateDashBoard.FragmentCandidateProfile.FragmentCandidateProfile;
import com.thanhnguyen.devjob.View.FragmentView.FragmentCandidateDashBoard.FragmentChangePassword;
import com.thanhnguyen.devjob.View.FragmentView.FragmentCandidateDashBoard.FragmentDashBoard.FragmentDashBoard;
import com.thanhnguyen.devjob.View.FragmentView.FragmentCandidateDashBoard.FragmentFavorite;
import com.thanhnguyen.devjob.View.FragmentView.FragmentCandidateDashBoard.FragmentUploadCV;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CadidateActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.navigation)
    NavigationView navigationView;
    @BindView(R.id.draw_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.tool_bar)
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadidate);
        ButterKnife.bind(this);
        setNavigation();

    }

    private void setNavigation() {
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.draw_open,R.string.draw_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.lnlayout,new FragmentDashBoard()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.ic_dashboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.lnlayout,new FragmentDashBoard()).commit();
                break;
            case R.id.favorite:
                getSupportFragmentManager().beginTransaction().replace(R.id.lnlayout,new FragmentFavorite()).commit();
                break;
            case R.id.ic_candidate:
                getSupportFragmentManager().beginTransaction().replace(R.id.lnlayout,new FragmentCandidateProfile()).commit();
                break;
            case R.id.ic_upload_cv:
                getSupportFragmentManager().beginTransaction().replace(R.id.lnlayout,new FragmentUploadCV()).commit();
                break;
            case R.id.ic_change_password:
                getSupportFragmentManager().beginTransaction().replace(R.id.lnlayout,new FragmentChangePassword()).commit();
                break;
            case R.id.ic_logout:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}
