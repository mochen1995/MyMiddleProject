package com.example.mmcc.mymiddleproject.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.mmcc.mymiddleproject.activitys.DetailActivity;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by mmcc on 2016/10/27.
 */

public class SharedPreferenceUtil {
    private static SharedPreferences SP;

    /**
     *
     * @param context 环境
     * @param key 收藏页面的url
     * @param value 收藏页面的title
     */
    public static void putData(Context context,String key,String value){
        if (SP==null)
        SP = context.getSharedPreferences("mysp", context.MODE_PRIVATE);
        SharedPreferences.Editor edit = SP.edit();
        edit.putString(key,value);
        edit.apply();

        String contains = SP.getString(key,"-1");
        Log.i("tag","存的标题为:"+contains);
    }
    public static void remove(Context context,String key){
        if (SP==null)
        SP = context.getSharedPreferences("mysp", context.MODE_PRIVATE);
        SharedPreferences.Editor edit = SP.edit();
        edit.remove(key);
        edit.apply();

    }
    public static Map<String, ?> getAllData(Context context){
        if (SP==null)
        SP = context.getSharedPreferences("mysp", context.MODE_PRIVATE);
        Map<String, ?> all = SP.getAll();
        return all;
    }
    public static boolean isSaved(Context context,String key){
        Map<String, ?> allData = getAllData(context);
        Set<? extends Map.Entry<String, ?>> entries = allData.entrySet();
        Iterator<? extends Map.Entry<String, ?>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ?> next = iterator.next();
            if (key.equals(next.getKey()))
            {
                return true;
            }
        }

        return false;
    }
}
