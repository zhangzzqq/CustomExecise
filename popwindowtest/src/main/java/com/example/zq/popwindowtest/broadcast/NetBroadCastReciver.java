//package com.example.zq.popwindowtest.broadcast;
//
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.net.ConnectivityManager;
//import android.net.NetworkInfo;
//
///**
// * ClassName:
// * Description:
// * Create by: steven
// * Date: 2018/6/28
// */
//public class NetBroadCastReciver extends BroadcastReceiver {
//
//    /**
//     * 只有当网络改变的时候才会 经过广播。
//     */
//
//    @Override
//    public void onReceive(Context context, Intent intent) {
//
//        //此处是主要代码，
//        //如果是在开启wifi连接和有网络状态下
//        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
//            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//            NetworkInfo info = intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
//            if (NetworkInfo.State.CONNECTED == info.getState()) {
//                //连接状态 处理自己的业务逻辑
////                EventBus.getDefault().post(new BroadCastEvent(SharePrefrence.BooleanBroadCast));
//            } else {
////                Toast.makeText(context, R.string.no_network, Toast.LENGTH_LONG).show();
////                context.startActivity(new Intent(context, BooleanNetWork.class));
//
////               BaseApplication.getContext().startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
//            }
//        }
//
//
//    }
//
//}
