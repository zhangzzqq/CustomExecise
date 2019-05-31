package com.example.broadcaststudy;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * @author 作者 :zhangqi
 * @version 版本号 :
 * @date 创建时间 :2019/5/31
 * @Description 描述 :
 **/
public abstract class BaseActivity  extends AppCompatActivity {
    //网络状态监听库
    NetWorkStateReceiver netWorkStateReceiver;
    private static final String TAG = "BaseActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewId());
        initViews();

    }
    public abstract int getViewId();
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    protected abstract void initViews();

    @Override
    protected void onResume() {
        if (netWorkStateReceiver == null) {
            netWorkStateReceiver = new NetWorkStateReceiver();
        }
//        IntentFilter filter = new IntentFilter();
//        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
//        registerReceiver(netWorkStateReceiver, filter);
//        Log.e(TAG,"注册");
        super.onResume();
    }

    //onPause()方法注销
    @Override
    protected void onPause() {
//        unregisterReceiver(netWorkStateReceiver);
        Log.e(TAG,"注销");
        super.onPause();
    }

}
