package com.example.mmcc.mymiddleproject.activitys;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mmcc.mymiddleproject.R;
import com.example.mmcc.mymiddleproject.presenter.MainPresenter;
import com.example.mmcc.mymiddleproject.view.IMainView;

public class MainActivity extends BaseActivity implements IMainView{


    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this,this);
        mainPresenter.RequestData("www.baidu.com");
    }
    @Override
    public void OnRequestSucceed(Object obj) {

    }

    @Override
    public void OnRequestFailured(String err) {

    }
}
