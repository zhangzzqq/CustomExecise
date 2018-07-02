package com.example.zq.popwindowtest;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

/**
 * ClassName:
 * Description:
 * Create by: steven
 * Date: 2018/6/27
 */
public class TestPopWindow extends Activity {

    private PopupWindow popview;
    private Button btn_open;
    private RelativeLayout rlRoot;
    private int heightDifference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.test_popwindow);

        btn_open = (Button) this.findViewById(R.id.btn_open);
        rlRoot = (RelativeLayout) this.findViewById(R.id.root);
        btn_open.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                showPopWindow();
            }
        });

    }

    private void showPopWindow() {
        View view = LayoutInflater.from(this).inflate(R.layout.view_pop, null);


        int a[] = getScreenSize(this);
        int height = (int) (a[1] * 0.85);


        popview = new PopupWindow(view,
                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                height, true);


        popview.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popview.setFocusable(true);
        // 设置点击其他地方就消失
        popview.setOutsideTouchable(true);
        popview.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        popview.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        popview.showAtLocation(rlRoot, Gravity.BOTTOM
                , 0, getStatusBarHeight(this));


        rlRoot.getViewTreeObserver().
                addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    /**
                     * the result is pixels
                     */
                    @Override
                    public void onGlobalLayout() {
                        Rect r = new Rect();
                        rlRoot.getWindowVisibleDisplayFrame(r);

                        int screenHeight = rlRoot.getRootView().getHeight();
                        heightDifference = screenHeight - (r.bottom - r.top);
                        Log.e("", "" + heightDifference);

                        //boolean visible = heightDiff > screenHeight / 3;
                    }
                });


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
        return frame.top;
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


}
