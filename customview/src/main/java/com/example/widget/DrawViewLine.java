package com.example.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.utils.ScreenUtils;

/**
 * @author 作者 :zhangqi
 * @version 版本号 :
 * @date 创建时间 :2019/3/8
 * @Description 描述 :
 **/
public class DrawViewLine extends View {
    private Context context;
    public DrawViewLine(Context context) {
        super(context);
        this.context = context;
    }

    public DrawViewLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawViewLine(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 创建画笔
        Paint paint = new Paint();
        paint.setFakeBoldText(true);
        paint.setStrokeWidth((float) 20.0);
        paint.setColor(Color.RED);// 设置红色
        int screenWidth = ScreenUtils.getScreenWidth(context);
        canvas.drawLine(0, 40, screenWidth, 40, paint);// 画线





//        paint.setColor(Color.BLACK);                    //设置画笔颜色
        canvas.drawColor(Color.GREEN);                  //设置背景颜色
        paint.setStrokeWidth((float) 1.0);              //设置线宽
        canvas.drawLine(50, 50, 450, 50, paint);        //绘制直线
        paint.setStrokeWidth((float) 5.0);              //设置线宽
        canvas.drawLine(50, 150, 450, 150, paint);      //绘制直线
        paint.setStrokeWidth((float) 10.0);             //设置线宽
        canvas.drawLine(50, 250, 450, 250, paint);      //绘制直线
        paint.setStrokeWidth((float) 15.0);             //设置线宽
        canvas.drawLine(50, 350, 450, 350, paint);      //绘制直线
        paint.setStrokeWidth((float) 20.0);             //设置线宽
        canvas.drawLine(50, 450, 450, 450, paint);      //绘制直线




        paint.setStrokeWidth((float) 1.0);              //设置线宽
        canvas.drawLine(50, 500, 50, 600, paint);        //绘制直线

         paint.setStrokeWidth((float) 5.0);              //设置线宽
        canvas.drawLine(100, 500, 100, 800, paint);        //绘制直线

        paint.setStrokeWidth((float) 15.0);              //设置线宽
        canvas.drawLine(150, 500, 150, 1000, paint);        //绘制直线

        paint.setStrokeWidth((float) 30.0);              //设置线宽
        canvas.drawLine(250, 500, 250, 1200, paint);        //绘制直线

    }
}
