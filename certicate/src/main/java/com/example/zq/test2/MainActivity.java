package com.example.zq.test2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zq.test1.GridviewModule;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.edu.zafu.bmobdemo.R;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by stevenZhang on 2017/1/13.
 */

public class MainActivity extends Activity {

    @BindView(R.id.et_phone_num)
    EditText etPhoneNum;
    @BindView(R.id.tv_phone_location)
    TextView tvPhoneLocation;
    private PhoneService mService;
    public static final String BASE_URL = "https://meiyaoni.com.cn/index.php/";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        mService = PhoneApi.getApi().getService();
        
    }

    @OnClick({R.id.btn_get_phone_location, R.id.btn_get_phone_location_rxjava})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_get_phone_location:

                initData();
                break;
            
            case R.id.btn_get_phone_location_rxjava:
                
                break;
        }
    }

    private void initData() {


//        builder.sslSocketFactory(ZiQianMingUtils.getSSLSocketFactory()).hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        
//        OkHttpClient okHttpClient = new OkHttpClient();
//        okHttpClient.sslSocketFactory()
        
        //1.创建Retrofit对象 attention注意添加 addConverterFactory(GsonConverFactory.create())转换
        Retrofit retrofit = null;
        try {
            retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .client(builder.sslSocketFactory(ZiQianMingUtils.getSSLSocketFactory()).build())
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //2.创建访问API的请求
        PhoneService service = retrofit.create(PhoneService.class);
        Call<GridviewModule> result = service.getResult("10031","111");

        //3.发送请求
        result.enqueue(new Callback<GridviewModule>() {
            @Override
            public void onResponse(Call<GridviewModule> call, Response<GridviewModule> response) {
                //4.处理结果
                Log.e("MainActivity0", "=====1==="+response.body());
                if(response.isSuccessful()){
                    GridviewModule module = (GridviewModule) response.body();
                    tvPhoneLocation.setText(module.getList().toString()); ;
                }
            }

            @Override
            public void onFailure(Call<GridviewModule> call, Throwable t) {
                Log.e("MainActivity0", "onFailure=" + t.getMessage());
                Toast.makeText(MainActivity.this, "获取错误", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
