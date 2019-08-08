package com.thanhnguyen.devjob.View.FragmentView.FragmentJob;

import com.thanhnguyen.devjob.Model.ModelJob.Cate;
import com.thanhnguyen.devjob.Model.ModelJob.Company;
import com.thanhnguyen.devjob.Model.ModelJob.CountLevel;
import com.thanhnguyen.devjob.Model.ModelJob.CountSalary1;
import com.thanhnguyen.devjob.Model.ModelJob.CountSkill;
import com.thanhnguyen.devjob.Model.ModelJob.JobItem;

import java.util.List;

public interface FragmentJobViewImp {
    void getJobItems(List<JobItem> jobItemList, List<Company> companyList,
                     List<CountLevel> countLevelList, List<CountSkill> countSkillList
    );

    void getJobItemsFilter(List<JobItem> jobItemList, List<Company> companyList, List<CountSkill> countSkillList);
}
