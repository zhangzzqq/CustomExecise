package com.example.emptylistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author 作者 :zhangqi
 * @version 版本号 :
 * @date 创建时间 :2019/4/4
 * @Description 描述 :
 **/
public class ListViewTestActivity extends AppCompatActivity {


    private ListView empty_listview_lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        empty_listview_lv = (ListView) findViewById(R.id.empty_listview_lv);
//        String[] mListStr = {"1","2","3","3","4"};
        String[] mListStr = {};
        empty_listview_lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mListStr));
        empty_listview_lv.setEmptyView(findViewById(R.id.empty_imageview_iv));


    }


}
