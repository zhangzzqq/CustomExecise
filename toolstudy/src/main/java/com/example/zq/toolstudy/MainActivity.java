package com.example.zq.toolstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button btnBackPress = (Button) findViewById(R.id.btn_back_press);
        btnBackPress.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        
    }
}
