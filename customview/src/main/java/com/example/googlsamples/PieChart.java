package com.example.googlsamples;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import com.example.customview.R;

/**
 * ClassName:
 * Description:
 * Create by: steven
 * Date: 2018/7/2
 */
public class PieChart extends View {

    private final Boolean mShowText;
    private final Integer mTextPos;

    public PieChart(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.PieChart,
                0, 0);

        try {

            mShowText = a.getBoolean(R.styleable.PieChart_showText, false);
            mTextPos = a.getInteger(R.styleable.PieChart_labelPosition, 0);

        } finally {
            a.recycle();
        }


    }


}
