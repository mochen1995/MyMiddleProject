package com.example.mmcc.mymiddleproject.bean;

/**
 * Created by zhanglu on 2016/10/21.
 */

public class MaterialBean {
    /**
     * 复用了 器材，影像，学院的数据模型
     */

    private String title;
    private String pic_url;
    private String doc_url;
    private String web_url;
    private MaterialBean bean;


    /**
     * 图赏需要的数据
     * date : 1476763761
     * detail_url : http://api.fengniao.com/app_ipad/pic_bbs_detail.php?id=9350426&fid=101
     */
    private String detail_url;


    @Override
    public String toString() {
        return "MaterialBean{" +
                "title='" + title + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", doc_url='" + doc_url + '\'' +
                ", web_url='" + web_url + '\''+
                ", detail_url'"+detail_url+
                '}';
    }

    public MaterialBean getBean() {
        return bean;
    }

    public void setBean(MaterialBean bean) {
        this.bean = bean;
    }

    public MaterialBean(String title, String pic_url, String doc_url, String web_url,String detail_url) {
        this.title = title;
        this.pic_url = pic_url;
        this.doc_url = doc_url;
        this.web_url = web_url;
        this.detail_url = detail_url;
    }

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

    public String getDoc_url() {
        return doc_url;
    }

    public void setDoc_url(String doc_url) {
        this.doc_url = doc_url;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getDetail_url() {
        return detail_url;
    }

    public void setDetail_url(String detail_url) {
        this.detail_url = detail_url;
    }
}
