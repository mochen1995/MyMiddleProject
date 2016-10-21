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

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 16-10-20.
 */

public class FirstFragment_tab1Adapter extends BaseAdapter {

    public interface OnTwoLayoutClickListener{
        void OnLeftLayoutClick(int position);
        void OnRightLayoutClick(int position);
    }


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
    public int getItemViewType(int position) {
        if (position % 5 == 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        Selection selectionInfo = datas.get(position);

        Tab1Holder holder = null;
        Tab1Holder_2 holder_2 = null;
        if (convertView == null) {
            switch (type) {
                case 0: //双布局
                    convertView = inflater.inflate(R.layout.fragment_tab1_lvitem_2, null);
                    holder_2 = new Tab1Holder_2(convertView);
                    convertView.setTag(holder_2);
                    break;
                case 1:
                    //list列表布局
                    convertView = inflater.inflate(R.layout.fragment_tab1_lvitem, null);
                    holder = new Tab1Holder(convertView);
                    convertView.setTag(holder);
                    break;
            }
        } else {
            switch (type) {
                case 0:
                    holder_2 = (Tab1Holder_2) convertView.getTag();
                    break;
                case 1:
                    holder = (Tab1Holder) convertView.getTag();
                    break;
            }
        }

        switch (type) {
            case 0:
                Selection selection2 = selectionInfo.getSelection();
                holder_2.text1.setText(selectionInfo.getTitle());
                Glide.with(context).load(selectionInfo.getPic_url())
                        .centerCrop().placeholder(R.mipmap.big_loadpic_full_listpage)
                        .into(holder_2.img1);

                if(selection2!=null)
                {
                    holder_2.text2.setText(selection2.getTitle());
                    Glide.with(context).load(selection2.getPic_url())
                            .centerCrop().placeholder(R.mipmap.big_loadpic_full_listpage)
                            .into(holder_2.img2);
                }


                break;
            case 1:
                holder.title.setText(selectionInfo.getTitle());
                holder.date.setText(selectionInfo.getDate());
                holder.author.setText(selectionInfo.getAuthor());
                Glide.with(context).
                        load(selectionInfo.getPic_url()).
                        crossFade().
                        centerCrop().
                        placeholder(R.mipmap.big_loadpic_full_listpage).
                        into(holder.img);
                break;
        }


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

    static class Tab1Holder_2 {
        @Bind(R.id.lvitem2_img1)
        ImageView img1;
        @Bind(R.id.lvitem2_text1)
        TextView text1;
        @Bind(R.id.lvitem2_img2)
        ImageView img2;
        @Bind(R.id.lvitem2_text2)
        TextView text2;

        Tab1Holder_2(View view) {
            ButterKnife.bind(this, view);
        }
    }


}
