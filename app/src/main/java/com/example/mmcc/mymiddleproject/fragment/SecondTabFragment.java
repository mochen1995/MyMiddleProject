package com.example.mmcc.mymiddleproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.mmcc.mymiddleproject.fragment.tabfragment.*;

import com.example.mmcc.mymiddleproject.R;
import com.example.mmcc.mymiddleproject.adapter.MyFragmentPagerAdapter;
import com.example.mmcc.mymiddleproject.presenter.FragmentPresenter;
import com.example.mmcc.mymiddleproject.util.ScreenUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 16-10-20.
 */

public class SecondTabFragment extends BaseFragment  implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

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
    @Bind(R.id.fragment_tab2_vp)
    ViewPager fragmentTab1Vp;
    private View mView;

    private int ScreenWidth;


    private List<Fragment> fragments;
    private FragmentPresenter presenter;
    private int currentPage=1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_tab2, container, false);
        ButterKnife.bind(this, mView);
        initView();

        return mView;
    }

    private void initView() {
        initScrollbar(); //初始化顶部滑动条
        initScrollbarText();
        fragments = new ArrayList<>();
        fragments.add(new SecondFragment_tab1());
        fragments.add(new SecondFragment_tab2());
        fragments.add(new SecondFragment_tab3());
        fragments.add(new SecondFragment_tab4());

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getFragmentManager(), fragments);
        fragmentTab1Vp.setAdapter(adapter);
        fragmentTab1Vp.addOnPageChangeListener(this);

        rg.setOnCheckedChangeListener(this);
    }

    private void initScrollbarText() {
        rb1.setText("人像");
        rb2.setText("风光");
        rb3.setText("生态");
        rb4.setText("数码");
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

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) line.getLayoutParams();
        lp.leftMargin = (int) ((position+positionOffset)*(ScreenWidth/4));
        line.setLayoutParams(lp);
    }

    @Override
    public void onPageSelected(int position) {
        initScrollbarTextColor();
        switch (position)
        {
            case 0:
                rb1.setAlpha(1);
                break;
            case 1:
                rb2.setAlpha(1);
                break;
            case 2:
                rb3.setAlpha(1);
                break;
            case 3:
                rb4.setAlpha(1);
                break;
        }
    }

    private void initScrollbarTextColor() {
        int childCount = rg.getChildCount();
        RadioButton rb = null;
        for (int i = 0; i < childCount; i++) {
            rb = (RadioButton) rg.getChildAt(i);
            rb.setAlpha(0.6f);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId)
        {
            case R.id.scroll_title_bar_rb1:
                fragmentTab1Vp.setCurrentItem(0,true);
                break;
            case R.id.scroll_title_bar_rb2:
                fragmentTab1Vp.setCurrentItem(1,true);
                break;
            case R.id.scroll_title_bar_rb3:
                fragmentTab1Vp.setCurrentItem(2,true);
                break;
            case R.id.scroll_title_bar_rb4:
                fragmentTab1Vp.setCurrentItem(3,true);
                break;
        }
    }
}
