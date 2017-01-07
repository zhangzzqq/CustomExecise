package com.example.zq.kaiyanstudy.donghua2;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.zq.kaiyanstudy.R;

/**
 * Android 5.0开始提供原生的实现，这里全部用Java代码实现，没有写xml。
 *
 * 更多说明可参考：https://developer.android.com/training/material/animations.html#Transitions
 */
public class DetailActivityLollipop extends AppCompatActivity {

    public static final String SHARED_ELEMENT_KEY = "SHARED_ELEMENT_KEY";
    public static final String IMAGE_RES_ID = "imageResId";
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail); // layout代码和4.x是一样的
        imageView = (ImageView) findViewById(R.id.imageDetail);
        initImageEnterTransition();
    }
    //初始化进入动画
    // ViewCompat.setTransitionName   把每个图片视图设置不同的Transition名称, 防止在一个视图内有多个相同的名称, 在变换的时候造成混乱
    // Fragment支持多个View进行变换, 使用适配器时, 需要加以区分
    private void initImageEnterTransition() {
        imageView.setVisibility(View.VISIBLE);
        String imageTransitionName = getIntent().getStringExtra(SHARED_ELEMENT_KEY);
        ViewCompat.setTransitionName(imageView, imageTransitionName);
        int resId = getIntent().getExtras().getInt(IMAGE_RES_ID);
        imageView.setImageResource(resId);
    }
}
