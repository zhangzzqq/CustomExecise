package com.example.zq.eventdispatch.dierhangdaima;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;

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
        
    }

    
    
    
}
