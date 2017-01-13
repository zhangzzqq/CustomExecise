package com.example.zq;

import java.util.List;

/**
 * Created by stevenzhang on 2017/1/13 0013.
 */

public class GridviewModule {


    /**
     * status : 1
     * action : 1003
     * key : 111
     * totalnum : 0
     * msg : 
     * list : [{"cat_id":"10","cat_pic":"/Public/app/images/hzyx.png","test_pic":"/Public/app/images/v_2.0/locin-8.png","cat_name":"合作院校"},{"cat_id":"1","cat_pic":"/Public/app/images/mz.png","test_pic":"/Public/app/images/v_2.0/locin-2.png","cat_name":"化妆"},{"cat_id":"3","cat_pic":"/Public/app/images/mj.png","test_pic":"/Public/app/images/v_2.0/locin-3.png","cat_name":"美甲"},{"cat_id":"2","cat_pic":"/Public/app/images/mf.png","test_pic":"/Public/app/images/v_2.0/locin-4.png","cat_name":"美容美发"},{"cat_id":"6","cat_pic":"/Public/app/images/xxsj.png","test_pic":"/Public/app/images/v_2.0/locin-7.png","cat_name":"形象设计"},{"cat_id":"5","cat_pic":"/Public/app/images/sy.png","test_pic":"/Public/app/images/v_2.0/locin-6.png","cat_name":"摄影"},{"cat_id":"7","cat_pic":"/Public/app/images/byj.png","test_pic":"/Public/app/images/v_2.0/locin-5.png","cat_name":"半永久"},{"cat_id":"8","cat_pic":"/Public/app/images/cz.png","test_pic":"/Public/app/images/v_2.0/locin-1.png","cat_name":"充值"}]
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
         * cat_id : 10
         * cat_pic : /Public/app/images/hzyx.png
         * test_pic : /Public/app/images/v_2.0/locin-8.png
         * cat_name : 合作院校
         */

        private String cat_id;
        private String cat_pic;
        private String test_pic;
        private String cat_name;

        public String getCat_id() {
            return cat_id;
        }

        public void setCat_id(String cat_id) {
            this.cat_id = cat_id;
        }

        public String getCat_pic() {
            return cat_pic;
        }

        public void setCat_pic(String cat_pic) {
            this.cat_pic = cat_pic;
        }

        public String getTest_pic() {
            return test_pic;
        }

        public void setTest_pic(String test_pic) {
            this.test_pic = test_pic;
        }

        public String getCat_name() {
            return cat_name;
        }

        public void setCat_name(String cat_name) {
            this.cat_name = cat_name;
        }
    }
}

