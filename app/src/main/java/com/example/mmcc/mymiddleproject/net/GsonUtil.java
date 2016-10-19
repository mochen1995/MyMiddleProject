package com.example.mmcc.mymiddleproject.net;

import com.google.gson.Gson;

import java.lang.reflect.Type;

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
}
