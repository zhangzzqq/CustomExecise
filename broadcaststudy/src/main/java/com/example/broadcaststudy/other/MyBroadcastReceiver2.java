//package com.example.broadcaststudy;
//
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.os.AsyncTask;
//import android.util.Log;
//import android.widget.Toast;
//
///**
// * @author 作者 :zhangqi
// * @version 版本号 :
// * @date 创建时间 :2019/5/31
// * @Description 描述 :
// **/
//public class MyBroadcastReceiver2 extends BroadcastReceiver {
//    private static final String TAG = "MyBroadcastReceiver2";
//        private static Context mContext;
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        final PendingResult pendingResult = goAsync();
//        Task asyncTask = new Task(pendingResult, intent);
//        asyncTask.execute();
//        this.mContext = context;
//    }
//
//    private static class Task extends AsyncTask<String, Integer, String> {
//
//        private final PendingResult pendingResult;
//        private final Intent intent;
//        private Context context= mContext;
//
//        private Task(PendingResult pendingResult, Intent intent) {
//            this.pendingResult = pendingResult;
//            this.intent = intent;
//        }
//
//        @Override
//        protected String doInBackground(String... strings) {
//            StringBuilder sb = new StringBuilder();
//            sb.append("Action: " + intent.getAction() + "\n");
//            sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n");
//            String log = sb.toString();
//            Log.e(TAG, log);
//
//            return log;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
////            Toast.makeText(context, s, Toast.LENGTH_LONG).show();
//            // Must call finish() so the BroadcastReceiver can be recycled.
//            pendingResult.finish();
//        }
//    }
//}
