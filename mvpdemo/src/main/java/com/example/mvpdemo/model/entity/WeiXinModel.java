package com.example.mvpdemo.model.entity;

/**
 * Created by stevenzhang on 2017/2/22 0022.
 */

public class WeiXinModel {


    /**
     * errcode : 40029
     * errmsg : invalid code, hints: [ req_id: b55fhA0878s109 ]
     */

    private int errcode;
    private String errmsg;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
