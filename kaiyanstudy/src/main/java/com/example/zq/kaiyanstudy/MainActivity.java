package com.example.zq.kaiyanstudy;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ScrollView scrollView;
    private ImageView image;
    //记录首次按下的位置
    private float mFirstPosition =0;
    private DisplayMetrics metrics;
    private Boolean mScaling =false;
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;

    private List<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();
        initData();
        
    }
    
    public void initView(){
        //获取控件
        scrollView = (ScrollView) findViewById(R.id.scroll);
        image = (ImageView) findViewById(R.id.iv_pic);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        
        //获取屏幕的宽高
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        
        //设置图片初始大小，这里设置满屏16:9
        ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) image.getLayoutParams();
        lp.width = metrics.widthPixels;
        lp.height = metrics.widthPixels*9/16;
        image.setLayoutParams(lp);
        
    }
    
    public void initData(){
        
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                
                ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams)image.getLayoutParams();
                switch (motionEvent.getAction()){
                    
                    case MotionEvent.ACTION_UP:
                        //手指离开
                        mScaling = false;
                        replyImage();
                        break;
                    /**
                     * 　　getRawX()和getRawY()获得的是相对屏幕的位置，getX()和getY()获得的永远是view的触摸位置坐标
                     */
                    
                    case MotionEvent.ACTION_MOVE:
                        if(!mScaling){
                            //attention 不是getScaleY()
                            if(scrollView.getScrollY()==0){
                                //滚动到顶部的时候记录位置，否则正常返回,没有头部 mFirstPositon位置为0
                                mFirstPosition = motionEvent.getY();
                            }else {
                                break;
                            }
                        }
                        //滚动距离乘以一个系数
                        int distance = (int) ((motionEvent.getY()-mFirstPosition)*0.6);
                        Log.v(TAG,"distance="+distance);
                        //当前位置比记录的位置要小，正常返回
                        if(distance<0){
                            break;
                        }
                        //处理放大
                        mScaling = true;
                        lp.width = metrics.widthPixels+distance;
                        lp.height = (metrics.widthPixels+distance)*9/16;
                        image.setLayoutParams(lp);
                        //返回true 表示已经完成触摸事件，不再交给其他处理
                        return true;
                }
                return false;
            }
        });


        //recyclerView逻辑
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        VideoPlayer  adapter = new VideoPlayer(this, getData());
        recyclerView.setAdapter(adapter);


    }

    //recyclerView数据源
    private List<String> getData() {

        data = new ArrayList<>();
        for(int i=0;i<15;i++){
            data.add("item"+i);
        }
        return data;
    }


    //回弹动画（使用了属性动画）
    private void replyImage() {
        final ViewGroup.LayoutParams lp = image.getLayoutParams();
        final float w =  image.getLayoutParams().width;//图片当前宽度
        final float h = image.getLayoutParams().height;//图片当前高度
        final float newW = metrics.widthPixels;//图片原宽度
        final float newH = metrics.widthPixels*9/16 ;//图片的高度

        ValueAnimator anim = ObjectAnimator.ofFloat(0.0F,1.0F).setDuration(200);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float cVal = (float) valueAnimator.getAnimatedValue();
                lp.width = (int) (w-(w-newW)*cVal);
                lp.height = (int) (h-(h-newH)*cVal);
                image.setLayoutParams(lp);
            }
        });
        anim.start();
    }

}
