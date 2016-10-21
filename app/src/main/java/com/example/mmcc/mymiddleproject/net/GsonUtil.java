package com.example.mmcc.mymiddleproject.net;

import com.example.mmcc.mymiddleproject.bean.MaterialBean;
import com.example.mmcc.mymiddleproject.bean.Selection;
import com.example.mylibrary.L;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglu on 2016/10/19.
 */

public class GsonUtil {

    public static Gson gson = new Gson();

    public static<T> T jsonToObj(String json,Class<T> t){
        return gson.fromJson(json,t);
    }
    public static<T> T jsonToList(String json, Type type){
        return gson.fromJson(json, type);
    }

    public static List<Selection> parsonJson(String json){
        List<Selection> list = null;
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            list = new ArrayList<>();
            Selection sele = null;
            JSONArray arr = jsonObject.getJSONArray("280280");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject item = arr.getJSONObject(i);
                String title = item.optString("title");
                String pic_url = item.optString("pic_url");
                String date = item.optString("date");
                String author = item.optString("author");
                String web_url = item.optString("web_url");
                sele = new Selection(title,pic_url,date,author,web_url);
                if (i==1)// 第二个作为第一个的子链
                {
                    list.get(0).setSelection(sele);
                }
                else  //将第一个加入列表
                {
                    list.add(sele);
                }
            }
            JSONArray jsonArray = jsonObject.getJSONArray("160120");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);
                String title = item.optString("title");
                String pic_url = item.optString("pic_url");
                String date = item.optString("date");
                String author = item.optString("author");
                String web_url = item.optString("web_url");
                sele = new Selection(title,pic_url,date,author,web_url);
                list.add(sele);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }


    public static List<MaterialBean> parsonCommonJson(String json){
        List<MaterialBean> list = null;
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            list = new ArrayList<>();
            MaterialBean sele = null;
            JSONArray jsonArray = jsonObject.getJSONArray("list");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);
                String title = item.optString("title");
                String pic_url = item.optString("pic_url");
                String doc_url = item.optString("doc_url");
                String web_url = item.optString("web_url");
                String detail_url = item.optString("detail_url");
                sele = new MaterialBean(title,pic_url,doc_url,web_url,detail_url);
                if (i%2==1)// 第二个作为第一个的子链
                {
                    list.get(list.size()-1).setBean(sele);
                }
                else//将第一个加入列表
                {
                    list.add(sele);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
