package com.example.mvpdemo.api;

import com.example.mvpdemo.model.entity.Result;
import com.example.mvpdemo.model.entity.Result2;
import com.example.mvpdemo.model.entity.WeatherInfo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2016/4/24.
 */
public interface DemoApi {
    @GET("{cityId}.html")
    Call<WeatherInfo> getWeatherInfo(@Path("cityId") String cityId);
    
    
    @FormUrlEncoded
    @GET("/access_token")
    Call<Result> 
    getResult(@Field("appid") String appid,
              @Field("secrect") String secrect,
              @Field("code") String code,
              @Field("grant_type") String grant_type);

//WebService?action=1021&key=111
    @FormUrlEncoded
    @POST("/WebService")
    Call<Result2> getResult2(@Field("action") String action, @Field("key") String key);


}
