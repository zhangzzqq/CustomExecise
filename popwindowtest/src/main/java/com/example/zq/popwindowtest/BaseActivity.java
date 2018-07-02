package com.example.zq.popwindowtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

/**
 * ClassName:
 * Description:
 * Create by: steven
 * Date: 2018/6/28
 */

public class BaseActivity extends AppCompatActivity {


    private Context context;
    private static final String TAG ="BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        Log.e(TAG,"执行onCreate方法");


    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.e(TAG,"执行onPause方法");

    }


    @Override
    protected void onResume() {
        super.onResume();

        Log.e(TAG,"执行onResume方法");

    }

    public class NetBroadCastReciver extends BroadcastReceiver {

        /**
         * 只有当网络改变的时候才会 经过广播。
         */

        @Override
        public void onReceive(Context context, Intent intent) {

            //此处是主要代码，
            //如果是在开启wifi连接和有网络状态下
            if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
                ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo info = intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
                if (NetworkInfo.State.CONNECTED == info.getState()) {
                    //连接状态 处理自己的业务逻辑
//                EventBus.getDefault().post(new BroadCastEvent(SharePrefrence.BooleanBroadCast));
                } else {
                Toast.makeText(context, "网络异常", Toast.LENGTH_LONG).show();
//                context.startActivity(new Intent(context, BooleanNetWork.class));

//               BaseApplication.getContext().startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("网络异常")
                            .setPositiveButton("确定",null)
                            .setNegativeButton("取消",null)
                            .create()
                            .show();


                }
            }


        }

    }


}
