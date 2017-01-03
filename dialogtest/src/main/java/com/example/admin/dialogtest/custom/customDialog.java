package com.example.admin.dialogtest.custom;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.admin.dialogtest.R;
import com.example.admin.dialogtest.utils.ProgressWheel;

/**
 * Created by stevenZhang on 2017/1/2.
 *
 * sweet-alert-dialog
 *https://github.com/pedant/sweet-alert-dialog
 *
 * 封装项目中经常使用到的几种Dialog
 * http://www.ctolib.com/NormalSelectDialog.html
 *
 */

public class CustomDialog extends Activity implements View.OnClickListener{

    private ProgressWheel progressWheel;
//    private ProgressWheel progressWheelInterpolated;
//    private ProgressWheel progressWheelLinear;

    private TextView interpolatedValue;
    private TextView linearValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_custom);

        findViewById(R.id.btn1).setOnClickListener(this);
        progressWheel = (ProgressWheel) findViewById(R.id.progress_wheel);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btn1:

//                final SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE)
//                        .setTitleText("Loading");
//                pDialog.show();
//                pDialog.setCancelable(false);

                break;


        }
    }


}
