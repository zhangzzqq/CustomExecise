package com.example.zq.permissiondispatcher;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Vincent on 2016/8/26.
 */

public class ToastUtils {
    /**
     * 系统默认的Toast
     * @param context
     * @param msg
     */
    public static void defaultToast(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
