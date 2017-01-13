package com.example.zq;

import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;

import javax.net.ssl.SSLSocketFactory;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by stevenzhang on 2016/5/30 0030.
 */
public class RestPool  {
    private static final OkHttpClient client = new OkHttpClient();
    public static final String BASE_URL = "https://meiyaoni.com.cn/index.php/";
    //获取实例
    public static RestPool getPool (){

        return  PoolHolder.restPool;
    };

    static class PoolHolder{

        private static RestPool restPool = new RestPool();
    }

    private RestServices services;

    private RestPool(){
        //生产retrofit对象

        SSLSocketFactory sslSocketFactory = null;
        try {
            sslSocketFactory = SSLUtil.getSSLSocketFactory(App.getContext().getAssets().open("service.cer"));
            client.setSslSocketFactory(sslSocketFactory);
       
        } catch (IOException e) {
            e.printStackTrace();
        }
      
        
        
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client()
                .build();
        services = retrofit.create(RestServices.class);
    }

    //获取RestService实例
    public RestServices getServices (){
        return  services;
    }
}
