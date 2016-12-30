package com.example.zq.popwindowtest;

import android.app.Activity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by stevenzhang on 2016/12/19 0019.
 * 这个类的用法与CustomPopWindow用法类似，可以直接参考customPopwindow
 */

public class OrderPopWindow {
    private  static final String TAG ="OrderPopWindow";
    private PopupWindow popupWindow;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tvCancel;
    private TextView tvConfirm;
    private View view;
    private ImageView ivPopPic;
    private TextView title;
    private Activity activity;
    private String token ;
    
    public OrderPopWindow(Activity activity, TextView title, String token) {
        this.activity = activity;
        this.title = title;
        this.token = token;
    }

    //popwindow 1跳到订单页 0取消popwindow  2 dialog判断
    private  View.OnClickListener clicks = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                //1直接取消，2进行dialog提示
                case R.id.tv_cancel :
                    popupWindow.dismiss();
                    break;
                // 1订单跳转，在dialog逻辑中跳转 ，0直接取消
                case R.id.tv_confirm :
                    popupWindow.dismiss();
                    break;
           
            }
        }
    };
    
    public  void popWindow(String json){
//        DensityUtils.dp2px(getContext(),56);
        if(activity!=null){
            LayoutInflater inflater = LayoutInflater.from(activity);
            view = inflater.inflate(R.layout.receive_order_detail,null);
            ivPopPic = (ImageView) view.findViewById(R.id.iv_pop_pic);
            tv1 = (TextView) view.findViewById(R.id.tv1);
            tv2 = (TextView) view.findViewById(R.id.tv2);
            tv3 = (TextView) view.findViewById(R.id.tv3);
            tv4 = (TextView) view.findViewById(R.id.tv4);
            tv5 = (TextView) view.findViewById(R.id.tv5);
            tvCancel = (TextView) view.findViewById(R.id.tv_cancel);
            tvConfirm = (TextView) view.findViewById(R.id.tv_confirm);
            tvCancel.setOnClickListener(clicks);
            tvConfirm.setOnClickListener(clicks);

//            Display display = activity.getWindowManager().getDefaultDisplay();
//            Point size = new Point();//创建一个point点
//            display.getSize(size);//获取当前屏幕尺寸信息
//            int width = size.x;
//            int height = size.y- DensityUtils.dp2px(getContext(),56);
        }
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,true);
//        popupWindow.setBackgroundDrawable(new BitmapDrawable()); //方法1Android popupWindow响应back按键并关闭,方法2但是也可以手动的监听返回事件
        popupWindow.setOutsideTouchable(false);
//        WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
//        params.alpha = 0.4f;
//        getActivity().getWindow().setAttributes(params);//把该参数对象设置进当前界面中
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            //设置PopupWindow退出监听器  
            @Override
            public void onDismiss() {
                //如果PopupWindow消失了，即退出了，那么触发该事件，然后把当前界面的透明度设置为不透明  
//                WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
//                params.alpha = 1.0f;//设置为不透明，即恢复原来的界面  
//                getActivity().getWindow().setAttributes(params);
                popupWindow.dismiss();
            }
        });
            popupWindow.showAtLocation(title, Gravity.CENTER, 0, 0);
        
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK){
                    return  true;
                }
                return false;
            }
        });
    }
}
