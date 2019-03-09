package com.example.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author 作者 :zhangqi
 * @version 版本号 :
 * @date 创建时间 :2019/3/8
 * @Description 描述 :
 **/
public class DrawViewRect extends View {
    private Context context;
    public DrawViewRect(Context context) {
        super(context);
        this.context = context;
    }

    public DrawViewRect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawViewRect(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 创建画笔
        Paint paint = new Paint();

        paint.setAntiAlias(true);                       //设置画笔为无锯齿
        paint.setColor(Color.BLACK);                    //设置画笔颜色
        canvas.drawColor(Color.WHITE);                  //白色背景
        paint.setStrokeWidth((float) 3.0);              //线宽
        paint.setStyle(Paint.Style.STROKE);                   //空心效果
        Rect r=new Rect();                          //Rect对象
        r.left=50;                                  //左边
        r.top=50;                                   //上边
        r.right=450;                                    //右边
        r.bottom=250;                                   //下边
        canvas.drawRect(r, paint);                      //绘制矩形
        canvas.drawRect(50, 400, 450, 600, paint);      //绘制矩形



    }
}
