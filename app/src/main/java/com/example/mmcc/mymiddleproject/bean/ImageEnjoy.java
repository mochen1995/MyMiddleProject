package com.example.mmcc.mymiddleproject.bean;

import android.widget.ImageView;

import java.util.List;

/**
 * Created by zhanglu on 2016/10/21.
 */

public class ImageEnjoy {

    /**
     * 图赏fragment 的图片详情
     */

    /**
     * date : 2014-03-28
     * doc_title : 【付出和收获=成正比】
     * pic : {"pic_datil":"从买相机，到今天。一共是8个月3天。从（没人教、不会PS、什么都不懂......我都克服了，我做到了）。相信自己，你可以做到！我还在努力的路上................. \n","gq":"http://img3.fengniao.com/forum/attachpics/744/41/29728122_1000.jpg","sl":"","web_url":"http://bbs.fengniao.com/forum/pic/slide_125_3226241_63278793.html"}
     */

    private String date;
    private String doc_title;
    /**
     * pic_datil : 从买相机，到今天。一共是8个月3天。从（没人教、不会PS、什么都不懂......我都克服了，我做到了）。相信自己，你可以做到！我还在努力的路上.................

     * gq : http://img3.fengniao.com/forum/attachpics/744/41/29728122_1000.jpg
     * sl :
     * web_url : http://bbs.fengniao.com/forum/pic/slide_125_3226241_63278793.html
     */

    private PicBean pic;

    @Override
    public String toString() {
        return "ImageEnjoy{" +
                "date='" + date + '\'' +
                ", doc_title='" + doc_title + '\'' +
                ", pic=" + pic +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDoc_title() {
        return doc_title;
    }

    public void setDoc_title(String doc_title) {
        this.doc_title = doc_title;
    }

    public PicBean getPic() {
        return pic;
    }

    public void setPic(PicBean pic) {
        this.pic = pic;
    }

    public static class PicBean {
        private String pic_datil;
        private String gq;
        private String web_url;

        @Override
        public String toString() {
            return "PicBean{" +
                    "pic_datil='" + pic_datil + '\'' +
                    ", gq='" + gq + '\'' +
                    ", web_url='" + web_url + '\'' +
                    '}';
        }

        public String getPic_datil() {
            return pic_datil;
        }

        public void setPic_datil(String pic_datil) {
            this.pic_datil = pic_datil;
        }

        public String getGq() {
            return gq;
        }

        public void setGq(String gq) {
            this.gq = gq;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }
    }

    public static class ImageDetailBean{
        private String title;
        private String page;
        List<String> imgs;

        @Override
        public String toString() {
            return "ImageDetailBean{" +
                    "title='" + title + '\'' +
                    ", page='" + page + '\'' +
                    ", imgs=" + imgs +
                    '}';
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public List<String> getImgs() {
            return imgs;
        }

        public void setImgs(List<String> imgs) {
            this.imgs = imgs;
        }
    }


}
