package com.example.guolin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * ClassName:
 * Description:
 * Create by: steven
 * Date: 2018/7/11
 */
public class CounterView extends View implements View.OnClickListener {

    private Paint mPaint;

    private Rect mBounds;

    private int mCount;

    public CounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBounds = new Rect();
        setOnClickListener(this);
    }

    /**
     *
     *  Canvas 代表画布
     *  Paint 代表画笔、画刷、颜料
     *  Rect   表示坐标系中的一块矩形区域，并可以对其做一些简单操作。这块矩形区域，需要用左上和右下两个坐标点表示。
     *
     *
     *
     * getWidth  屏幕的宽度
     *
     * textWidth 文本的宽度
     *
     *
     *
     */


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);//绘制一块区域
        mPaint.setColor(Color.YELLOW);//画画 设置颜色
        mPaint.setTextSize(30);        //画画 设置字体大小
        String text = String.valueOf(mCount); //获取上面的值
        mPaint.getTextBounds(text, 0, text.length(), mBounds); //获取文本的大小
        float textWidth = mBounds.width();
        float textHeight = mBounds.height();

        canvas.drawText(text, getWidth() / 2 - textWidth / 2, getHeight() / 2
                + textHeight / 2, mPaint);
    }

    @Override
    public void onClick(View v) {
        mCount++;
        invalidate();
    }

}

