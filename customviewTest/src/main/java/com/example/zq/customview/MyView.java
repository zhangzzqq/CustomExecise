package com.example.zq.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by stevenzhang on 2016/12/23 0023.
 */

public class MyView extends View {

    private Paint mPaint;
    

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        
    }

    public MyView(Context context) {
        super(context);
    }

    /**
     * TODO 重绘控件
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(90);
        String text = "Hello world";
        canvas.drawText(text,50,getHeight()/2,mPaint);
    }
}


