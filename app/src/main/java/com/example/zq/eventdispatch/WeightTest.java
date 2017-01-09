package com.example.zq.eventdispatch;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by stevenzhang on 2017/1/9 0009.
 */


/**
 * weightSum的用法说明 父控件来确定weight总数 例如 weightSum=1 子控件weight=0.5那么显示的大小就是整个屏幕的0.5，如果是1才充满全屏
 * 可以在布局中体验下
 * android:weightSum的开发文档里的一段描述与我们现在想要实现的功能类似，文档内容如下：
 “定义weight总和的最大值。如果未指定该值，以所有子视图的layout_weight属性的累加值作为总和的最大值。
 一个典型的案例是：通过指定子视图的layout_weight属性为0.5，并设置LinearLayout的weightSum属性为1.0，实现子视图占据可用宽度的50%。”
 */
public class WeightTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        
        
    }
}
