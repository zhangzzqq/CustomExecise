package com.example.mvpdemo.api;

import com.example.mvpdemo.model.entity.GridViewModel;
import com.example.mvpdemo.model.entity.GridViewTest;
import com.example.mvpdemo.model.entity.WeatherInfo;
import com.example.mvpdemo.model.entity.WeiXinModel;

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

//    https://api.weixin.qq.com/sns/oauth2/access_token?
//    // appid=wx971c10ce0155c047
//    // &secret=9d1915c46fb1fda4be0935f15f0230bc
//    // &code=051TPC2H1EQDI40dk23H13lq2H1TPC26
//    // &grant_type=authorization_code   
    @FormUrlEncoded
    @POST("access_token")
    Call<WeiXinModel> 
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
