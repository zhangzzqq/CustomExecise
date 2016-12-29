package com.example.zq.popwindowtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv;
    private LinearLayout ll;
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        ll = (LinearLayout) findViewById(R.id.activity_main);
        mBtn = (Button) findViewById(R.id.btn1);
        mBtn.setOnClickListener(this);
        initPopWindow1();
    }

    private void initPopWindow1() {
//        PopUtils pop = new PopUtils(this);
//        pop.initPop(tv);
//        pop.showPop(null,ll);
        /**
         * Unable to add window --token null is not valid; is your activity running?
         * 1、移到事件中（比如一个button的click事件中）;
         2、移到子线程中;另起一线程,在线程中不断循环，直到判断控件是否渲染完毕(如长宽大于0),不推荐。。。
         * 3.窗口焦点改变
         */
    }
    //当activity获得焦点之后，activity是加载完毕的了
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
//            MorePopWindow popWindow = new MorePopWindow(this);
//            popWindow.showPopupWindow((View) tv.getParent());   
        }
    }

    @Override
    public void onClick(View view) {
        
        switch (view.getId()){
            
            case R.id.btn1 :

                MorePopWindow popWindow = new MorePopWindow(this);
                popWindow.showPopupWindow((View) mBtn.getParent());
                break;
            
            
            
        }
    }
}
