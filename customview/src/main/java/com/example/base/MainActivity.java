package com.example.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.customview.CustomerActivity;
import com.example.customview.CustomerView5;
import com.example.customview.R;
import com.example.hongyang.HongyangActivity;
import com.example.login.LoginActivity;
import com.example.simpleexercise.SimpleExerciseActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void customer1(View view) {

        startActivity(new Intent(MainActivity.this, CustomerActivity.class));

    }


    public void customer2(View view) {

        startActivity(new Intent(MainActivity.this, HongyangActivity.class));
    }


    public void customer3(View view) {

        startActivity(new Intent(MainActivity.this, LoginActivity.class));

    }


    public void customer4(View view) {


        startActivity(new Intent(MainActivity.this, SimpleExerciseActivity.class));
    }


    public void customer5(View view) {
        startActivity(new Intent(MainActivity.this, CustomerView5.class));

    }

    public void customer6(View view) {


    }



}
