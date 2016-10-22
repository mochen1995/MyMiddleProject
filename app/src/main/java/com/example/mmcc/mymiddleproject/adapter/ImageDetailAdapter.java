package com.example.mmcc.mymiddleproject.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mylibrary.L;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglu on 2016/10/22.
 */

public class ImageDetailAdapter extends PagerAdapter{
    private Context mContext;
    private List<String> imgs_url;
    public ImageDetailAdapter(Context context,List<String> imgs_url){
        this.mContext = context;
        this.imgs_url = imgs_url;
    }
    @Override
    public int getCount() {
        return imgs_url.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        ViewGroup.LayoutParams LP = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(LP);
        Glide.with(mContext).load(imgs_url.get(position)).fitCenter().crossFade()
                .into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
         container.removeView((View) object);
    }
}
