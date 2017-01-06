package com.example.zq.toolstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private long lastClickTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnBackPress = (Button) findViewById(R.id.btn_back_press);
        btnBackPress.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_back_press:
                
                break;
        }
    }

    /**
     * lastClickTime 记录最后一次返回键的时间，默认是0
     * currentClickTime 记录当前的时间
     */
    
    @Override
    public void onBackPressed() {
        
       if(lastClickTime<=0){
            Toast.makeText(this,"再按一次退出",Toast.LENGTH_SHORT).show();
           lastClickTime = System.currentTimeMillis();
        }else {
           //1000代表1秒
            long currentClickTime = System.currentTimeMillis();
           if(currentClickTime-lastClickTime<1000){
               finish();
           }else {
               Toast.makeText(this,"再按一次退出",Toast.LENGTH_SHORT).show();
               lastClickTime = currentClickTime;
           }
       }
    }
    
}
