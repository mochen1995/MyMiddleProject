package com.example.mmcc.mymiddleproject.activitys;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mmcc.mymiddleproject.R;
import com.example.mmcc.mymiddleproject.presenter.MainPresenter;
import com.example.mmcc.mymiddleproject.view.IMainView;

public class MainActivity extends BaseActivity implements IMainView{

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainPresenter mainPresenter = new MainPresenter(this);
        mainPresenter.RequestData("www.sdffds.dsfdsf/dsfdsf");
        tv = (TextView) findViewById(R.id.tv);

    }

    @Override
    public void setText(String text) {
        tv.setText(text);
    }

    @Override
    public void setImage(Bitmap bitmap) {

    }
}
