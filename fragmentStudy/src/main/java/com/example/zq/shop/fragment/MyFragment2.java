package com.example.zq.shop.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.example.zq.shop.Base.BaseFragment;
import com.example.zq.shop.R;
import com.example.zq.shop.widget.ParallaxListView;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment2 extends BaseFragment {

    private View view;
    private boolean isFirst= true;
    
    public MyFragment2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("MyFragment2", "onCreateView1");
        if (view == null) {
            view = inflater.inflate(R.layout.fg2_layout, container, false);
//            TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
//            txt_content.setText("第二个Fragment");
            Log.d("MyFragment2", "onCreateView2");
            isPrepared = true;
        }
//        visiLoad();
        return view;
    }
    
    private void initData() {
        final ParallaxListView plv = (ParallaxListView) view.findViewById(R.id.plv);
        View mHeaderView = View.inflate(getActivity(), R.layout.layout_list_header, null);
        final ImageView iv_header = (ImageView) mHeaderView.findViewById(R.id.iv_header);
        plv.addHeaderView(mHeaderView);
        iv_header.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {/*如果当前布局渲染完毕, 此方法被调用,可以获取宽高,ImageView设置进去*/
                plv.setParallaxImage(iv_header);
                iv_header.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
        plv.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
        Log.d("MyFragment2", "initData2");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyFragment2", "onDestroy");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("MyFragment2", "onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("MyFragment2", "onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("MyFragment2", "onStart");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("MyFragment2", "onActivityCreated");
    }

    @Override
    protected void visiLoad() {
        if(!isVisible||!isFirst||!isPrepared){
            return;
        }
        initData();
        isFirst = false;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("MyFragment2", "onAttach");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("MyFragment2", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("MyFragment2", "onDestroyView");
    }

    

}
