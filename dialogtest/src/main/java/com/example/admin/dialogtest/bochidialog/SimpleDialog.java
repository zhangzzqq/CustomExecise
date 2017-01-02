package com.example.admin.dialogtest.bochidialog;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by stevenZhang on 2017/1/1.
 */

public class SimpleDialog {

    private  ProgressDialog waitdialog;
    private Context mContext;

    public SimpleDialog (Context context){

        this.mContext = context;

    }

    public ProgressDialog showWaitDialog(String text){

        if(waitdialog!=null){

            if(!waitdialog.isShowing()){
               waitdialog.setMessage(text);
                waitdialog.setCancelable(false);
                waitdialog.show();
                return waitdialog;
            }

            return null;
        }else {

            waitdialog = new ProgressDialog(mContext);
            waitdialog.setMessage(text);
            waitdialog.setCancelable(false);
            waitdialog.show();
            return waitdialog;
        }

    }

    public void hideWaitDialog(){

        if(waitdialog!=null&&waitdialog.isShowing()){

            waitdialog.dismiss();
            waitdialog = null;

        }

    }

}
