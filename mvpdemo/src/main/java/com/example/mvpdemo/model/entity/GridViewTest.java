package com.example.mvpdemo.model.entity;

import java.util.List;

/**
 * Created by stevenzhang on 2017/2/21 0021.
 */

public class GridViewTest {


    /**
     * status : 1
     * action : 1021
     * key : 111
     * totalnum : 0
     * msg : 
     * list : [{"id":"1","ad_type":"1","ad_link":"http://meiyaoni.com.cn/Activity/Packets","ad_pic":"Public/app/banner/banner1.jpg?rand=11-11"},{"id":"2","ad_type":"1","ad_link":"3","ad_pic":"Public/app/banner/banner2.jpg?rand=12-10-13"},{"id":"3","ad_type":"1","ad_link":"http://meiyaoni.com.cn/Activity/Luck","ad_pic":"Public/app/banner/banner3.jpg?rand=8-13"}]
     */

    private String status;
    private String action;
    private String key;
    private String totalnum;
    private String msg;
    private List<ListBean> list;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(String totalnum) {
        this.totalnum = totalnum;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 1
         * ad_type : 1
         * ad_link : http://meiyaoni.com.cn/Activity/Packets
         * ad_pic : Public/app/banner/banner1.jpg?rand=11-11
         */

        private String id;
        private String ad_type;
        private String ad_link;
        private String ad_pic;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAd_type() {
            return ad_type;
        }

        public void setAd_type(String ad_type) {
            this.ad_type = ad_type;
        }

        public String getAd_link() {
            return ad_link;
        }

        public void setAd_link(String ad_link) {
            this.ad_link = ad_link;
        }

        public String getAd_pic() {
            return ad_pic;
        }

        public void setAd_pic(String ad_pic) {
            this.ad_pic = ad_pic;
        }
    }
}
