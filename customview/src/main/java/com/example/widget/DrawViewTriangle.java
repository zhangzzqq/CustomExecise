package com.example.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.utils.ScreenUtils;

/**
 * @author 作者 :zhangqi
 * @version 版本号 :
 * @date 创建时间 :2019/3/8
 * @Description 描述 :
 **/
public class DrawViewTriangle extends View {
    private Context context;
    public DrawViewTriangle(Context context) {
        super(context);
        this.context = context;
    }

    public DrawViewTriangle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawViewTriangle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 创建画笔
        Paint paint = new Paint();
        paint.setFakeBoldText(true);
        paint.setStrokeWidth((float) 5.0);
        paint.setColor(Color.RED);// 设置红色
        int screenWidth = ScreenUtils.getScreenWidth(context);
//        canvas.drawLine(0, 40, screenWidth, 40, paint);// 画线


//        paint.setColor(Color.BLACK);                    //设置画笔颜色
        canvas.drawColor(Color.GREEN);                  //设置背景颜色
        paint.setTextSize(20);                          //设置画笔字体的大小
        canvas.drawText("画三角形：", 50, 50, paint);

        // 绘制这个三角形,你可以绘制任意多边形
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.moveTo(80, 200);// 此点为多边形的起点
        path.lineTo(120, 250);
        path.lineTo(80, 250);
        path.close(); // 使这些点构成封闭的多边形
        canvas.drawPath(path, paint);


    }
}
