package com.example.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.customview.R;

/**
 *
 * ClassName:
 * Description:
 * Create by: steven
 * Date: 2018/7/2
 *
 */

public class LoginActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        DelEdit et_account = (DelEdit) findViewById(R.id.et_account);
        DelEdit et_passward = (DelEdit) findViewById(R.id.et_passward);

        et_account.setIconImageBackGround(R.mipmap.ic_launcher);
        et_passward.setIconImageBackGround(R.mipmap.ic_launcher);


    }


}
