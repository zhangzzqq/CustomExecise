package com.example.zq.popwindowtest;

import android.os.Bundle;
import android.view.View;

public class Main3Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }


    public void button3(View view){

      finish();
    }



}
