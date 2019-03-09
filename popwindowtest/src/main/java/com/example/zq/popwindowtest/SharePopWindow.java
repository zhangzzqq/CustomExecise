package com.example.zq.popwindowtest;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by stevenzhang on 2016/12/29 0029.
 */

public class SharePopWindow {

    private PopupWindow popupWindow;
    private GridView gridView;
    private TextView cancelButton;
    private SimpleAdapter saImageItems;
    private int[] image = {R.mipmap.logo_sinaweibo, R.mipmap.logo_wechat, R.mipmap.logo_wechatmoments, R.mipmap.logo_qq};
    private String[] name = {"微博", "微信好友", "微信朋友圈", "QQ"};
    public SharePopWindow(final Activity act, View v) {
        View convertView = LayoutInflater.from(act).inflate(R.layout.share_dialog,null);
        popupWindow = new PopupWindow(convertView, 300,ViewGroup.LayoutParams.WRAP_CONTENT,true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        setBackgroundAlpha(act, 0.4f);
        //在最底部显示
        popupWindow.showAtLocation(v, Gravity.AXIS_X_SHIFT | Gravity.BOTTOM, -100, 100);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = act.getWindow().getAttributes();
                lp.alpha = 1f;
                act.getWindow().setAttributes(lp);
            }
        });

        gridView = (GridView) convertView.findViewById(R.id.share_gridView);
        cancelButton = (TextView) convertView.findViewById(R.id.share_cancel);
        List<HashMap<String, Object>> shareList = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < image.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("itemImage", image[i]);//添加图像资源的ID
            map.put("itemText", name[i]);//按序号做ItemText
            shareList.add(map);
        }

        saImageItems = new SimpleAdapter(act, shareList, R.layout.share_item, new String[]{"itemImage", "itemText"}, new int[]{R.id.imageView1, R.id.textView1});
        gridView.setAdapter(saImageItems);
    }

    public void setCancelButtonOnClickListener(View.OnClickListener Listener) {
        cancelButton.setOnClickListener(Listener);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        gridView.setOnItemClickListener(listener);
    }

    /**
     * 关闭对话框
     */
    public void dismiss() {
        if(popupWindow!=null){
            popupWindow.dismiss();
        }
    }
    /**
     * 设置页面activity的透明度
     * @param bgAlpha 1表示不透明
     */
    public static void setBackgroundAlpha(Activity activity, float bgAlpha) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        if (bgAlpha == 1) {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);//不移除该Flag的话,在有视频的页面上的视频会出现黑屏的bug
        } else {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);//此行代码主要是解决在华为手机上半透明效果无效的bug
        }
        activity.getWindow().setAttributes(lp);
    }
}
