package com.example.mvpdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.mvpdemo.api.DemoApi;
import com.example.mvpdemo.api.RetrofitWrapper;
import com.example.mvpdemo.model.entity.Result2;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        tvResult = (TextView) findViewById(R.id.tv_result);

        DemoApi demoApi = RetrofitWrapper.getInstance().create(DemoApi.class);
        
        Call<Result2> call =  demoApi.getResult2("1021","111");
        call.enqueue(new Callback<Result2>() {
            @Override
            public void onResponse(Call<Result2> call, Response<Result2> response) {
                
                if(response.isSuccessful()){
                    
//                    response.body().getErrmsg();
                    Log.e("Testhttps","status=="+response.body().getStatus());
                    tvResult.setText(response.body().getAction());
                    
                }
            }

            @Override
            public void onFailure(Call<Result2> call, Throwable t) {

                Log.e("Testhttps","Throwable=="+t.getMessage());
            }
        });
        
    }


}
