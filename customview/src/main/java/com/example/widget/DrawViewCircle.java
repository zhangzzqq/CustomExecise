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
public class DrawViewCircle extends View {
    private Context context;
    public DrawViewCircle(Context context) {
        super(context);
        this.context = context;
    }

    public DrawViewCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawViewCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
//        int screenWidth = ScreenUtils.getScreenWidth(context);
//        canvas.drawLine(0, 40, screenWidth, 40, paint);// 画线


        canvas.drawText("画圆：", 500, 220, paint);// 画文本
        canvas.drawCircle(100, 200, 50, paint);// 小圆
        paint.setAntiAlias(true);// 设置画笔的锯齿效果。 true是去除，大家一看效果就明白了
        canvas.drawCircle(150, 400, 80, paint);// 大圆



        paint.setStyle(Paint.Style.STROKE);                   //空心效果

        canvas.drawCircle(50, 50, 10, paint);           //绘制圆形
        canvas.drawCircle(100, 100, 20, paint);         //绘制圆形
        canvas.drawCircle(150, 150, 30, paint);         //绘制圆形
        canvas.drawCircle(200, 200, 40, paint);         //绘制圆形
        canvas.drawCircle(250, 250, 50, paint);         //绘制圆形
        canvas.drawCircle(300, 300, 60, paint);         //绘制圆形
        canvas.drawCircle(350, 350, 70, paint);         //绘制圆形



    }
}
