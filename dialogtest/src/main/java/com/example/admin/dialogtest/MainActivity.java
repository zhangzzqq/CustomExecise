package com.example.admin.dialogtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.admin.dialogtest.adapter.DataAdapter;
import com.example.admin.dialogtest.crazyAndroid.CrazyDialogTest;
import com.example.admin.dialogtest.custom.CustomDialog;
import com.example.admin.dialogtest.custom2.CustomActivity2;
import com.example.admin.dialogtest.custom3.SampleActivity;
import com.example.admin.dialogtest.nomal.NomalActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steven on 2017/11/7 0007.
 */

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_activity);

        initView();
        initData();

        intClick();

    }


    private void initView() {

        listView = (ListView) findViewById(R.id.ll_list);

    }

    private void initData() {

        DataAdapter adapter = new DataAdapter(getData(), MainActivity.this);
        listView.setAdapter(adapter);


    }

    private void intClick() {


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {

                    case 0:

                        startActivity(new Intent(MainActivity.this, CrazyDialogTest.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, CustomDialog.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, CustomActivity2.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, SampleActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, NomalActivity.class));
                        break;



                }
            }
        });
    }


    public List<String> getData() {
        List<String> list = new ArrayList<>();
        list.add("crazAndroid");
        list.add("custom");
        list.add("custom2");
        list.add("custom3");
        list.add("nomalDialog");
        return list;
    }
}
