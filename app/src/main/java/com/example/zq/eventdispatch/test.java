package com.example.zq.eventdispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by stevenzhang on 2016/12/29 0029.
 */

public class test {

    public class MyLayout extends LinearLayout {
        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            Log.e("Demo:","父View的dispatchTouchEvent方法执行了");
            return super.dispatchTouchEvent(ev);
        }
        @Override
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            Log.e("Demo:","父View的onInterceptTouchEvent方法执行了");
            return super.onInterceptTouchEvent(ev);
        }
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            Log.e("Demo:","父View的onTouchEvent方法执行了");
            return super.onTouchEvent(event);
        }
        public MyLayout(Context context) {
            super(context);
        }
        public MyLayout(Context context,AttributeSet attr) {
            super(context,attr);
        }
    }
    
}
