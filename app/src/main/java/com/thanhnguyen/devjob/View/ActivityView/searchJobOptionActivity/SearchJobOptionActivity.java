package com.thanhnguyen.devjob.View.ActivityView.searchJobOptionActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.thanhnguyen.devjob.Model.ModelJob.CountLevel;
import com.thanhnguyen.devjob.Model.ModelJob.CountSkill;
import com.thanhnguyen.devjob.R;
import com.thanhnguyen.devjob.Utils.Constant;
import com.thanhnguyen.devjob.View.FragmentView.FragmentJob.FragmentJob;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchJobOptionActivity extends AppCompatActivity {

    @BindView(R.id.sp_jobfragment_bonus)
    MaterialSpinner spJobfragmentBonus;
    @BindView(R.id.sp_jobfragment_level)
    MaterialSpinner spJobfragmentLevel;
    @BindView(R.id.sp_jobfragment_skill)
    MaterialSpinner spJobfragmentSkill;
    @BindView(R.id.btn_search)
    Button btnSearch;
    List<CountLevel> countLevelList;
    List<CountSkill> countSkillList;
    List<String> listLevel, listSkill;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_job_option);
        ButterKnife.bind(this);

        listLevel = new ArrayList<>();
        listSkill = new ArrayList<>();
        Bundle bundle = getIntent().getBundleExtra("bundle");
        countLevelList = bundle.getParcelableArrayList("level");
        countSkillList = bundle.getParcelableArrayList("skill");
        listLevel.add("All");
        listSkill.add("All");
        for (CountLevel item : countLevelList
        ) {
            listLevel.add(item.getName());
        }
        for (CountSkill item : countSkillList
        ) {
            listSkill.add(item.getName());
        }

        spJobfragmentBonus.setItems("All", "Default", "Bonus");
        spJobfragmentSkill.setItems(listSkill);
        spJobfragmentLevel.setItems(listLevel);


    }


    @OnClick({R.id.img_search_option_back, R.id.btn_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_search_option_back:
                this.finish();
                break;
            case R.id.btn_search:
                intent = new Intent(this, FragmentJob.class);
                int level = spJobfragmentLevel.getSelectedIndex();
                int skill = spJobfragmentSkill.getSelectedIndex();
                Log.d("aaa", "onClick: befor:" + level + "-" + skill);
                if (level != 0) {
                    intent.putExtra("level", countLevelList.get(level - 1).getLevelJob());
                } else {
                    intent.putExtra("level", 0);
                }
                if (skill != 0) {
                    intent.putExtra("skill", countSkillList.get(skill - 1).getCateId());
                } else {
                    intent.putExtra("skill", 0);
                }
                Log.d("nnn", "onClick: " + listSkill.toString());
                Log.d("nnn", "onClick: " + countSkillList.toString());
                intent.putExtra("bonus", spJobfragmentBonus.getSelectedIndex());

                setResult(Constant.RESULT_CODE_SEARCH_MORE, intent);
                finish();
                break;
        }
    }
}
