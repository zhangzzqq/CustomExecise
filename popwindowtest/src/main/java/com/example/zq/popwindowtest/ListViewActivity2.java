package com.example.zq.popwindowtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.zq.popwindowtest.adapter.ListAdapters;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);


       ListView listView = (ListView) findViewById(R.id.lv_list);

        ListAdapter listAdapter = new ListAdapters(getData(),this);
        listView.setAdapter(listAdapter);


    }

    private List<String >  getData() {

        List list = new ArrayList();
        for(int i=0;i<16;i++){

            list.add(""+i);

        }

        return list;
    }


}
