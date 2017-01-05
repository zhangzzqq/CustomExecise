package com.example.zq.kaiyanstudy;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2016/8/15.
 */
public class PullToZoomScrollViewShot extends ScrollView {
    private  boolean isonce;//加载该View的布局时是否是第一次加载，是第一次就让其实现OnMeasure里的代码

    private LinearLayout mParentView;//布局的父布局，ScrollView内部只能有一个根ViewGroup，就是此View
    private ViewGroup mTopView;//这个是带背景的上半部分的View，下半部分的View用不到的

    private int mScreenHeight;//整个手机屏幕的高度，这是为了初始化该View时设置mTopView用的
    private int mTopViewHeight;//这个就是mTopView的高度

    private int mCurrentOffset=0;//当前右侧滚条顶点的偏移量。ScrollView右侧是有滚动条的，当下拉时，
    //滚动条向上滑，当向下滑动时，滚动条向下滑动。

    private ObjectAnimator oa;//这个是对象动画，这个在本View里很简单，也很独立，就在这里申明一下，后面有两个方法
    //两个方法是：setT(int t),reset()两个方法用到，其他都和它无关了。



    //移动因子, 是一个百分比, 比如手指移动了100px, 那么View就只移动50px
    //目的是达到一个延迟的效果 move factor
    private static final float MOVE_FACTOR = 0.5f;

    //松开手指后, 界面回到正常位置需要的动画时间
    private static final int ANIM_TIME = 300;

    //ScrollView的子View， 也是ScrollView的唯一一个子View
    private View contentView;

    //手指按下时的Y值, 用于在移动时计算移动距离
    //如果按下时不能上拉和下拉， 会在手指移动时更新为当前手指的Y值
    //用于记录正常的布局位置
    private Rect originalRect = new Rect();
    private float startYs;
    //手指按下时记录是否可以继续下拉
    private boolean canPullDown = false;

    //手指按下时记录是否可以继续上拉
    private boolean canPullUp = false;

    //在手指滑动的过程中记录是否移动了布局
    private boolean isMoved = false;
    private long clickTime1;

