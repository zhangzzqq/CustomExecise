package com.example.broadcaststudy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.broadcaststudy.utils.NetworkUtil;

/**
 * @author 作者 :zhangqi
 * @version 版本号 :
 * @date 创建时间 :2019/5/31
 * @Description 描述 :
 **/
public class NetworkChangedReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int netWorkStates = NetworkUtil.getNetWorkStates(context);

        switch (netWorkStates) {
            case NetworkUtil.TYPE_NONE:
                //断网了
                Toast.makeText(context,"断网了",Toast.LENGTH_LONG).show();
                break;
            case NetworkUtil.TYPE_MOBILE:
                //打开了移动网络"10....."
                Toast.makeText(context,"打开了移动网络",Toast.LENGTH_LONG).show();
                break;
            case NetworkUtil.TYPE_WIFI:
                //打开了WIFI
                Toast.makeText(context,"打开了WIFI",Toast.LENGTH_LONG).show();
                break;

            default:
                break;
        }
    }
}
