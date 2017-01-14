package com.example.zq;

import android.app.Application;
import android.content.Context;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.https.HttpsUtils;

import okhttp3.OkHttpClient;

/**
 * Created by stevenzhang on 2017/1/13 0013.
 */

public class App extends Application {
    
    
    private static  Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        
        context = getApplicationContext();
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);
        
        
    }


    public static  Context getContext() {
        return context;
    }
}
