package com.example.mvpdemo.testhttps;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpdemo.R;
import com.example.mvpdemo.api.DemoApi;
import com.example.mvpdemo.api.RetrofitWrapper;
import com.example.mvpdemo.model.entity.GridViewModel;
import com.example.mvpdemo.model.entity.WeiXinModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by stevenzhang on 2017/2/21 0021.
 */

public class Testhttps extends Activity{
    
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_test);
        init();
    }
    private void init() {
//        String url = "https://www.baidu.com/";
//        https://api.weixin.qq.com/sns/oauth2/access_token?
//    // appid=wx971c10ce0155c047
//    // &secret=9d1915c46fb1fda4be0935f15f0230bc
//    // &code=051TPC2H1EQDI40dk23H13lq2H1TPC26
//    // &grant_type=authorization_code  
        tvResult = (TextView) findViewById(R.id.tv_result);
        
        DemoApi demoApi = RetrofitWrapper.getInstance().create(DemoApi.class);
        Call<WeiXinModel> call =  demoApi.getResult("wx971c10ce0155c047","9d1915c46fb1fda4be0935f15f0230bc","051TPC2H1EQDI40dk23H13lq2H1TPC26","");
        call.enqueue(new Callback<WeiXinModel>() {
            @Override
            public void onResponse(Call<WeiXinModel> call, Response<WeiXinModel> response) {
                
                if(response.isSuccessful()){
                    Log.e("Testhttps","statusstatus=="+response.body().getErrcode());
//                    tvResult.setText(response.body().getErrcode());
                    tvResult.setText(response.body().getErrmsg());
                }
            }
            @Override
            public void onFailure(Call<WeiXinModel> call, Throwable t) {

                Log.e("Testhttps","Throwable=="+t.getMessage());
            }
        });
      ////////////////////////////////2///////////////////////////////////////////
//        DemoApi demoApi = RetrofitWrapper.getInstance().create(DemoApi.class);
//        Call<GridViewModel> call =  demoApi.getGridview("1021","111");
//        call.enqueue(new Callback<GridViewModel>() {
//            @Override
//            public void onResponse(Call<GridViewModel> call, Response<GridViewModel> response) {
//                
//                if(response.isSuccessful()){
//                    Log.e("Testhttps","status=="+response.body().getStatus());
//                    tvResult.setText(response.body().getAction());
//                    
//                }
//            }
//            @Override
//            public void onFailure(Call<GridViewModel> call, Throwable t) {
//
//                Log.e("Testhttps","Throwable=="+t.getMessage());
//            }
//        });
//        
//       testRetrofit();
        
    }

    private void testRetrofit() {

        //建立retrofit对象
        Retrofit retrofit = new Retrofit
                .Builder()
//                .baseUrl("https://api.github.com/")
                .baseUrl("https://meiyaoni.com.cn/index.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //获取接口
        DemoApi service = retrofit.create(DemoApi.class);

        //调用方法-返回 回调更换为对象
//        Call<Object> call = service.listRepos("octocat");
//        call.enqueue(new Callback<Object>() {
//            @Override
//            public void onResponse(Call<Object> call, Response<Object> response) {
//             Log.v("Testhttps","response.body()=="+response.body().toString());
//            }
//            @Override
//            public void onFailure(Call<Object> call, Throwable t) {
//                Log.v("Testhttps","t==="+t.toString());
//            }
//        });
        
        ////////////////////////2可以直接访问获取到gridview中的信息/////////////////////////

        Call<GridViewModel> call = service.getGridview("1021","111");
        call.enqueue(new Callback<GridViewModel>() {
                        @Override
            public void onResponse(Call<GridViewModel> call, Response<GridViewModel> response) {
//                Log.v("Testhttps","response.body()=="+response.body().toString());
               if(response.isSuccessful()){
                    Log.v("Testhttps","response.body().getStatus()=="+response.body().getStatus());

                   Toast.makeText(getApplication(),response.body().getList().get(0).getAd_link(),Toast.LENGTH_SHORT).show();
                  }
            }
            @Override
            public void onFailure(Call<GridViewModel> call, Throwable t) {
                Log.v("Testhttps","t==="+t.toString());
            } 
            
        });
        
     
    }
    


}
