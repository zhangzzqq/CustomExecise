package com.ouyben.slidelockview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by stevenZhang on 2016/12/22.
 */

public class TestPhoneMessage extends Activity {

    private TextView tvModel;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        tvModel = (TextView) findViewById(R.id.tv_phone_message);
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.custom_lock_pic);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.lock_icon);
       
       Log.v("TestPhoneMessage","bitmap=="+bitmap);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);

//        phoneMessage();
    }

    public void phoneMessage() {

        String model = android.os.Build.MODEL;
//        tvModel.setText(android.os.Build.MODEL);//手机型号
// 获取屏幕密度（方法1）
        int screenWidth1 = getWindowManager().getDefaultDisplay().getWidth();       // 屏幕宽（像素，如：480px）
        int screenHeight1 = getWindowManager().getDefaultDisplay().getHeight();      // 屏幕高（像素，如：800p）
        String g = screenHeight1 + " px";
        String k = screenWidth1 + " px";
//        tvScreenHeight1.setText(screenHeight1 + " px");
//        tvScreenWidth1.setText(screenWidth1 + " px");

        tvModel.setText(model +"g=="+ g +"k"+k);

// 获取屏幕密度（方法2）
        DisplayMetrics dm2 = getResources().getDisplayMetrics();
        float density = dm2.density;        // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
        int densityDPI = dm2.densityDpi;     // 屏幕密度（每寸像素：120/160/240/320）
        float xdpi = dm2.xdpi;
        float ydpi = dm2.ydpi;
        int screenWidth2 = dm2.widthPixels;      // 屏幕宽（像素，如：480px）
        int screenHeight2 = dm2.heightPixels;     // 屏幕高（像素，如：800px）

        tv2.setText(screenHeight2 + " px");
        tv3.setText(screenWidth2 + " px");
        tv4.setText(density + "");
        tv5.setText(densityDPI + "");



    }


//    private void getDensity() {
//        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
//        Log.d("##", "Density is " + displayMetrics.density + " densityDpi is " + displayMetrics.densityDpi + " height: " + displayMetrics.heightPixels +
//                " width: " + displayMetrics.widthPixels);
//    }

}
