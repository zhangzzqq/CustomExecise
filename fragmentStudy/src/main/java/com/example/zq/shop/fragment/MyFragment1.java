package com.example.zq.shop.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zq.shop.Base.BaseFragment;
import com.example.zq.shop.R;

/**
 * Created by Jay on 2015/8/28 0028.
 */

public class MyFragment1 extends BaseFragment {

    private Boolean isFirst = true;
    private View view;
    public MyFragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("MyFragment1", "onCreateView1");
        if (view == null) {
            view = inflater.inflate(R.layout.fg_content, container, false);
            Log.d("MyFragment1", "onCreateView2");
            isPrepared = true;
        }
        visiLoad();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("MyFragment1", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("MyFragment1", "onPause");
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d("MyFragment1", "onStart");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("MyFragment1", "onActivityCreated");
    }

    //isVisible是可以判断fragment不可见的情况(没有切换到当前tab)
    @Override
    protected void visiLoad() {
        if(!isVisible||!isFirst||!isPrepared){
            return;
        }
        initData();
        isFirst = false;
    }

    private void initData() {

        Log.d("MyFragment1", "initData");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("MyFragment1", "onAttach");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("MyFragment1", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("MyFragment1", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyFragment1", "onDestroy");
    }
}
