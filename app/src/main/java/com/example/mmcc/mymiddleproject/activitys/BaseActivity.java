package com.example.mmcc.mymiddleproject.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mmcc.mymiddleproject.R;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 16-10-19.
 */

public abstract class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    protected abstract int getLayoutId();

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.activity_in,R.anim.activity_out);
    }

    @Override
    public void finish() {
        super.finish();
    //    overridePendingTransition(R.anim.activity_in,R.anim.activity_out);
    }
}
