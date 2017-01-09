package com.example.zq.shop.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.zq.shop.Base.BaseFragment;
import com.example.zq.shop.ui.OtherActivity;
import com.example.zq.shop.R;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment4 extends BaseFragment {

    private View view;
    private boolean isFirst = true;
    public MyFragment4() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("MyFragment4", "onCreateView1");
        if(view==null){
            view = inflater.inflate(R.layout.fg_content,container,false);
            TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
            txt_content.setText("第四个Fragment");
            Log.d("MyFragment4", "onCreateView2");
             Button button = (Button) view.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),OtherActivity.class);
                    startActivity(intent);
//                    调用这个会把当前的fragment销毁，及会调用ondestroy方法销毁当前fragment
//                    getActivity().finish();
                }
            });
        }

        visiLoad();
        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyFragment4", "onDestroy");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("MyFragment4", "onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("MyFragment4", "onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("MyFragment4", "onStart");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("MyFragment4", "onActivityCreated");
    }

    @Override
    protected void visiLoad() {

        if(!isVisible||!isFirst||!isPrepared){
            return;
        }
        isFirst = false;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("MyFragment4", "onAttach");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("MyFragment4", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("MyFragment4", "onDestroyView");
    }

}
