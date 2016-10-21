package com.example.mmcc.mymiddleproject.bean;

/**
 * Created by Administrator on 16-10-20.
 */

public class Selection {

    public Selection(String title, String pic_url, String date, String author, String web_url) {
        this.title = title;
        this.pic_url = pic_url;
        this.date = date;
        this.author = author;
        this.web_url = web_url;
    }


    @Override
    public String toString() {
        return "Selection{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", author='" + author + '\'' +
                ", web_url='" + web_url + '\'' +
                '}';
    }

    public Selection() {
    }

    private Selection selection;

    public Selection getSelection() {
        return selection;
    }

    public void setSelection(Selection selection) {
        this.selection = selection;
    }

    /**
     * title : 全球最快对焦相机 索尼黑卡RX100V试用
     * pic_url : http://img2.fengniao.com/product/157_160x120/602/ce3l3HNXT5zjE.jpg
     * date : 2016-10-20 06:00:00
     * author : 王超
     * doc_url : http://api.fengniao.com/app_ipad/news_doc.php?docid=5339807&isPad=1
     * doc_id : 5339807
     * web_url : http://qicai.fengniao.com/533/5339807.html
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5339807&isPad=1
     */

    private String title;
    private String pic_url;
    private String date;
    private String author;
    private String doc_url;
    private String doc_id;
    private String web_url;
    private int comment_page_num;
    private String comments_num;
    private String more_comment_url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDoc_url() {
        return doc_url;
    }

    public void setDoc_url(String doc_url) {
        this.doc_url = doc_url;
    }

    public String getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
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
}
