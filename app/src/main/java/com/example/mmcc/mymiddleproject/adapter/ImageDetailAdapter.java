package com.example.mmcc.mymiddleproject.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.view.menu.MenuView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mmcc.mymiddleproject.R;
import com.example.mmcc.mymiddleproject.util.SDUtil;
import com.example.mmcc.mymiddleproject.util.ScreenUtil;
import com.example.mylibrary.L;

import java.io.ByteArrayOutputStream;
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
        final ImageView imageView = new ImageView(mContext);
        ViewGroup.LayoutParams LP = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(LP);
        Glide.with(mContext).load(imgs_url.get(position)).fitCenter().crossFade()
                .into(imageView);

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final Drawable drawable = imageView.getDrawable();
                TextView textView = new TextView(mContext);
                ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                textView.setLayoutParams(lp);
                textView.setText("保存图片");
                textView.setBackgroundColor(Color.GRAY);
                textView.setTextColor(Color.RED);

                final PopupWindow popupWindow = new PopupWindow(textView, lp.width, lp.height+100);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.setFocusable(true);

                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bitmap bitmap = convertToBitmap(drawable);
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.JPEG,100,bos);
                        boolean b = SDUtil.DownLoadImage(bos);
                        if (b)
                        {
                           popupWindow.dismiss();
                            Toast.makeText(mContext,"保存成功:"+SDUtil.getPath(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                popupWindow.showAsDropDown(v, ScreenUtil.getScreenWidth(mContext)/2,-ScreenUtil.getScreenHeight(mContext)/2);
                return false;
            }
        });




        container.addView(imageView);
        return imageView;
    }

    private Bitmap convertToBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
         container.removeView((View) object);
    }
}
