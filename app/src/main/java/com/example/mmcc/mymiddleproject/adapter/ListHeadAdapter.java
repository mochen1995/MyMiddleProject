package com.example.mmcc.mymiddleproject.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mmcc.mymiddleproject.R;
import com.example.mmcc.mymiddleproject.bean.ListHeadInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-10-20.
 */

public class ListHeadAdapter extends PagerAdapter {

    public interface OnHeadViewClickListener{
        void OnClick();
    }
    private OnHeadViewClickListener listener;

    public void setOnHeadViewClickListener(OnHeadViewClickListener listener) {
        this.listener = listener;
    }

    private List<ListHeadInfo> datas;

    private LayoutInflater inflater;
    private Context context;

    public ListHeadAdapter(Context context) {
        datas = new ArrayList<>();
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public ListHeadInfo getItem(int position){
        return datas.get(position);
    }

    public void addData(List<ListHeadInfo> datas) {
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    public void clear() {
        datas.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.list_head_item, null);

        ImageView img = (ImageView) view.findViewById(R.id.list_head_item_img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null) {
                    listener.OnClick();
                }
            }
        });
        TextView text = (TextView) view.findViewById(R.id.list_head_item_text);
        text.setText(datas.get(position).getTitle());
        Glide.with(context)
                .load(datas.get(position).getPic_src())
                .centerCrop()
                .placeholder(R.mipmap.big_loadpic_full_listpage)
                .into(img);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
