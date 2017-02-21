package com.example.mvpdemo.model.entity;

/**
 * Created by stevenzhang on 2017/2/21 0021.
 */

public class Result {


    /**
     * errcode : 40163
     * errmsg : code been used, hints: [ req_id: g1g.Va0830s104 ]
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
