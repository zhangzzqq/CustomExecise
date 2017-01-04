package com.example.zq.refreshtest.refreshpic;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.zq.refreshtest.R;

/**
 * Created by stevenzhang on 2017/1/4 0004.
 */

public class test extends Activity {

    private RotateAnimation refreshingAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        //属间动画 androi:repeatCount="负数"代表无限循环
        refreshingAnimation = (RotateAnimation) AnimationUtils.loadAnimation(this,R.anim.rotating);
        ImageView image = (ImageView) findViewById(R.id.iv_circle);
        LinearInterpolator lir = new LinearInterpolator();
        refreshingAnimation.setInterpolator(lir);
        image.setAnimation(refreshingAnimation);
        
    }
    
    
    
}
