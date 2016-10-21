package com.example.mmcc.mymiddleproject.bean;

/**
 * Created by Administrator on 16-10-20.
 */

public class ListHeadInfo {


    /**
     * type : doc
     * url : http://api.fengniao.com/app_ipad/news_iphone_doc_v1.php?docid=5330999
     * title : 传统与现代的碰撞 适马18-35mm行摄北京
     * pic_src : http://shougong.fn.img-space.com/g1/M00/05/BD/Cg-4rFafYcWIWXtYAAF8fcZdproAAPDTQDjYDYAAXyV380.jpg
     * date : 2016-01-21 06:29:33
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5330999&isPad=1
     * web_url : http://qicai.fengniao.com/533/5330999.html
     * doc_id : 5330999
     * author : 王子昂
     */

    private String title;
    private String pic_src;
    private String date;
    private String web_url;
    private String doc_id;
    private String author;

    @Override
    public String toString() {
        return "ListHeadInfo{" +
                "title='" + title + '\'' +
                ", pic_src='" + pic_src + '\'' +
                ", date='" + date + '\'' +
                ", web_url='" + web_url + '\'' +
                ", author='" + author + '\'' +
                '}';
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic_src() {
        return pic_src;
    }

    public void setPic_src(String pic_src) {
        this.pic_src = pic_src;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
