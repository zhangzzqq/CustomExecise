package com.example.admin.dialogtest.custom3;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.example.admin.dialogtest.R;
import com.example.admin.dialogtest.utils.ProgressWheel;

public class SweetAlertDialog extends Dialog {
    private TextView mTitleTextView;
    private String mTitleText;
    private ProgressHelper mProgressHelper;

    public SweetAlertDialog(Context context) {
        super(context, R.style.alert_dialog);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        mProgressHelper = new ProgressHelper(context);

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog);
        mTitleTextView = (TextView)findViewById(R.id.title_text);
        mProgressHelper.setProgressWheel((ProgressWheel)findViewById(R.id.progressWheel));
        setTitleText(mTitleText);
    }

    public SweetAlertDialog setTitleText (String text) {
        mTitleText = text;
        if (mTitleTextView != null && mTitleText != null) {
            mTitleTextView.setText(mTitleText);
        }
        return this;
    }


    //这个方法会先执行，mTitleTextView是空的
//    public void setLoadText(String text){
//        if(text!=null&&mTitleTextView!=null){
//            mTitleTextView.setText(text);  
//        }
//    }

    public ProgressHelper getProgressHelper () {
        return mProgressHelper;
    }
}