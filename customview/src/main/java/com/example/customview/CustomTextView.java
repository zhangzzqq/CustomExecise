package com.example.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by steven on 2018/3/30.
 */

public class CustomTextView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);//画笔
    //    private int mColor = Color.RED;//默认为红色
    private int mColor;//默认
    private String mText = "I am a Custom TextView";//默认显示该文本
    private static final String TAG = CustomTextView.class.getSimpleName();


    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);//注意不是super(context,attrs,0);

//        init();

    }


    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.customTextView);
        mColor = typedArray.getColor(R.styleable.customTextView_customColor, Color.RED);
//        如果没有判断，当没有指定该属性而去加载该属性app便会崩溃掉
        if (typedArray.getText(R.styleable.customTextView_customText) != null) {
            mText = typedArray.getText(R.styleable.customTextView_customText).toString();
        }

        typedArray.recycle();//释放资源

        init();


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(mText, 100, 100, mPaint);

    }

    private void init() {

        mPaint.setColor(mColor);
    }


}
