package com.example.mvpdemo.api;

import com.example.mvpdemo.common.Constant;
import com.example.mvpdemo.utils.FactoryUtils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/4/24.
 */
public class RetrofitWrapper {
    
    private static Retrofit sRetrofit;

    public RetrofitWrapper(){
        
// 1        
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .sslSocketFactory()//为OkHttp对象设置SocketFactory用于双向认证
//                .hostnameVerifier(new UnSafeHostnameVerifier())
//                .build();
 
//2        
        //初始化OkHttpClient对象时进行信任证书的操作
//        OkHttpClient.Builder mBuilder = new OkHttpClient.Builder();
//        try {
//            mBuilder.sslSocketFactory(getSSLSocketFactory())
//                    .hostnameVerifier(org.apache.http.conn.ssl.
//                   SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        OkHttpClient client = mBuilder.build();

//3

        //初始化OkHttpClient对象时进行信任证书的操作
//        OkHttpClient.Builder mBuilder = new OkHttpClient.Builder();
//        mBuilder.sslSocketFactory(TrustAllCerts.createSSLSocketFactory());
//        mBuilder.hostnameVerifier(new TrustAllCerts.TrustAllHostnameVerifier());
//        OkHttpClient client = mBuilder.build();
        
//4        
        
        OkHttpClient client = FactoryUtils.getUnSaveBuilder().build();
        
        sRetrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL2)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        
    }
    
    public static RetrofitWrapper getInstance(){
        return RetrofitHolder.instance;
    }
    
    public static class RetrofitHolder{
        private static RetrofitWrapper instance = new RetrofitWrapper();
    }
    
    public <T> T create(Class<T> clazz){
        return sRetrofit.create(clazz);
    }
    
    
}
