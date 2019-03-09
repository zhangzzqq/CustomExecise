package com.example.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.widget.DrawViewCircle;
import com.example.widget.DrawViewLine;
import com.example.widget.DrawViewRect;
import com.example.widget.DrawViewTriangle;

public class CustomerView5 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view5);
        init();
    }



    private void init() {

        LinearLayout layout=(LinearLayout) findViewById(R.id.root);
//        final DrawViewLine view=new DrawViewLine(this);
//        final DrawViewCircle view=new DrawViewCircle(this);
//        final DrawViewTriangle view=new DrawViewTriangle(this);
        final DrawViewRect view=new DrawViewRect(this);

        view.setMinimumHeight(500);
        view.setMinimumWidth(300);
        //通知view组件重绘
        view.invalidate();
        layout.addView(view);

    }



}

