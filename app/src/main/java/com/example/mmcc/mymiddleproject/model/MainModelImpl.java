package com.example.mmcc.mymiddleproject.model;

import android.util.Log;

/**
 * Created by Administrator on 16-10-19.
 */

public class MainModelImpl implements IMainModel {
    @Override
    public void saveDatas(String data) {
        Log.i("tag","保存了数据");
    }

    @Override
    public String getDatas() {
      return "这是本地获取的数据";
    }
}
