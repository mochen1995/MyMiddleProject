package com.example.mmcc.mymiddleproject.url;

/**
 * Created by Administrator on 16-10-20.
 */

public class MyUrl {
    //资讯的，精选api
    public static String getSelectUrl(int page){
        return String.format("http://api.fengniao.com/app_ipad/news_jingxuan.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&page=%d",page);
    }
    //精选的头部视图
    public static String getSelectHeadUrl(){
        return "http://api.fengniao.com/app_ipad/focus_pic.php?mid=19928?appImei=000000000000000&osType=Android&osVersion=4.1.1";
    }
    //咨询的，器材api
    public static String getMaterialUrl(int page){
        return String.format("http://api.fengniao.com/app_ipad/news_list.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&cid=296&page=%d",page);
    }
    public static String getMaterialHeadUrl(){
        return "http://api.fengniao.com/app_ipad//focus_pic.php?&mid=19929?appImei=000000000000000&osType=Android&osVersion=4.1.1";
    }
   //咨询的，影像
    public static String getIconographyUrl(int page){
        return String.format("http://api.fengniao.com/app_ipad/news_list.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&cid=192&page=%d",page);
    }
    public static String getIconographyHeadUrl(){
        return "http://api.fengniao.com/app_ipad//focus_pic.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&mid=19930";
    }

    //学院广告/app_ipad//focus_pic.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&mid=19931
    //学院api.fengniao.com/app_ipad/news_list.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&cid=190&page=1
    public static String getSchoolUrl(int page)
    {
        return String.format("http://api.fengniao.com/app_ipad/news_list.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&cid=190&page=%d",page);
    }
    public static String getSchoolHeadUrl(){
        return "http://api.fengniao.com//app_ipad//focus_pic.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&mid=19931";
    }
    //图鉴 人像
    public static String getPortraitUrl(int page)
    {
        return String.format("http://api.fengniao.com/app_ipad/pic_bbs_list_v2.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&fid=101&page=%d",page);
    }
    //风光
    public static String getSceneryUrl(int page)
    {
        return String.format("http://api.fengniao.com/app_ipad/pic_bbs_list_v2.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&fid=125&page=%d",page);
    }
    //生态
    public static String getZoologyUrl(int page)
    {
        return String.format("http://api.fengniao.com/app_ipad/pic_bbs_list_v2.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&fid=16&page=%d",page);

    }
    //生态
    public static String getDigitalUrl(int page)
    {
        return String.format("http://api.fengniao.com//app_ipad/pic_bbs_list_v2.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&fid=24&page=%d",page);

    }

}
