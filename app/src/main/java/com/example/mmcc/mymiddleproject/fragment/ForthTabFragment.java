package com.example.mmcc.mymiddleproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mmcc.mymiddleproject.R;
import com.example.mmcc.mymiddleproject.activitys.SaveActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 16-10-20.
 */

public class ForthTabFragment extends BaseFragment {

    @Bind(R.id.fragment_tab4_save)
    TextView Save;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab4, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(getContext(), SaveActivity.class));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
