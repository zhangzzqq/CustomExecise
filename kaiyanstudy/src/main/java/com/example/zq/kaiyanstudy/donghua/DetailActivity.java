package com.example.zq.kaiyanstudy.donghua;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.transition.Transition;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.example.zq.kaiyanstudy.R;

/**
 * Created by stevenzhang on 2017/1/6 0006.
 */
public class DetailActivity extends AppCompatActivity {
    
   public static final java.lang.String EXTRA_IMAGE = DetailActivity.class.getSimpleName()+".IMAGE"; 
    private ImageView mImageView;
    private FloatingActionButton mFloatingActionButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar) );
        
        int imageResId = getIntent().getExtras().getInt(EXTRA_IMAGE);
        mImageView = (ImageView) findViewById(R.id.image);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fabbtn);
        mImageView.setImageResource(imageResId);
    }

    //退出动画
    @Override
    public void onBackPressed() {
        
        mFloatingActionButton
                .animate()
                .scaleX(0)
                .scaleY(0)
                .setListener(new CustomTransitionListener(){

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        //attention 退出动画
                        supportFinishAfterTransition();
                    }
                });
    }
    
    
    //自定义一个监听器
    
    class CustomTransitionListener implements Transition.TransitionListener,Animator.AnimatorListener{


        @Override
        public void onAnimationStart(Animator animator) {
            
        }

        @Override
        public void onAnimationEnd(Animator animator) {

        }

        @Override
        public void onAnimationCancel(Animator animator) {

        }

        @Override
        public void onAnimationRepeat(Animator animator) {

        }

        @Override
        public void onTransitionStart(@NonNull Transition transition) {

        }

        @Override
        public void onTransitionEnd(@NonNull Transition transition) {

        }

        @Override
        public void onTransitionCancel(@NonNull Transition transition) {

        }

        @Override
        public void onTransitionPause(@NonNull Transition transition) {

        }

        @Override
        public void onTransitionResume(@NonNull Transition transition) {

        }
    }
    
    
}
