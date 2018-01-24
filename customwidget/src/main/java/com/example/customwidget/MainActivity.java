package com.example.customwidget;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by steven on 2017/12/29.
 *
 * 实现功能：
 *
 *
 * 注意事项：
 *
 *  public void setBounds (int left, int top, int right, int bottom)
 */
public class MainActivity extends AppCompatActivity {

    private TextView tvCustomTest;
    private Button bgCommit;
    private DIYEditTextAccount etAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCustomTest = (TextView) findViewById(R.id.tv_custom_test);
        bgCommit = (Button) findViewById(R.id.bg_commit);
        etAccount = (DIYEditTextAccount) findViewById(R.id.et_account);

        /**
         * 计算账户控件的宽度
         */

    }


    public void tvCustomTest(View view){

//      Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher_round);
        Drawable drawable = ContextCompat.getDrawable(this,R.mipmap.ic_launcher_round);
        drawable.setBounds(0, 0, 128, 128);//设置一个一定大小的矩形区域，来显示drawable
        tvCustomTest.setCompoundDrawables(drawable, drawable, drawable, drawable);//把drawable设置进来，左上右下都可以设置


        Log.e(MainActivity.class.getName(),"bgCommitWidth=="+bgCommit.getWidth());

        Log.e(MainActivity.class.getName(),"accountWidth=="+etAccount.getWidth());

    }


    public void bgCommit(View view){

        startActivity(new Intent(this,CanvasTest.class));
    }



}
