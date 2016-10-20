package com.example.mmcc.mymiddleproject.bean;

/**
 * Created by Administrator on 16-10-20.
 */

public class ListHeadInfo {

    /**
     * type : doc
     * url : http://api.fengniao.com/app_ipad/news_iphone_doc_v1.php?docid=5331536
     * title : 从诺基亚到微软的昂贵“情怀”
     * pic_src : http://shougong.fn.img-space.com/g1/M00/05/D7/Cg-4rFaom2-IfugRAAC5qBp7-X8AAPNHwI7FacAALnA570.jpg
     * date : 2016-01-28 06:00:00
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5331536&isPad=1
     * web_url : http://qsy.fengniao.com/533/5331536.html
     * doc_id : 5331536
     * author : 张璋
     */

    private String type;
    private String url;
    private String title;
    private String pic_src;
    private String date;
    private int comment_page_num;
    private String comments_num;
    private String more_comment_url;
    private String web_url;
    private String doc_id;
    private String author;

    public ListHeadInfo(String title, String pic_src, String date, String web_url, String author) {
        this.title = title;
        this.pic_src = pic_src;
        this.date = date;
        this.web_url = web_url;
        this.author = author;
    }

    public ListHeadInfo() {
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public int getComment_page_num() {
        return comment_page_num;
    }

    public void setComment_page_num(int comment_page_num) {
        this.comment_page_num = comment_page_num;
    }

    public String getComments_num() {
        return comments_num;
    }

    public void setComments_num(String comments_num) {
        this.comments_num = comments_num;
    }

    public String getMore_comment_url() {
        return more_comment_url;
    }

    public void setMore_comment_url(String more_comment_url) {
        this.more_comment_url = more_comment_url;
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
