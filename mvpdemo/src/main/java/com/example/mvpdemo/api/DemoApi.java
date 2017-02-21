package com.example.mvpdemo.api;

import com.example.mvpdemo.model.entity.GridViewModel;
import com.example.mvpdemo.model.entity.Result;
import com.example.mvpdemo.model.entity.GridViewTest;
import com.example.mvpdemo.model.entity.WeatherInfo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

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
    @POST("WebService")//多了一个下划线让自己找了两个星期
    Call<GridViewTest> getResult2(@Field("action") String action, @Field("key") String key);

    //https://www.baidu.com/?tn=62095104_oem_dg
    
    @GET("users/{user}/repos")
    Call<Object> listRepos(@Path("user") String user);  
    
    //WebService?action=1021&key=111
    @GET("WebService")
    Call<GridViewModel> getGridview(@Query("action") String action, @Query("key") String key);
}
