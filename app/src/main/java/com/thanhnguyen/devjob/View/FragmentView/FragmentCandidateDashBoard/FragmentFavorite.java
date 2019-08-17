package com.thanhnguyen.devjob.View.FragmentView.FragmentCandidateDashBoard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.thanhnguyen.devjob.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentFavorite extends Fragment {

    @BindView(R.id.spinnerNumber)
    Spinner spinnerNumber;
    @BindView(R.id.spinnerSort)
    Spinner spinnerSort;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite,container,false);
        ButterKnife.bind(this,view);
        setUI();
        return view;
    }

    private void setUI() {
        ArrayAdapter<String> adapterNum = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.array_number));
        adapterNum.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNumber.setAdapter(adapterNum);

        ArrayAdapter<String> adapterSort = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.array_sort));
        adapterSort.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSort.setAdapter(adapterSort);
    }
}
