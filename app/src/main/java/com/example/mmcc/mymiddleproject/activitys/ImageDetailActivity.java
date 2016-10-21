package com.example.mmcc.mymiddleproject.activitys;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mmcc.mymiddleproject.R;
import com.example.mmcc.mymiddleproject.bean.ImageEnjoy;
import com.example.mmcc.mymiddleproject.net.GsonUtil;
import com.example.mmcc.mymiddleproject.presenter.ImageDetailPresenter;
import com.example.mmcc.mymiddleproject.view.IImageDetailView;
import com.example.mylibrary.L;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ImageDetailActivity extends BaseActivity implements IImageDetailView {

    private ImageDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String detail_url = getIntent().getStringExtra("detail_url");
        presenter = new ImageDetailPresenter(this,this);
        presenter.RequestData(detail_url);
    }

    public static void toImageDetailActivity(Context context,String detail_url){
        Intent intent = new Intent(context, ImageDetailActivity.class);
        intent.putExtra("detail_url",detail_url);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_image_detail;
    }

    @Override
    public void getAllImages(List<ImageEnjoy> imgs) {
        L.e(imgs.toString());
    }
}
