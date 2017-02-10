package com.example.zq.eventdispatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by stevenzhang on 2017/2/10 0010.
 */

public class CountTimerTest  extends Activity{


    private CountDownTimer myTimer;
    private TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.layout_counter);

        timer = (TextView) findViewById(R.id.timer);
        
        
        initData();
    }

    private void initData() {

//        myTimer = new CountDownTimer(myTime, 100) {
//
//            @Override
//            public void onTick(long millisUntilFinished) {
//                mTv.setText("剩余时间: " + millisUntilFinished / 1000 + "."
//                        + (millisUntilFinished % 1000) / 100+"秒");
//            }
//
//            @Override
//            public void onFinish() {
//                if (myTime / 1000 == 0) {
//                    mTv.setText("时间到!");
//                    Intent i = new Intent(ActivityA.this,ActivityB.class);
//                    String answer = getSelectedAnswer();
//                    i.putExtra(Constants.EXTRA_MESSAGE, answer);
//                    startActivity(i);
//                    finish();
//
//                }
//            }
//        }.start();


       /**
              onTick()，每个固定的时间就会调用这个方法，例子中通过这方法来显示剩余的时间。
              onFinish()，计时完成时调用的方法。
              start()，开始倒计时。
        */

        new CountDownTimer(30000, 10000) {
            
            public void onTick(long millisUntilFinished) {
                timer.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timer.setText("done!");
            }
        }.start();
        
        
    }
}
