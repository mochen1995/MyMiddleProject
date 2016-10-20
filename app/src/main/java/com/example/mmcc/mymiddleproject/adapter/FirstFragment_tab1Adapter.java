package com.example.mmcc.mymiddleproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mmcc.mymiddleproject.R;
import com.example.mmcc.mymiddleproject.bean.Selection;
import com.example.mylibrary.L;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 16-10-20.
 */

public class FirstFragment_tab1Adapter extends BaseAdapter {

    private List<Selection> datas;
    private LayoutInflater inflater;
    private Context context;

    public FirstFragment_tab1Adapter(Context context) {
        inflater = LayoutInflater.from(context);
        datas = new ArrayList<>();
        this.context = context;
    }

    public void addDatas(List<Selection> datas) {
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
    public Selection getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Selection selectionInfo = datas.get(position);
        Tab1Holder holder = null;
        if(convertView==null)
        {
            convertView = inflater.inflate(R.layout.fragment_tab1_lvitem, null);
            holder = new Tab1Holder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (Tab1Holder) convertView.getTag();
        }

        holder.title.setText(selectionInfo.getTitle());
        holder.date.setText(selectionInfo.getDate());
        holder.author.setText(selectionInfo.getAuthor());
        L.e("图片url = "+selectionInfo.getPic_url());
        Glide.with(context).
                load(selectionInfo.getPic_url()).
                crossFade().
                centerCrop().
                placeholder(R.mipmap.big_loadpic_full_listpage).
                into(holder.img);
        return convertView;
    }

    static class Tab1Holder {
        @Bind(R.id.fragment_tab1_lvitem_title)
        TextView title;
        @Bind(R.id.fragment_tab1_lvitem_date)
        TextView date;
        @Bind(R.id.fragment_tab1_lvitem_author)
        TextView author;
        @Bind(R.id.fragment_tab1_lvitem_img)
        ImageView img;
        Tab1Holder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
