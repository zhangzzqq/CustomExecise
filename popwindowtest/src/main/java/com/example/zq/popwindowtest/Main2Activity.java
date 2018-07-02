package com.example.zq.popwindowtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }


    public void button2(View view){

        startActivity(new Intent(Main2Activity.this,Main3Activity.class));

    }



}
