package com.example.zq.eventdispatch.dierhangdaima;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by stevenzhang on 2017/2/7 0007.
 */

public class MainActivity extends Activity {
    
    private View  view;
    private Object object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //alertdialog
        AlertDialog.Builder dialog  = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("This is a Dialog");
        dialog.setMessage("Something important.");
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                
            }
        });
        
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                
            }
        });
        
        
        dialog.show();
        
        
        
        //ProgressDialog 进度条
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        
        progressDialog.setTitle("This is a ProgressDialog");
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(true);
        progressDialog.show();


/**listview getview() setTag     view.setTag();
 * 
 * listview 优化是convertview的复用（判断）和减少findviewbyid 所用用到了内部类viewHolder 
 *
 */
        
        
// setTag()用于给View添加额外的数据，可以使用getTag()方法获取出这个额外的数据。
        
        view.setTag(object); //把对象object存储在view中，然后下面的代码重新获取  
        
        
        //  访问网络

        HttpURLConnection httpURLConnection = null;
        BufferedReader reader = null;
        try {
            
            URL url = new URL("http://www.baidu.com");
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(8000);
            httpURLConnection.setReadTimeout(8000);
            InputStream in = httpURLConnection.getInputStream();
            //对获取的输入流进行读取
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder response = new StringBuilder();
            String line;
            while((line=reader.readLine())!=null){
                
                response.append(line);
            }
            showResponse(response.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader !=null){

                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            if(httpURLConnection!=null){
                
                httpURLConnection.disconnect();
            }
        }


    }

    private void showResponse(String s) {
        //用下面这个方法切换到主线程
        
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //在这里进行UI操作，将结果显示到界面上
                //responseText.setText(response);
            }
        });
        
    }


}
