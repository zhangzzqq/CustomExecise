package com.example.zq.popwindowtest;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv;
    private Button button1;
    private Button btnShare;
    private LinearLayout llRoot;
    private Button edit;
    private Button btnTest;
    private Button listViewTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llRoot = (LinearLayout) findViewById(R.id.activity_main);

        edit = (Button) findViewById(R.id.edit);
        button1 = (Button) findViewById(R.id.btn1);
        btnShare = (Button) findViewById(R.id.share);
        btnTest = (Button) findViewById(R.id.btntest);
        listViewTest = (Button) findViewById(R.id.listviewtest);

        button1.setOnClickListener(this);
        btnShare.setOnClickListener(this);
        edit.setOnClickListener(this);
        btnTest.setOnClickListener(this);
        listViewTest.setOnClickListener(this);

        setBreoadcast();

    }



    /**
     * 设置网络监听
     * https://blog.csdn.net/qq_20785431/article/details/51520459
     */
    private void setBreoadcast() {

        BroadcastReceiver receiver=new NetBroadCastReciver();
        IntentFilter filter=new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, filter);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("alertDialogTest")
                .setPositiveButton("确定",null)
                .setNegativeButton("取消",null)
                .create()
                .show();

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                ChatPopWindow popWindow = new ChatPopWindow(this);
                popWindow.showPopupWindow(button1);
                break;

            case R.id.share:
                final SharePopWindow customPopWindow = new SharePopWindow(this, btnShare);
                customPopWindow.setCancelButtonOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        customPopWindow.dismiss();
                    }
                });

                customPopWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        //对象是一个HashMap对象

                        HashMap<String, Object> item = (HashMap<String, Object>) adapterView.getItemAtPosition(i);
                    }
                });
                break;
            //edit
            case R.id.edit:

                ListPopupWindow listPopupWindow = new ListPopupWindow(this, llRoot);
                listPopupWindow.showLocation();
                break;

            case R.id.btntest:
                startActivity(new Intent(MainActivity.this, TestPopWindow.class));
                break;
            case R.id.listviewtest:
//                startActivity(new Intent(MainActivity.this, ListViewActivity2.class));

//                String str =null;
//                //equals是用来比较对象是否相等
//                if(str.equals("1")){
//
//                    Log.d("MainActivity","16278346");
//                }


//                boolean isshown = btnTest.isShown();
//                boolean isshown = btnTest.getVisibility();

                boolean isshown;

                if(btnTest.getVisibility()==View.VISIBLE){
                    isshown =true;
                }else {
                    isshown=false;
//                    btnTest.setVisibility(View.VISIBLE);
                }

                if (isshown) {
                    Toast.makeText(MainActivity.this, "显示", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "没有显示", Toast.LENGTH_SHORT).show();

                }

                break;


        }
    }

    public void button1(View view){

        startActivity(new Intent(this,Main2Activity.class));
    }


}
