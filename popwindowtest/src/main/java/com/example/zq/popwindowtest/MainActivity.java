package com.example.zq.popwindowtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv;
    private Button button1;
    private Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        button1 = (Button) findViewById(R.id.btn1);
        btnShare = (Button) findViewById(R.id.share);
        button1.setOnClickListener(this);
        btnShare.setOnClickListener(this);

        initPopWindow1();
    }

    private void initPopWindow1() {

        /**
         * Unable to add window --token null is not valid; is your activity running?
         * 1、移到事件中（比如一个button的click事件中）;
         2、移到子线程中;另起一线程,在线程中不断循环，直到判断控件是否渲染完毕(如长宽大于0),不推荐。。。
         * 3.窗口焦点改变,当activity获得焦点之后，activity是加载完毕的
         */
    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if(hasFocus){
//            MorePopWindow popWindow = new MorePopWindow(this);
//            popWindow.showPopupWindow(button1);
//        }
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1 :
                MorePopWindow popWindow = new MorePopWindow(this);
                popWindow.showPopupWindow(button1);
                break;

            case R.id.share:

                final CustomPopWindow customPopWindow = new CustomPopWindow(this,btnShare);
                customPopWindow.setCancelButtonOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        customPopWindow.dismiss();
                    }
                });

                customPopWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        //对象是一个HashMap对象

                        HashMap<String, Object> item = (HashMap<String, Object>) adapterView.getItemAtPosition(i);
                    }
                });
                break;




        }
    }


}
