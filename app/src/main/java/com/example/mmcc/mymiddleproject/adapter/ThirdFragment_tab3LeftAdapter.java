package com.example.mmcc.mymiddleproject.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.mmcc.mymiddleproject.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mmcc on 2016/10/22.
 */

public class ThirdFragment_tab3LeftAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<String> datas;
    private int[] icons = new int[]{R.mipmap.bbs_icon_0,
            R.mipmap.bbs_icon_1,R.mipmap.bbs_icon_2,
            R.mipmap.bbs_icon_3,R.mipmap.bbs_icon_4,
            R.mipmap.bbs_icon_5,R.mipmap.bbs_icon_6,};

    private Context context;

    private  ViewHolder holder;


    private int selectPos;

    public interface OnCheckedPositionListener{
        void OnChecked(int position);
    }
    private OnCheckedPositionListener listener;

    public void setOnCheckedPositionListener(OnCheckedPositionListener listener) {
        this.listener = listener;
    }

    public ThirdFragment_tab3LeftAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        datas = Arrays.asList(context.getResources().getStringArray(R.array.bbsListL));
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public String getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fragment_tab3_leftlv_item, parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.rb.setText(datas.get(position));

        Drawable drawable = ContextCompat.getDrawable(context,icons[position]);
        drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
        holder.rb.setCompoundDrawables(drawable,null,null,null);

        holder.rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    selectPos = position;
                    if (listener!=null) {
                        listener.OnChecked(selectPos);
                    }
                }
                notifyDataSetChanged();
            }
        });
        if (position==selectPos)
        {
            holder.rb.setChecked(true);
            holder.rb.setTextColor(ContextCompat.getColor(context,R.color.textChecked));
        }else{
            holder.rb.setChecked(false);
            holder.rb.setTextColor(ContextCompat.getColor(context,R.color.black));
        }

        return convertView;
    }


    static class ViewHolder {
        @Bind(R.id.fragment_tab3_leftlv_item_rb)
        RadioButton rb;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
