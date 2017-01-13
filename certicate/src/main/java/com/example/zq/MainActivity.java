package com.example.zq;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;

import javax.net.ssl.SSLSocketFactory;

import cn.edu.zafu.bmobdemo.R;

/**
 * Created by stevenzhang on 2017/1/13 0013.
 */

public class MainActivity extends Activity{
//
//    @GET("/WebService")
//    Call<GridviewModule> getResult(@Query("action") String action, @Query("key") String key);
    private static final OkHttpClient client=new OkHttpClient();
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
                try {
                    SSLSocketFactory sslSocketFactory = SSLUtil.getSSLSocketFactory(getAssets().open("service.cer"));
                    client.setSslSocketFactory(sslSocketFactory);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                
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
//                    public void onFailure(Request request, IOException e)
//                    {
//                    }
//
//                    @Override
//                    public void onResponse(final Response response) throws IOException
//                    {
//                        htmlStr = response.body().string();
//                        
//                      runOnUiThread(new Runnable() {
//                          @Override
//                          public void run() {
//                              result.setText(htmlStr);  
//                          }
//                      });
//                                
//                       
//                    }
//                });
                
                
                ////////////////////////retrofit///////////////////////////
                
                RestPool pool = RestPool.getPool();
                RestServices services = pool.getServices();

                retrofit2.Call call2 = services.getResult("10031","111");
                
                call2.enqueue(new retrofit2.Callback() {
                    @Override
                    public void onResponse(retrofit2.Call call, retrofit2.Response response) {
                        
                        if(response.isSuccessful()){
                            
                           result.setText(response.body().toString()); ;
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
