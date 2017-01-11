package com.zhy.sample.test;

import android.content.Context;
import android.view.LayoutInflater;

import com.zhy.adapter.abslistview.MultiItemTypeAdapter;
import com.zhy.adapter.abslistview.ViewHolder;
import com.zhy.adapter.abslistview.base.ItemViewDelegate;

import java.util.List;

/**
 * Created by stevenzhang on 2017/1/11 0011.
 */

public abstract class CommonAdapters<T> extends MultiItemTypeAdapter {
    
    protected Context mContext;
    protected  int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    
    
    public CommonAdapters(final Context context,final int layoutId, final List datas) {
        super(context, datas);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
        
        addItemViewDelegate(new ItemViewDelegate() {
            @Override
            public int getItemViewLayoutId() {
                return layoutId;
            }

            @Override
            public boolean isForViewType(Object item, int position) {
                
                return ;
            }

            @Override
            public void convert(ViewHolder holder, Object o, int position) {

                CommonAdapters.this.convert(holder,o,position);
            }
        });
    }
    
 
}
