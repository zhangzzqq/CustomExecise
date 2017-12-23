package com.example.admin.dialogtest.custom2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.admin.dialogtest.R;

/**
 * Created by stevenZhang on 2017/1/2.
 */

public class CustomActivity2 extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_custom2);

        findViewById(R.id.btn1).setOnClickListener(this);
        
        
        
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                LoadingDialogs dialog=new LoadingDialogs(this,"玩命加载中...");
                    //显示Dialog
                dialog.show();
                    //关闭Dialog
//                dialog.close();

                break;


        }
    }
}
