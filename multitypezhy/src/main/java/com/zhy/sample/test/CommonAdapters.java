package com.zhy.sample.test;

import android.content.Context;
import android.view.LayoutInflater;

import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by stevenzhang on 2017/1/11 0011.
 */


public  abstract  class CommonAdapters<T> extends com.zhy.adapter.recyclerview.MultiItemTypeAdapter<T> {
    
    protected Context mContext;
    protected  int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    
    
    public CommonAdapters(final Context context,final int layoutId, final List<T> datas) {
        super(context, datas);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
        
        addItemViewDelegate(new ItemViewDelegate<T>() {

            @Override
            public int getItemViewLayoutId() {
                return layoutId;
            }

            @Override
            public boolean isForViewType(T item, int position) {
                //本item type
                return true;
            }

            @Override
            public void convert(ViewHolder holder, T o, int position) {
                
                convert(holder,o,position);
            }
        });
        
    }

    
    protected abstract void convert(ViewHolder holder ,Object o ,int position);
    
    
    
 
}
