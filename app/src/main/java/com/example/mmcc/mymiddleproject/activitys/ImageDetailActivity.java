package com.example.mmcc.mymiddleproject.activitys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mmcc.mymiddleproject.R;
import com.example.mmcc.mymiddleproject.adapter.ImageDetailAdapter;
import com.example.mmcc.mymiddleproject.bean.ImageEnjoy;
import com.example.mmcc.mymiddleproject.presenter.ImageDetailPresenter;
import com.example.mmcc.mymiddleproject.view.IImageDetailView;
import com.example.mylibrary.L;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class ImageDetailActivity extends BaseActivity implements IImageDetailView, ViewPager.OnPageChangeListener {

    @Bind(R.id.activity_detail_toolbar)
    Toolbar toolbar;
    @Bind(R.id.activity_image_detail_describe)
    TextView describe;
    @Bind(R.id.activity_image_detail_count)
    TextView page;
    @Bind(R.id.activity_image_detail_vp)
    ViewPager vp;
    private ImageDetailPresenter presenter;

    private ImageEnjoy.ImageDetailBean imgInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String detail_url = getIntent().getStringExtra("detail_url");
        presenter = new ImageDetailPresenter(this, this);
        presenter.RequestData(detail_url);

        initView();
    }

    private void initView() {
        vp.addOnPageChangeListener(this);
      /*  vp.setPageTransformer(true, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                if(position<0)
                {
                    page.setScaleX(0.5f);
                    page.setScaleY(0.5f);
                }else if (position<1){

                }
            }
        });*/
        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.white));
    }

    public static void toImageDetailActivity(Context context, String detail_url) {
        Intent intent = new Intent(context, ImageDetailActivity.class);
        intent.putExtra("detail_url", detail_url);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_image_detail;
    }

    @Override
    public void getAllImages(List<ImageEnjoy> imgs) {
        createImageDetailBean(imgs);
        describe.setText(imgInfo.getTitle());
        page.setText("1/"+imgInfo.getPage());
        vp.setAdapter(new ImageDetailAdapter(this,imgInfo.getImgs()));
    }

    private void createImageDetailBean(List<ImageEnjoy> imgs) {
        imgInfo = new ImageEnjoy.ImageDetailBean();
        imgInfo.setPage(String.valueOf(imgs.size())); //图片的总页数
        List<String> imgs_url = new ArrayList<>();
        for (int i = 0; i < imgs.size(); i++) {
            ImageEnjoy imageEnjoy = imgs.get(i);
            imgInfo.setTitle(imageEnjoy.getDoc_title());//图片的详情title
            imgs_url.add(imageEnjoy.getPic().getGq());
        }
        imgInfo.setImgs(imgs_url);  //所有图片的集合
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
         page.setText((position+1)+"/"+imgInfo.getPage());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
