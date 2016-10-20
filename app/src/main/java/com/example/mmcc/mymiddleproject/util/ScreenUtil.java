package com.example.mmcc.mymiddleproject.util;

import android.content.Context;

/**
 * Created by Administrator on 16-10-20.
 */

public class ScreenUtil {

    public static int getScreenWidth(Context context){
       return context.getResources().getDisplayMetrics().widthPixels;
    }
    public static int getScreenHeight(Context context)
    {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
}
