package com.example.zq.shop.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;


/**
 * Created by stevenzhang on 2016/5/31 0031.
 */
public abstract class BaseFragment extends Fragment {
    protected boolean isVisible;
    protected boolean isPrepared = false;
    //fragment的创建
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(getUserVisibleHint()){
            
            isVisible = true;
            onVisible();
        }else {
            
            isVisible = false;
            onInvisible();
        }
    }

    //不可见状态
    protected  void onInvisible(){

    };

    //可见状态
    protected  void onVisible(){
        //可见的状态才会加载数据
        visiLoad();

    };

    //延时加载
    protected abstract  void visiLoad();

    @Override
    public void onDestroy() {
        super.onDestroy();
    
    }
}
