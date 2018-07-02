package com.example.zq.popwindowtest;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.example.zq.popwindowtest.adapter.ListAdapters;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:
 * Description:
 * Create by: steven
 * Date: 2018/6/27
 */
public class ListPopupWindow extends PopupWindow {

    PopupWindow popupWindow;
    Context context;
    LinearLayout llRoot;
    private Activity activity;
    private Button button;

    public ListPopupWindow(Context context, LinearLayout llRoot) {
        super(context);
        this.context = context;
        this.llRoot = llRoot;
        activity = (MainActivity)context;
        initTypePopupWindow(llRoot);
    }

    protected void initTypePopupWindow(View v) {
        if (popupWindow != null && popupWindow.isShowing()) {
            hiddenDiskPopUpWindow();
        }

        LayoutInflater inflater = (LayoutInflater)context. getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.activity_listview, null);

        button = (Button) customView.findViewById(R.id.button);


         ListView lvList = (ListView) customView.findViewById(R.id.lv);

        int a[] = getScreenSize(context);
        int height = (int) (a[1] * 0.85);
        popupWindow = new PopupWindow(customView, LinearLayout.LayoutParams.MATCH_PARENT, height);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);


        ListAdapters filterTypeDialogAdapter = new ListAdapters(getData(),context);
        lvList.setAdapter(filterTypeDialogAdapter);


        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });

        popupWindow.setClippingEnabled(false);//使通知栏不挡住popupwindow
        popupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

//        popupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
//        setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
//        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
//        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

//        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
//        popupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
//       activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
//        showLocation();
//        popupWindow.showAtLocation(llRoot, Gravity.NO_GRAVITY, 0, 0);
//        popupWindow.showAsDropDown(v, 0, 0);

//        popupWindow.setSoftInputMode(INPUT_METHOD_NEEDED);
//        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);


        //设置弹出窗体需要软键盘

        llRoot.getViewTreeObserver().
                addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    /**
                     * the result is pixels
                     */
                    @Override
                    public void onGlobalLayout() {
//                        Rect r = new Rect();
//                        llRoot.getWindowVisibleDisplayFrame(r);
//
//                        int screenHeight = llRoot.getRootView().getHeight();
//                        int screenWidth = llRoot.getRootView().getWidth();
//                        int heightDifference = screenHeight - (r.bottom - r.top);
//                        Log.e("", "" + heightDifference);

                        //boolean visible = heightDiff > screenHeight / 3;

                        //boolean visible = heightDiff > screenHeight / 3;
//                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) button.getLayoutParams();
//                        params.width = dip2px(context, screenWidth);
//                        params.height = dip2px(context, screenHeight);
                        // params.setMargins(dip2px(MainActivity.this, 1), 0, 0, 0); // 可以实现设置位置信息，如居左距离，其它类推
                        // params.leftMargin = dip2px(MainActivity.this, 1);
//                        button.setLayoutParams(params);
                    }
                });
    }

    public void showLocation() {
        popupWindow.showAtLocation(llRoot, Gravity.FILL, 0, -getStatusBarHeight((Activity) context));
        backgroundAlpha(0.2f);
    }

    /**
     * 隐藏diskPopupWindow
     */
    protected void hiddenDiskPopUpWindow() {
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /**
     * 获取状态通知栏高度
     *
     * @param activity
     * @return
     */
    public static int getStatusBarHeight(Activity activity) {
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        Log.d("xxxx", "statusBarHeight:" + frame.top + "px");
        return frame.top*8;
    }

    /**
     * 实现功能：
     * <p>
     * 屏幕的宽高
     * <p>
     * <p>
     * 注意事项：
     */

    public static int[] getScreenSize(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return new int[]{outMetrics.widthPixels, outMetrics.heightPixels};
    }

    /**
     * 实现功能：
     * <p>
     * popup背景透明度
     * 1 不变
     * 0.2 透明
     * <p>
     * 注意事项：
     */

    public void backgroundAlpha(float bgalpha) {
        Window window = ((MainActivity) context).getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = bgalpha;
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        window.setAttributes(lp);
    }


    private List<String> getData() {
        List<String> list = new ArrayList();

        for (int i = 0; i < 16; i++) {
            list.add("item" + i);
        }

        return list;

    }



    /**
     * dp转为px
     * @param context  上下文
     * @param dipValue dp值
     * @return
     */
    private int dip2px(Context context,float dipValue)
    {
        Resources r = context.getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dipValue, r.getDisplayMetrics());
    }
}
