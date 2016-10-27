package com.example.mmcc.mymiddleproject.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.mmcc.mymiddleproject.R;
import com.example.mmcc.mymiddleproject.fragment.FirstTabFragment;
import com.example.mmcc.mymiddleproject.fragment.ForthTabFragment;
import com.example.mmcc.mymiddleproject.fragment.SecondTabFragment;
import com.example.mmcc.mymiddleproject.fragment.ThridTabFragment;
import com.example.mmcc.mymiddleproject.view.IMainView;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements IMainView, RadioGroup.OnCheckedChangeListener {


    @Bind(R.id.activity_main_framelayout)
    FrameLayout framLayout;
    @Bind(R.id.activity_main_rg)
    RadioGroup rg;
    @Bind(R.id.activity_main_rb1)
    RadioButton rb1;
    @Bind(R.id.activity_main_rb2)
    RadioButton rb2;
    @Bind(R.id.activity_main_rb3)
    RadioButton rb3;
    @Bind(R.id.activity_main_rb4)
    RadioButton rb4;
    private FragmentManager fragmentManager;

    private Fragment currentFragment;
    private Fragment firstTabFragment,secondTabFragment,thridTabFragment,forthTabFragment;
    private RadioButton curRb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rg.setOnCheckedChangeListener(this);
        rb1.animate().scaleX(1.3f).scaleY(1.3f).translationY(-20)
                .setDuration(500).start();
        curRb = rb1;
        initFragment();
    }

    private void initFragment() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
         firstTabFragment = new FirstTabFragment();
         secondTabFragment = new SecondTabFragment();
         thridTabFragment = new ThridTabFragment();
         forthTabFragment = new ForthTabFragment();
        transaction.add(R.id.activity_main_framelayout,firstTabFragment);
        transaction.add(R.id.activity_main_framelayout,secondTabFragment);
        transaction.add(R.id.activity_main_framelayout,thridTabFragment);
        transaction.add(R.id.activity_main_framelayout,forthTabFragment);
        transaction.hide(secondTabFragment);
        transaction.hide(thridTabFragment);
        transaction.hide(forthTabFragment);
        currentFragment = firstTabFragment;
        transaction.commit();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void OnRequestSucceed(Object obj) {

    }

    @Override
    public void OnRequestFailured(String err) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        initRadioTextColor();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(currentFragment);
        switch (checkedId) {
            case R.id.activity_main_rb1:
                animation(rb1);
                rb1.setTextColor(ContextCompat.getColor(this,R.color.tabTextColor_check));
                transaction.show(firstTabFragment);
                currentFragment = firstTabFragment;
                break;
            case R.id.activity_main_rb2:
                animation(rb2);
                rb2.setTextColor(ContextCompat.getColor(this,R.color.tabTextColor_check));
                //transaction.replace(R.id.activity_main_framelayout,new SecondTabFragment());
                transaction.show(secondTabFragment);
                currentFragment = secondTabFragment;
                break;
            case R.id.activity_main_rb3:
                animation(rb3);
                rb3.setTextColor(ContextCompat.getColor(this,R.color.tabTextColor_check));
               // transaction.replace(R.id.activity_main_framelayout,new ThridTabFragment());
                transaction.show(thridTabFragment);
                currentFragment = thridTabFragment;
                break;
            case R.id.activity_main_rb4:
                animation(rb4);
                rb4.setTextColor(ContextCompat.getColor(this,R.color.tabTextColor_check));
               // transaction.replace(R.id.activity_main_framelayout,new ForthTabFragment());
                transaction.show(forthTabFragment);
                currentFragment = forthTabFragment;
                break;
        }
        transaction.commit();
    }

    private void animation(RadioButton rb) {
        curRb.animate().scaleX(1).scaleY(1).translationY(0)
                .setDuration(500).start(); //恢复上一次动画

        rb.animate().scaleX(1.3f).scaleY(1.3f).translationY(-20)
                .setDuration(500).start();
        curRb = rb;


    }

    private void initRadioTextColor() {
        rb1.setTextColor(ContextCompat.getColor(this,R.color.tabTextColor_normal));
        rb2.setTextColor(ContextCompat.getColor(this,R.color.tabTextColor_normal));
        rb3.setTextColor(ContextCompat.getColor(this,R.color.tabTextColor_normal));
        rb4.setTextColor(ContextCompat.getColor(this,R.color.tabTextColor_normal));
    }
}
