package com.example.zq.shop.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.zq.shop.R;
import com.example.zq.shop.fragment.MyFragment1;
import com.example.zq.shop.fragment.MyFragment2;
import com.example.zq.shop.fragment.MyFragment3;
import com.example.zq.shop.fragment.MyFragment4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Coder-pig on 2015/8/28 0028.
 */
public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener{

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;
    //UI Objects
    private TextView txt_topbar;
    private RadioGroup rg_tab_bar;
    private RadioButton rb_channel;
    private RadioButton rb_message;
    private RadioButton rb_better;
    private RadioButton rb_setting;
    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        
        //getSupportFragmentManager()返回一个fragmentManager的对象
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()){
            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }


            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                super.destroyItem(container, position, object);

            }
        };
        
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(PAGE_ONE);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            private int currentIndex;

            @Override
            public void onPageSelected(int position) {
                switch (mViewPager.getCurrentItem()) {
                    case PAGE_ONE:
                        rb_channel.setChecked(true);
                        break;
                    case PAGE_TWO:
                        rb_message.setChecked(true);
                        break;
                    case PAGE_THREE:
                        rb_better.setChecked(true);
                        break;
                    case PAGE_FOUR:
                        rb_setting.setChecked(true);
                        break;
                }

                currentIndex = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }
    
    private void initViews() {
        
        mViewPager = (ViewPager) findViewById(R.id.vpager);   //这里是滑动页面的布局
        txt_topbar = (TextView) findViewById(R.id.txt_topbar);
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rb_channel = (RadioButton) findViewById(R.id.rb_channel);
        rb_message = (RadioButton) findViewById(R.id.rb_message);
        rb_better = (RadioButton) findViewById(R.id.rb_better);
        rb_setting = (RadioButton) findViewById(R.id.rb_setting);

        rb_channel.setChecked(true);
        rg_tab_bar.setOnCheckedChangeListener(this);
        
        MyFragment1 tab01 = new MyFragment1();
        MyFragment2 tab02 = new MyFragment2();
        MyFragment3 tab03 = new MyFragment3();
        MyFragment4 tab04 = new MyFragment4();
        mFragments.add(tab01);
        mFragments.add(tab02);
        mFragments.add(tab03);
        mFragments.add(tab04);
        
    }

    //这个是按下RadioButton的响应的事件
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_channel:
                mViewPager.setCurrentItem(PAGE_ONE);
                Log.d("MainActivity1", "PAGE_ONE");
                break;
            case R.id.rb_message:
                mViewPager.setCurrentItem(PAGE_TWO);
                Log.d("MainActivity1", "PAGE_TWO");
                break;
            case R.id.rb_better:
                mViewPager.setCurrentItem(PAGE_THREE);
                Log.d("MainActivity1", "PAGE_THREE");
                break;
            case R.id.rb_setting:
                mViewPager.setCurrentItem(PAGE_FOUR);
                Log.d("MainActivity1", "PAGE_FOUR");
                break;
        }
    }
    
}
