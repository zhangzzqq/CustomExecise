package com.zhy.sample.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.sample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stevenzhang on 2017/1/11 0011.
 */

public class multiRecyclerView extends Activity {

    private RecyclerView multiRecycler;

    private List<Object> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_multirecycler);
        multiRecycler = (RecyclerView) findViewById(R.id.multirecycler);
        multiRecycler.setLayoutManager(new LinearLayoutManager(this));

        CommonAdapters  adapter = new CommonAdapters(this,R.layout.activity_main, list){

//            @Override
//            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//            }
            
            @Override
            protected void convert(ViewHolder holder, Object o, int position) {
                
                
            }
            
            
        };

        adapter.addItemViewDelegate(new ItemViewDelegate() {
            @Override
            public int getIt0emViewLayoutId() {
                return ;
            }

            @Override
            public boolean isForViewType(Object item, int position) {
                
                return false;
            }

            @Override
            public void convert(ViewHolder holder, Object o, int position) {
            
                                    
            }
        });


        multiRecycler.setAdapter(adapter);
    }


 
    
    
}
