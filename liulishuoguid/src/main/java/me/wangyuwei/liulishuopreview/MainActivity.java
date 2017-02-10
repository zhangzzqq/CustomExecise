
package me.wangyuwei.liulishuopreview;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    private PreviewVideoView mVideoView;
    private ViewPager mVpImage;
    private PreviewIndicator mIndicator;

    private List<View> mViewList = new ArrayList<>();
    //三个小方块图
    private int[] mImageResIds = new int[]{R.mipmap.intro_text_1, R.mipmap.intro_text_2, R.mipmap.intro_text_3};
    private CustomPagerAdapter mAdapter;

    private int mCurrentPage = 0;
    private Subscription mLoop;
    private Timer timer;
    private Boolean isPlay = true;
     

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoView = (PreviewVideoView) findViewById(R.id.vv_preview);
        mVpImage = (ViewPager) findViewById(R.id.vp_image);
        mIndicator = (PreviewIndicator) findViewById(R.id.indicator);
        mVideoView.setVideoURI(Uri.parse(getVideoPath()));

        //三个小方块图片
        for (int i = 0; i < mImageResIds.length; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.preview_item, null, false);
            ((ImageView) view.findViewById(R.id.iv_intro_text)).setImageResource(mImageResIds[i]);
            mViewList.add(view);
        }

        mAdapter = new CustomPagerAdapter(mViewList);

        //viewpager
        mVpImage.setAdapter(mAdapter);
        mVpImage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                mCurrentPage = position;
                mIndicator.setSelected(mCurrentPage);
                startLoop();
                isPlay = true;
                
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        startLoop();

    }

    /**
     * 获取video文件的路径
     *
     * @return 路径
     */
    private String getVideoPath() {
        return "android.resource://" + this.getPackageName() + "/" + R.raw.intro_video;
    }

    /**
     * 开启轮询
     */
    private void startLoop() {
        
        if (null != mLoop) {
            mLoop.unsubscribe();
        }
        
        mLoop = Observable.interval(0, 6 * 1000, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {

                        if(!isPlay){
                            mVideoView.pause();
                           return;
                        }

                        mVideoView.seekTo(mCurrentPage * 6 * 1000);
                        //开始播放
                        if (!mVideoView.isPlaying()) {
                            mVideoView.start();
                        }

                        //不再循环播放
                        isPlay = false;
                    }
                });


//        new CountDownTimer(6000, 7000) {
//
//            public void onTick(long millisUntilFinished) {
//
//                mVideoView.seekTo(mCurrentPage * 6 * 1000);
//                //停止循环
//                if (!mVideoView.isPlaying()) {
//                    mVideoView.start();
//                }
//            }
//
//            public void onFinish() {
//
//                mVideoView.pause();
//
//            }
//        }.start();

//        if (timer == null) {
//            timer = new Timer();
//        }
//        timer.schedule(task, 0, 6000);

    }

    @Override
    protected void onDestroy() {
        if (null != mLoop) {
            mLoop.unsubscribe();
        }
        super.onDestroy();
    }

    public static class CustomPagerAdapter extends PagerAdapter {

        private List<View> mViewList;

        public CustomPagerAdapter(List<View> viewList) {
            mViewList = viewList;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));
        }

        @Override
        public int getCount() {
            return mViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }




    TimerTask task = new TimerTask() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    mVideoView.seekTo(mCurrentPage * 6 * 1000);
                    //停止循环
                    if (!mVideoView.isPlaying()) {
                        mVideoView.start();
                    }

//                    if (secondLeft < 0) {
//                        timer.cancel();
//                        textView.setText("倒计时结束");
//                    }
                }
            });
        }
    };

}
