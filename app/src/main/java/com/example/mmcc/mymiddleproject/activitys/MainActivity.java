package com.example.mmcc.mymiddleproject.activitys;

import android.os.Bundle;
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
import com.example.mmcc.mymiddleproject.presenter.MainPresenter;
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
    private MainPresenter mainPresenter;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainPresenter = new MainPresenter(this, this);
        rg.setOnCheckedChangeListener(this);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.activity_main_framelayout,new FirstTabFragment());
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
        switch (checkedId) {
            case R.id.activity_main_rb1:
                rb1.setTextColor(ContextCompat.getColor(this,R.color.tabTextColor_check));
                transaction.replace(R.id.activity_main_framelayout,new FirstTabFragment());
                break;
            case R.id.activity_main_rb2:
                rb2.setTextColor(ContextCompat.getColor(this,R.color.tabTextColor_check));
                transaction.replace(R.id.activity_main_framelayout,new SecondTabFragment());

                break;
            case R.id.activity_main_rb3:
                rb3.setTextColor(ContextCompat.getColor(this,R.color.tabTextColor_check));
                transaction.replace(R.id.activity_main_framelayout,new ThridTabFragment());

                break;
            case R.id.activity_main_rb4:
                rb4.setTextColor(ContextCompat.getColor(this,R.color.tabTextColor_check));
                transaction.replace(R.id.activity_main_framelayout,new ForthTabFragment());
                break;
        }
        transaction.commit();
    }

    private void initRadioTextColor() {
        rb1.setTextColor(ContextCompat.getColor(this,R.color.tabTextColor_normal));
        rb2.setTextColor(ContextCompat.getColor(this,R.color.tabTextColor_normal));
        rb3.setTextColor(ContextCompat.getColor(this,R.color.tabTextColor_normal));
        rb4.setTextColor(ContextCompat.getColor(this,R.color.tabTextColor_normal));
    }
}
