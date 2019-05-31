//package com.example.broadcaststudy;
//
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.util.Log;
//import android.widget.Toast;
//
///**
// * @author 作者 :zhangqi
// * @version 版本号 :
// * @date 创建时间 :2019/5/30
// * @Description 描述 :
// **/
//public class MyBroadcastReceiver extends BroadcastReceiver {
//    private static final String TAG = "MyBroadcastReceiver";
//
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Action: " + intent.getAction() + "\n");
//        sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n");
//        String log = sb.toString();
//        Log.e(TAG, log);
//        Toast.makeText(context, log, Toast.LENGTH_LONG).show();
//    }
//}
