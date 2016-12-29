package com.example.zq.popwindowtest;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

/**
 * Created by stevenzhang on 2016/12/29 0029.
 */


public class PopUtils {
    private Context context;
    private PopupWindow popupWindow;

    public PopUtils(Context context) {
        this.context = context;
    }

    public void initPop(View view) {
        WindowManager wm = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        int mScreenWidth = outMetrics.widthPixels;
        int mScreenHeight = outMetrics.heightPixels;
        popupWindow = new PopupWindow(mScreenWidth, mScreenHeight * 1 / 2);
        //设置可获得焦点后才能响应点击事件
        popupWindow.setFocusable(true);
        //设置popup的显示内容
        popupWindow.setContentView(view);
        //设置背景后，popupWindow才向对话框一样点击边上自动消失
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));

    }

    //设置显示PopupWindow
    public void showPop(RelativeLayout relativeLayout, LinearLayout linearLayout) {
        if (relativeLayout != null) {
            popupWindow.showAtLocation(relativeLayout, Gravity.AXIS_X_SHIFT | Gravity.BOTTOM, 0, 0);
        } else {
            popupWindow.showAtLocation(linearLayout, Gravity.AXIS_X_SHIFT | Gravity.BOTTOM, 0, 0);
        }
    }

    //设置取消PopupWindow
    public void desMiss() {
        popupWindow.dismiss();
    }
}
