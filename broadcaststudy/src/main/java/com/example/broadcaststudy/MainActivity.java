package com.example.broadcaststudy;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    private Button btnBroadCast1;
    private Button btnBroadCast2;
    private Button btnBroadCast3;
    private BroadcastReceiver br;
    private NetworkChangedReceiver networkChangedReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        br = new MyBroadcastReceiver();

        btnBroadCast1 = findViewById(R.id.btn_broadcast1);
        btnBroadCast2 = findViewById(R.id.btn_broadcast2);
        btnBroadCast3 = findViewById(R.id.btn_broadcast3);



        btnBroadCast1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
//                filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
//                registerReceiver(br, filter);


            }
        });

        btnBroadCast2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                NetworkChangedReceiver networkChangedReceiver = new NetworkChangedReceiver();
                IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
                registerReceiver(networkChangedReceiver, intentFilter);
            }
        });

        btnBroadCast3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getViewId() {
        return R.layout.activity_main;
    }


    @Override
    protected void onDestroy() {
        unregisterReceiver(networkChangedReceiver);
        super.onDestroy();
    }

    @Override
    protected void initViews() {

    }


}