    @Override
    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            contentView = getChildAt(0);
        }
        super.onFinishInflate();
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if(contentView == null) return;
        //ScrollView中的唯一子控件的位置信息, 这个位置信息在整个控件的生命周期中保持不变
        originalRect.set(contentView.getLeft(), contentView.getTop(), contentView.getRight(), contentView.getBottom());
    }
    /**
     * 在触摸事件中, 处理上拉和下拉的逻辑
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (contentView == null) {
            return super.dispatchTouchEvent(ev);
        }

        int action = ev.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.v("ullToZoomScrollViewShot","ACTION_DOW");
//                TakePhotoUtil.showPopupWindow(LoginActivity.this, loginPic);
                //判断是否可以上拉和下拉
                canPullUp = isCanPullUp();
                //记录按下时的Y值
                startYs = ev.getY();
                break;
            case MotionEvent.ACTION_UP:
                Log.v("ullToZoomScrollViewShot","ACTION_U");
                if(!isMoved) break;  //如果没有移动布局， 则跳过执行
                // 开启动画
                TranslateAnimation anim = new TranslateAnimation(0, 0, contentView.getTop(),
                        originalRect.top);
                anim.setDuration(ANIM_TIME);

                contentView.startAnimation(anim);

                // 设置回到正常的布局位置
                contentView.layout(originalRect.left, originalRect.top,
                        originalRect.right, originalRect.bottom);

                //将标志位设回false
                canPullDown = false;
                canPullUp = false;
                isMoved = false;

                break;
            case MotionEvent.ACTION_MOVE:
                Log.v("ullToZoomScrollViewShot","ACTION_MOVE");
                //在移动的过程中， 既没有滚动到可以上拉的程度， 也没有滚动到可以下拉的程度
                if(!canPullDown && !canPullUp) {
                    startYs = ev.getY();
                    canPullUp = isCanPullUp();

                    break;
                }

                //计算手指移动的距离
                float nowY = ev.getY();
                int deltaY = (int) (nowY - startYs);

                //是否应该移动布局
                boolean shouldMove =
                        (canPullDown && deltaY > 0)    //可以下拉， 并且手指向下移动
                                || (canPullUp && deltaY< 0)    //可以上拉， 并且手指向上移动
                                || (canPullUp && canPullDown); //既可以上拉也可以下拉（这种情况出现在ScrollView包裹的控件比ScrollView还小）

                if(shouldMove){
                    //计算偏移量
                    int offset = (int)(deltaY * MOVE_FACTOR);

                    //随着手指的移动而移动布局
                    contentView.layout(originalRect.left, originalRect.top + offset,
                            originalRect.right, originalRect.bottom + offset);

                    isMoved = true;  //记录移动了布局
                }

                break;
            default:
                break;
        }

        return super.dispatchTouchEvent(ev);
    }
    /**
     * 判断是否滚动到底部
     */
    private boolean isCanPullUp() {
        return  contentView.getHeight() <= getHeight() + getScrollY();
    }
    /**
     * 初始化获取高度值，并记录
     * @param context
     * @param attrs
     */
    public PullToZoomScrollViewShot(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOverScrollMode(View.OVER_SCROLL_NEVER);
        WindowManager wm= (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics=new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);
        mScreenHeight=metrics.heightPixels;
        mTopViewHeight=mScreenHeight/3-(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 90, context.getResources().getDisplayMetrics());

    }

    /**
     * 将记录的值设置到控件上，并只让控件设置一次
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if(!isonce) {
            mParentView = (LinearLayout) this.getChildAt(0);
            mTopView = (ViewGroup) mParentView.getChildAt(0);
            mTopView.getLayoutParams().height = mTopViewHeight;
            isonce=true;
        }
    }

    private float startY=0;//向下拉动要放大，手指向下滑时，点击的第一个点的Y坐标
    private boolean isBig;//是否正在向下拉放大上半部分View
    private boolean isTouchOne;//是否是一次连续的MOVE，默认为false,
    //在MoVe时，如果发现滑动标签位移量为0，则获取此时的Y坐标，作为起始坐标，然后置为true,为了在连续的Move中只获取一次起始坐标
    //当Up弹起时，一次触摸移动完成，将isTouchOne置为false
    private float distance=0;//向下滑动到释放的高度差
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action =ev.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                clickTime1 = System.currentTimeMillis();
                Log.v("ullToZoomScrollViewShot", "PullToZoomScrollViewShotclickTime1========" + clickTime1);
                break;
            case MotionEvent.ACTION_MOVE:
                if(mCurrentOffset<=0){
                    if(!isTouchOne){
                        startY=ev.getY();
                        isTouchOne=true;
                    }
                    distance=ev.getY()-startY;
                    if(distance>0){
                        isBig=true;
                        setT((int)-distance/4);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                long clickTime2 = System.currentTimeMillis() - clickTime1;
                Log.v("ullToZoomScrollViewShot", "PullToZoomScrollViewShotclickTime2========" + clickTime2);
               if(clickTime2<=800){
                   judge(); 
               }
                if(isBig) {
                    reset();
                    isBig=false;
                }
                isTouchOne=false;
                break;
        }
        return super.onTouchEvent(ev);
    }
    private void judge() {
        Intent intent = new Intent("pulltozoomsend");
        getContext().sendBroadcast(intent);//发送广播事件  
    }
    
    /**
     * 对象动画要有的设置方法
     * @param t
     */
    public void setT(int t) {
        scrollTo(0, 0);
        if (t < 0) {
            mTopView.getLayoutParams().height = mTopViewHeight-t;
            mTopView.requestLayout();
        }
    }

    /**
     * 主要用于释放手指后的回弹效果
     */
    private void reset() {
        if (oa != null && oa.isRunning()) {
            return;
        }
        oa = ObjectAnimator.ofInt(this, "t", (int) -distance / 4, 0);
        oa.setDuration(150);
        oa.start();
    }

    /**
     * 这个是设置向上滑动时，上半部分View滑动速度让其小于下半部分
     * @param l
     * @param t
     * @param oldl
     * @param oldt
     */
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        mCurrentOffset = t;//右边滑动标签相对于顶端的偏移量
        //当手势上滑，则右侧滚动条下滑，下滑的高度小于TopView的高度，则让TopView的上滑速度小于DownView的上滑速度
        //DownView的上滑速度是滚动条的速度，也就是滚动的距离是右侧滚动条的距离
        //则TopView的速度要小，只需要将右侧滚动条的偏移量也就是t缩小一定倍数就行了。我这里除以2速度减小1倍
        if (t <= mTopViewHeight&&t>=0&&!isBig) {
            mTopView.setTranslationY(t / 2);//使得TopView滑动的速度小于滚轮滚动的速度
        }
        if(isBig){
            scrollTo(0,0);
        }

    }
    
    
}
