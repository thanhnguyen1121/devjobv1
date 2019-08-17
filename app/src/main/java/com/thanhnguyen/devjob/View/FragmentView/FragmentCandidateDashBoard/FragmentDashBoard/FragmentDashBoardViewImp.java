package com.thanhnguyen.devjob.View.FragmentView.FragmentCandidateDashBoard.FragmentDashBoard;

import com.thanhnguyen.devjob.Model.ModelDashboard.Datum;

import java.util.List;

public interface FragmentDashBoardViewImp {
    void getList(List<Datum> datumList);
    void getErr(String error);
}
