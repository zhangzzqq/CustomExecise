package com.example.zq;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 1.  Service 接口  工程中所用到的请求后端的接口
 * 2.    RestPool 类  网络请求配置类
 */
public interface RestServices {
    //"http://meiyaoni.com.cn/WebService?" "/action=1003&key=111"
    @GET("/WebService")
    Call<GridviewModule> getResult(@Query("action") String action, @Query("key") String key);
  
        
}

