package com.example.mmcc.mymiddleproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.mmcc.mymiddleproject.R;
import com.example.mmcc.mymiddleproject.util.ScreenUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 16-10-20.
 */

public class FirstTabFragment extends Fragment {

    @Bind(R.id.scroll_title_bar_rb1)
    RadioButton rb1;
    @Bind(R.id.scroll_title_bar_rb2)
    RadioButton rb2;
    @Bind(R.id.scroll_title_bar_rb3)
    RadioButton rb3;
    @Bind(R.id.scroll_title_bar_rb4)
    RadioButton rb4;
    @Bind(R.id.scroll_title_bar_rg)
    RadioGroup rg;
    @Bind(R.id.scroll_title_bar_line)
    View line;
    @Bind(R.id.scroll_title_bar_scrollview)
    HorizontalScrollView scrollView;
    @Bind(R.id.fragment_tab1_vp)
    ViewPager fragmentTab1Vp;
    private View mView;

    private int ScreenWidth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_tab1, container, false);
        ButterKnife.bind(this, mView);
        initView();
        return mView;
    }

    private void initView() {
        initScrollbar();


    }

    private void initScrollbar() {
        ScreenWidth = ScreenUtil.getScreenWidth(getContext());
        int childCount = rg.getChildCount();
        RadioButton rb = null;
        for (int i = 0; i < childCount; i++) {
            rb = (RadioButton) rg.getChildAt(i);
            rb.getLayoutParams().width = ScreenWidth / 4;
        }
        line.getLayoutParams().width = ScreenWidth/ 4;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
