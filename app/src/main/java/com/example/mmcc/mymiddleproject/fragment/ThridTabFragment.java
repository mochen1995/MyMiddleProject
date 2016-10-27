package com.example.mmcc.mymiddleproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mmcc.mymiddleproject.R;
import com.example.mmcc.mymiddleproject.adapter.ThirdFragment_tab3LeftAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 16-10-20.
 */

public class ThridTabFragment extends BaseFragment implements ThirdFragment_tab3LeftAdapter.OnCheckedPositionListener, AdapterView.OnItemClickListener {

    @Bind(R.id.fragment_tab3_leftList)
    ListView leftList;
    @Bind(R.id.fragment_tab3_rightList)
    ListView rightList;
    private View mView;
    private ThirdFragment_tab3LeftAdapter adapter;

    private String[][] allChildList = null;
    private ArrayAdapter<String> adapterleft;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_tab3, container, false);
            ButterKnife.bind(this, mView);

            allChildList = new String [][]{
                    getContext().getResources().getStringArray(R.array.bbsListR0),
                    getContext().getResources().getStringArray(R.array.bbsListR1),
                    getContext().getResources().getStringArray(R.array.bbsListR2),
                    getContext(). getResources().getStringArray(R.array.bbsListR3),
                    getContext().getResources().getStringArray(R.array.bbsListR4),
                    getContext(). getResources().getStringArray(R.array.bbsListR5),
                    getContext().getResources().getStringArray(R.array.bbsListR6),
            };
        }
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        adapter = new ThirdFragment_tab3LeftAdapter(getContext());
        leftList.setAdapter(adapter);
        adapter.setOnCheckedPositionListener(this);

        adapterleft = new ArrayAdapter<String>(getContext(), R.layout.fragment_tab3_rightlv_item);
        rightList.setAdapter(adapterleft);
        rightList.setOnItemClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void OnChecked(int position) {
        String[] list =  allChildList[position];
        adapterleft.clear();
        adapterleft.addAll(list);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(),adapterleft.getItem(position),Toast.LENGTH_SHORT).show();
    }
}
