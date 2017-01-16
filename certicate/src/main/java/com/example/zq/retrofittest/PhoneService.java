package com.example.zq.retrofittest;

import com.example.zq.test1.GridviewModule;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zhangshan on 16/9/8 上午10:44.
 */
public interface PhoneService {

    @GET("/WebService")
    Call<GridviewModule> getResult(@Query("action") String action, @Query("key") String key);

    @GET("otn/")
    Call<String> getResult2();



}
