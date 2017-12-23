package com.example.admin.dialogtest.nomal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.admin.dialogtest.R;
import com.example.admin.dialogtest.bochidialog.SimpleDialog;

public class NomalActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);

    }



    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn1:

                LoadingDialog dialog = new LoadingDialog(this);
                dialog.setText("加载中...");
                dialog.show();
                break;

            case R.id.btn2:

                SimpleDialog simpleDialog = new SimpleDialog(this);
                simpleDialog.showWaitDialog("加载中...");
                break ;

            case R.id.btn3:

                break ;

            case R.id.btn4:

                break;


        }

    }


}
