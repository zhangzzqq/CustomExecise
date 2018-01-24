package com.example.customwidget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by steven on 2017/12/29.
 */

public class CanvasTest extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new CustomView1(this));

    }

    /**
     * 使用内部类 自定义一个简单的View
     * @author Administrator
     *
     */
    static class CustomView1 extends View {

        Paint paint;

        public CustomView1(Context context) {
            super(context);
            paint = new Paint(); //设置一个笔刷大小是3的黄色的画笔
            paint.setColor(Color.YELLOW);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setStrokeWidth(3);
        }

        //在这里我们将测试canvas提供的绘制图形方法
        @Override
        protected void onDraw(Canvas canvas) {
//            canvas.drawCircle(800, 1200, 120, paint); //横坐标 纵坐标 半径 paint对象

            //绘制弧线区域

            RectF rect = new RectF(0, 700, 800, 800);

            canvas.drawArc(rect, //弧线所使用的矩形区域大小
                    0,  //开始角度
                    90, //扫过的角度
                    true, //是否使用中心
                    paint);



        }


    }
}
