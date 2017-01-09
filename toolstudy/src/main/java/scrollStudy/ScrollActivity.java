package scrollstudy;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

import com.example.zq.toolstudy.R;

/**
 * Created by stevenZhang on 2017/1/8.
 */

public class ScrollActivity extends Activity {

private ScrollView mScrollView;
    private static final String TAG ="ScrollActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll);

        init();
    }

    private void init() {

       mScrollView = (ScrollView) findViewById(R.id.scrollView);
        mScrollView.setOnTouchListener(new TouchListenerImpl());
    }


    private class TouchListenerImpl implements View.OnTouchListener{


        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

           switch (motionEvent.getAction()){

               case MotionEvent.ACTION_DOWN:

                   break;

               case MotionEvent.ACTION_MOVE:

                   int scrollY = view.getScrollY(); //滚出屏幕的距离
                   int height = view.getHeight(); //屏幕的高度
                   int scrollViewMeasureHeight = mScrollView.getChildAt(0).getMeasuredHeight(); //Scrollview控件的高度

                   if(scrollY ==0){
                       Log.d("ScrollActivity","顶部");
                   }

                   if((scrollY+height)==scrollViewMeasureHeight){

                       Log.d("ScrollActivity","滑动到底部了");
                       Log.d("ScrollActivity","scrollY"+scrollY);
                       Log.d("ScrollActivity","height"+height);//attention
                       Log.d("ScrollActivity","scrollViewMeasureHeight"+scrollViewMeasureHeight);
                   }

                   break;
//                   int scrollY=view.getScrollY();
//                   int height=view.getHeight();
//                   int scrollViewMeasuredHeight=mScrollView.getChildAt(0).getMeasuredHeight();
//                   if(scrollY==0){
//                       System.out.println("滑动到了顶端 view.getScrollY()="+scrollY);
//                   }
//                   if((scrollY+height)==scrollViewMeasuredHeight){
//                       System.out.println("滑动到了底部 scrollY="+scrollY);
//                       System.out.println("滑动到了底部 height="+height);
//                       System.out.println("滑动到了底部 scrollViewMeasuredHeight="+scrollViewMeasuredHeight);
//                   }
//                   break;
//
//               default:
//                   break;


           }
            return false;
        }
    }
}
