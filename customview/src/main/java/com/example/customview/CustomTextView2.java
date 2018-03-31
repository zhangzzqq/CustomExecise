package com.example.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by steven on 2018/3/30.
 */

public class CustomTextView2 extends View {

    private static final String TAG = CustomTextView2.class.getSimpleName();

    public CustomTextView2(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.test);

        String text = ta.getString(R.styleable.test_text);
        int textAttr = ta.getInteger(R.styleable.test_textAttr, -1);

        Log.e(TAG, "text = " + text + " , textAttr = " + textAttr);

        ta.recycle();
    }



}
