package com.example.zq.okhttptest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import cn.edu.zafu.bmobdemo.R;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/**
 * Created by stevenzhang on 2017/1/14 0014.
 */

public class MainActivity extends Activity implements View.OnClickListener {


    private OkHttpClient client;
    private Button btn2;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_test2);
        btn2 = (Button) findViewById(R.id.btn2);
        tv2 = (TextView) findViewById(R.id.tv2);
        btn2.setOnClickListener(this);
        
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            
            case R.id.btn2:
                getRequest();
                break;
            
            
        }
    }


    private void getRequest() {

//        calljava.security.cert.CertPathValidatorException: 
// Trust anchor for certification path not found.
        OkHttpUtils
                .get()
                .url("https://kyfw.12306.cn/otn/")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        
                        Log.e("MainActivity4","call"+e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                    
                     String a =  response.toString();
                        tv2.setText(a);
                        
                    }
                });
                
    }
  

}
