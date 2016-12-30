package com.ouyben.slidelockview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private Toolbar mToolbar;
    private RelativeLayout mContentMain;
    private ListView mListview;

    private List mList;
    private Context mContext;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();



    }

    private void initData() {
        mContext = this;
        mList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            mList.add("");
        }
        mAdapter = new MyAdapter(mContext, mList);
        mListview.setAdapter(mAdapter);
    }

    private void initView() {
//        mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        mToolbar.setTitle("滑动解锁");
//        setSupportActionBar(mToolbar);

        mContentMain = (RelativeLayout) findViewById(R.id.content_main);
        mListview = (ListView) findViewById(R.id.listview);
    }







}
