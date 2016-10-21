package com.example.mmcc.mymiddleproject.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mmcc.mymiddleproject.R;
import com.example.mmcc.mymiddleproject.bean.MaterialBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 16-10-20.
 */

public class FirstFragment_tab2Adapter extends BaseAdapter {

    private List<MaterialBean> datas;
    private LayoutInflater inflater;
    private Context context;

    public interface OnTwoLayoutClickListener{
        void OnLeftClick(String webUrl);
        void OnRightClick(String webUrl);
    }

    private OnTwoLayoutClickListener listener;

    public void setOnTwoLayoutClickListener(OnTwoLayoutClickListener listener) {
        this.listener = listener;
    }

    public FirstFragment_tab2Adapter(Context context) {
        inflater = LayoutInflater.from(context);
        datas = new ArrayList<>();
        this.context = context;
    }

    public void addDatas(List<MaterialBean> datas) {
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    public void clearDatas() {
        datas.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public MaterialBean getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final MaterialBean materialBean = datas.get(position);
        Tab2Holder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fragment_tab1_lvitem_2, null);
            holder = new Tab2Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Tab2Holder) convertView.getTag();
        }

            holder.text1.setText(materialBean.getTitle());
            Glide.with(context).
                    load(materialBean.getPic_url()).
                    crossFade().
                    centerCrop().
                    placeholder(R.mipmap.big_loadpic_full_listpage).
                    into(holder.img1);
            holder.Leftcard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener!=null)
                        listener.OnLeftClick(materialBean.getWeb_url());
                }
            });

        final MaterialBean bean2 = materialBean.getBean();
        holder.text2.setText(bean2.getTitle());
        Glide.with(context).
                load(bean2.getPic_url()).
                crossFade().
                centerCrop().
                placeholder(R.mipmap.big_loadpic_full_listpage).
                into(holder.img2);

        holder.Rightcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null)
                    listener.OnRightClick(bean2.getWeb_url());
            }
        });
        return convertView;
    }

    static class Tab2Holder {
        @Bind(R.id.lvitem2_img1)
        ImageView img1;
        @Bind(R.id.lvitem2_text1)
        TextView text1;
        @Bind(R.id.lvitem2_leftcard)
        CardView Leftcard;
        @Bind(R.id.lvitem2_img2)
        ImageView img2;
        @Bind(R.id.lvitem2_text2)
        TextView text2;
        @Bind(R.id.lvitem2_rightcard)
        CardView Rightcard;

        Tab2Holder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
