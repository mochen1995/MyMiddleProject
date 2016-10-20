package com.example.mmcc.mymiddleproject.url;

/**
 * Created by Administrator on 16-10-20.
 */

public class MyUrl {
    //资讯的，精选api
    public static String getSelectUrl(int page){
        return String.format("http://api.fengniao.com/app_ipad/news_jingxuan.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&page=%d",page);
    }
}
