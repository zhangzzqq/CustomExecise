package com.example.hongyang;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.example.customview.R;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * ClassName:
 * Description:
 * Create by: steven
 * Date: 2018/7/2
 */
public class CustomTitleView extends View {
    /**
     * 文本
     */
    private String mTitleText;
    /**
     * 文本的颜色
     */
    private int mTitleTextColor;
    /**
     * 文本的大小
     */
    private int mTitleTextSize;

    /**
     * 绘制时控制文本绘制的范围
     */
    private Rect mBound;
    private Paint mPaint;

    public CustomTitleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTitleView(Context context) {
        super(context);
    }

    /**
     * 获得我自定义的样式属性
     *
     * @param context
     * @param attrs
     * @param defStyle
     *
     */
    public CustomTitleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        /**
         *
         * 获得我们所定义的自定义样式属性
         *
         */
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyle, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CustomTitleView_titleText:
                    mTitleText = a.getString(attr);
                    break;
                case R.styleable.CustomTitleView_titleTextColor:
                    // 默认颜色设置为黑色
                    mTitleTextColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomTitleView_titleTextSize:
                    // 默认设置为16sp，TypeValue也可以把sp转化为px
                    mTitleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;

            }

        }

        a.recycle();

        /**
         * 获得绘制文本的宽和高
         */
        mPaint = new Paint();
        mPaint.setTextSize(mTitleTextSize);
        // mPaint.setColor(mTitleTextColor);
        mBound = new Rect();
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);



        this.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                mTitleText = randomText();

                /**
                 *
                 *   // postInvalidate() 方法在非 UI 线程中调用，通知 UI 线程重绘。
                 //invalidate() 方法在 UI 线程中调用，重绘当前 UI。
                 *
                 *
                 *  为什么我们需要通过 Handler 来通知 UI 线程重绘？因为我们大家都知道，在 Android 中通过非 UI 线程更新 UI 是不可取的，
                 *  我们不可以通过子线程来更新 UI，所以我们就借助线程间通信，让主线程调用相应 View 的 invalidate() 方法来更新 UI。
                 *  那可不可以不通过线程间通信，直接在子线程通知 View 进行重绘？有！就是通过 postInvalidate()
                 *  （实际上 postInvalidate() 底层的实现还是通过 Hanlder 的，但是底层封装起来了，让我们直接可以在子线程调用）
                 */

                postInvalidate();
//                invalidate();
            }

        });


    }

    private String randomText()
    {
        Random random = new Random();
        Set<Integer> set = new HashSet<Integer>();
        while (set.size() < 4)
        {
            int randomInt = random.nextInt(10);
            set.add(randomInt);
        }
        StringBuffer sb = new StringBuffer();
        for (Integer i : set)
        {
            sb.append("" + i);
        }

        return sb.toString();
    }



    /**
     * 实现功能：
     *
     *
     *
     * 注意事项：
     *
     * 当我们设置为WRAP_CONTENT,或者MATCH_PARENT系统帮我们测量的结果就是MATCH_PARENT的长度。
     *
     * 所以，当设置了WRAP_CONTENT时，我们需要自己进行测量，即重写onMesure方法”：
     *
     * 重写之前先了解MeasureSpec的specMode,一共三种类型：
     *
     * EXACTLY：一般为设置了明确的值或者是MATCH_PARENT
     *
     * AT_MOST：表示子布局限制在一个最大值内，一般为WARP_CONTENT
     *
     * UNSPECIFIED：表示子布局想要多大就多大，很少使用
     *
     * 下面是我们重写onMeasure代码：
     *
     *
     *  https://developer.android.google.cn/reference/android/view/View.MeasureSpec.html#getSize(int)
     *
     *  measureSpec	int：从中提取模式的度量指定
     *
     *
     */

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = 0;
        int height = 0;

        /**
         * 设置宽度
         */
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        Log.e("xxxx","widthspecSize=="+specSize);
        Log.e("xxxx","mBound.width()=="+mBound.width());

        switch (specMode) {
            case MeasureSpec.EXACTLY:// 明确指定了
                width = getPaddingLeft() + getPaddingRight() + specSize;
                break;
            case MeasureSpec.AT_MOST:// 一般为WARP_CONTENT
                width = getPaddingLeft() + getPaddingRight() + mBound.width();
                break;
        }

        /**
         * 设置高度
         */
        specMode = MeasureSpec.getMode(heightMeasureSpec);
        specSize = MeasureSpec.getSize(heightMeasureSpec);

        Log.e("xxxx","heightspecSize=="+specSize);
        Log.e("xxxx","mBound.height()=="+mBound.height());
        switch (specMode) {
            case MeasureSpec.EXACTLY:// 明确指定了
                height = getPaddingTop() + getPaddingBottom() + specSize;
                break;
            case MeasureSpec.AT_MOST:// 一般为WARP_CONTENT
                height = getPaddingTop() + getPaddingBottom() + mBound.height();
                break;
        }

        setMeasuredDimension(width, height);
    }


    /**
     * @param canvas 07-02 16:23:11.705 13200-13200/com.example.customview
     *               E/xxx: measuredWidth==600width==600mBoundWidth==259
     *               measuredHeight==300height==300mBoundHeight==89
     *
     *
     *               这时你会发现getWidth=200，是layout方法中传过去的200-0，getMeasureWidth=50，
     *               是setMeasuredDimension方法设置的值,但是显示在屏幕上的确是一个正方形也就是显示的是layout设置的宽200，
     *               高200。但是这种情况是非常少见的，这里这是为了演示效果才这样写，一般情况下getMeasuredWidth和getWidth方法的
     *               值是一致的,这里只要记住一般情况下除了在onLayout方法中调用getMeasuredWidth方法外其它的地方用getWidth方法就行了。
     *
     *               总结
     *               https://blog.csdn.net/dmk877/article/details/49734869
     *               ①getMeasuredWidth方法获得的值是setMeasuredDimension方法设置的值，它的值在measure方法运行后就会确定
     *
     *               ②getWidth方法获得是layout方法中传递的四个参数中的mRight-mLeft，它的值是在layout方法运行后确定的
     *
     *               ③一般情况下在onLayout方法中使用getMeasuredWidth方法，而在除onLayout方法之外的地方用getWidth方法。
     */
    @Override
    protected void onDraw(Canvas canvas) {


        int measuredWidth = getMeasuredWidth();//整个view的宽度
        int width = getWidth();//整个view的宽度
        int mBoundWidth = mBound.width();//控件的宽度


        int measuredHeight = getMeasuredHeight();//整个view的高度
        int height = getHeight();//整个view的高度
        int mBoundHeight = mBound.height();//控件的高度


        Log.e("xxx", "measuredWidth==" + measuredWidth + "width==" + width + "mBoundWidth==" + mBoundWidth);
        Log.e("xxx", "measuredHeight==" + measuredHeight + "height==" + height + "mBoundHeight==" + mBoundHeight);


        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);

        mPaint.setColor(mTitleTextColor);
        canvas.drawText(mTitleText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);


    }


}
