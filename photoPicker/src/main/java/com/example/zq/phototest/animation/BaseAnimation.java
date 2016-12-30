package com.example.zq.phototest.animation;

/**
 * Created by stevenzhang on 2016/12/24 0024.
 */


import android.animation.Animator;
import android.view.View;

/**
 * 基本动画
 */
public interface  BaseAnimation {

    Animator[] getAnimators(View view);

}
