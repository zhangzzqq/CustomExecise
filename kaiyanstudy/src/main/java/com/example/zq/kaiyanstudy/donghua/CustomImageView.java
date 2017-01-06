package com.example.zq.kaiyanstudy.donghua;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by stevenzhang on 2017/1/6 0006.
 */

public class CustomImageView extends ImageView {

private int mResId;
    public CustomImageView(Context context) {
        
        this(context,null,0);
        
    }
    
    public CustomImageView(Context context, AttributeSet attrs){
        
        this(context,attrs,0);
    }
    
    public CustomImageView(Context context,AttributeSet attrs,int defStyleAttr){
        
        super(context,attrs,defStyleAttr);
        
        if(attrs!=null){
           String nameSpace = "http://schemas.android.com/apk/res/android";
            String attribute ="src";
            mResId = attrs.getAttributeResourceValue(nameSpace,attribute,0);
        }
        
    }
    
    public int getImageId(){
        
        return mResId;
    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        
        mResId = resId;
    }
}
