package com.example.zq;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import cn.edu.zafu.bmobdemo.R;

/**
 * Created by stevenzhang on 2017/1/13 0013.
 */

public class MainActivity extends Activity{
//
//    @GET("/WebService")
//    Call<GridviewModule> getResult(@Query("action") String action, @Query("key") String key);
//    private static final OkHttpClient client=new OkHttpClient();
    private TextView result;
    public static final String Url_Head_Phone = "https://meiyaoni.com.cn/index.php/WebService?action=10031&key=111";

    private String htmlStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.tv_result);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                try {
//                    SSLSocketFactory sslSocketFactory = SSLUtil.getSSLSocketFactory(getAssets().open("service.cer"));
//                    client.setSslSocketFactory(sslSocketFactory);
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                
//                //创建okHttpClient对象
//                OkHttpClient mOkHttpClient = new OkHttpClient();
//                 //创建一个Request
//                final Request request = new Request.Builder()
//                        .url(Url_Head_Phone)
//                        .build();
//            //new call
//                Call call = mOkHttpClient.newCall(request);
//            //请求加入调度
//                call.enqueue(new Callback()
//                {
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//
//                    }
//
//                    @Override
//                    public void onResponse(Call call, Response response) throws IOException {
//                        htmlStr = response.body().string();
//
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                result.setText(htmlStr);
//                            }
//                        });
//                    }
//                });
//                SSLSocketFactory sslSocketFactory = SSLUtil.getSSLSocketFactory(getAssets().open("service.cer"));
//                client.setSslSocketFactory(sslSocketFactory);

//                OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
//                OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                        .sslSocketFactory(SSLUtil.getSSLSocketFactory(getAssets().open("service.cer")))
//                       .build();
                
                ////////////////////////retrofit///////////////////////////
                
                RestPool pool = RestPool.getPool();
                RestServices services = pool.getServices();

                retrofit2.Call<GridviewModule> call2 = services.getResult("10031","111");
                System.out.print("=====0===");
                call2.enqueue(new retrofit2.Callback() {

                    @Override
                    public void onResponse(retrofit2.Call call, retrofit2.Response response) {

                        System.out.print("=====1==="+response.body());
                        if(response.isSuccessful()){

                            GridviewModule module = (GridviewModule) response.body();
                           result.setText(module.getList().get(0).getCat_name()); ;
                        }
                    }

                    @Override
                    public void onFailure(retrofit2.Call call, Throwable t) {


                        Log.v("MainActivity","=="+t.toString());
                    }
                });




            }
        });
    }
}
