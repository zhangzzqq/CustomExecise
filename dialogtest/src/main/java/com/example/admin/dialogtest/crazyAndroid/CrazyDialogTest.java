package com.example.admin.dialogtest.crazyandroid;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.example.admin.dialogtest.R;

/**
 * Created by stevenZhang on 2017/1/1.
 */

public class CrazyDialogTest extends Activity{

    final static int MAX_PROGRESS = 100;
    //记录对话框完成百分比
    private int [] data = new int[50];
    int progressStatus  = 0;
    int hasData = 0;
    ProgressDialog pd1, pd2;
    Handler handler = new Handler()
    {

        @Override
        public void handleMessage(Message msg) {

            //attention  msg要匹配正确
            if(msg.what ==0x123){

                pd2.setProgress(progressStatus);
            }



        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
    }


    public void showSpinner(View source){

        //调用静态方法显示环形进度条
        ProgressDialog.show(this,"任务执行中","任务执行中，请稍等",false,true);

    }


    public void showIndeterminate(View source ){

        pd1 = new ProgressDialog(CrazyDialogTest.this);

        pd1.setTitle("任务正在执行中");
        pd1.setMessage("任务正在执行中，请稍等...");
        pd1.setCancelable(false);
        pd1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd1.setIndeterminate(true);
        pd1.show();

    }

    //自定义dialog
    public void showCustomDialog(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.MyAlertDialogStyle);
        builder.setMessage("hello 这是一个文本消息")
                .setTitle("标题")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .create()
                .show();

    }


    public void showProgress(View source){

        progressStatus = 0;
        hasData = 0;
        pd2 = new ProgressDialog(CrazyDialogTest.this);

        pd2 .setMax(MAX_PROGRESS);

        pd2.setTitle("任务完成百分比");

        pd2.setMessage("耗时任务的完成百分比");
        pd2.setCancelable(false);
        pd2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        //是否显示进度条
        pd2.setIndeterminate(false);
        pd2.show();

        new Thread(){

            @Override
            public void run() {

                while (progressStatus<MAX_PROGRESS){

                    //获取耗时操作的百分比
                    progressStatus = MAX_PROGRESS*doWork()/data.length;

                    handler.sendEmptyMessage(0x123);

                    //如果任务已经完成

                    if(progressStatus >= MAX_PROGRESS){

                        //关闭对话框
                        pd2.dismiss();

                    }

                }


            }
        }.start();


    }

    private int doWork() {

        data[hasData++] = (int) (Math.random()*100);
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){

            e.printStackTrace();
        }

        return hasData;
    }


}
