package com.example.zq.test1;

import com.example.zq.utils.SslFactory;

import javax.net.ssl.SSLSocketFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by stevenzhang on 2016/5/30 0030.
 */
public class RestPool  {
//    private static final OkHttpClient client = new OkHttpClient();
    public static final String BASE_URL = "https://meiyaoni.com.cn/index.php/";
//    public static final String Url_Head_Phone = "https://meiyaoni.com.cn/index.php/WebService?action=10031&key=111";
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
//        try {
//            sslSocketFactory = SSLUtil.getSSLSocketFactory(App.getContext().getAssets().open("service.cer"));
//            client.setSslSocketFactory(sslSocketFactory);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .sslSocketFactory(SSLUtil.getSSLSocketFactory(App.getContext().getAssets().open("service.cer")))
//                .build();

//        .sslSocketFactory(SSLUtil.getSSLSocketFactory(App.getContext().getAssets().open("service.cer")))
        OkHttpClient okHttpClient=null;


            if(okHttpClient==null){
                try {
                    okHttpClient = new OkHttpClient.Builder()
                            .sslSocketFactory(SslFactory.getSSLSocketFactory())
                            .build();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        services = retrofit.create(RestServices.class);
    }

    //获取RestService实例
    public RestServices getServices (){
        return  services;
    }
}
