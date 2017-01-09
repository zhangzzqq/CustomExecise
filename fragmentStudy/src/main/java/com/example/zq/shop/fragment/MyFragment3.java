package com.example.zq.shop.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zq.shop.Base.BaseFragment;
import com.example.zq.shop.R;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment3 extends BaseFragment {

    private View view;
    private boolean isFirst= true;
    public MyFragment3() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("MyFragment3", "onCreateView1");
        if(view==null){
            view = inflater.inflate(R.layout.fg_content,container,false);
            TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
            txt_content.setText("第三个Fragment");
            Log.d("MyFragment3", "onCreateView2");
        }

        visiLoad();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyFragment3", "onDestroy");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("MyFragment3", "onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("MyFragment3", "onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("MyFragment3", "onStart");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("MyFragment3", "onActivityCreated");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("MyFragment3", "onAttach");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("MyFragment3", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("MyFragment3", "onDestroyView");
    }

    @Override
    protected void visiLoad() {
        if(!isVisible||!isFirst||!isPrepared){
            return;
        }
        isFirst = false;
    }
}
