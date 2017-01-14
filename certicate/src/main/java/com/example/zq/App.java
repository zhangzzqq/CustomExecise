package com.example.zq;

import android.app.Application;
import android.content.Context;

/**
 * Created by stevenzhang on 2017/1/13 0013.
 */

public class App extends Application {
    
    
    private static  Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        
        context = getApplicationContext();

    }


    public static  Context getContext() {
        return context;
    }
}
