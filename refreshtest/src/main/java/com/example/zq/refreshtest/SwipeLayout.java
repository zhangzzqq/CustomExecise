package com.example.zq.refreshtest;

/**
 * Created by stevenzhang on 2017/1/3 0003.
 */

public class SwipeLayout {

//
//    用法
//    1 继承接口 implements SwipeRefreshLayout.OnRefreshListener
//    2 初始化
//
//            mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
////设置布局管理器
//    mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//    mSwipeRefreshLayout = (MySwipeRefreshLayout) view.findViewById(R.id.list_refresh);
//
//// 设置下拉圆圈上的颜色，蓝色、绿色、橙色、红色
//    mSwipeRefreshLayout.setColorSchemeResources(
//    android.R.color.holo_green_light,
//    android.R.color.holo_blue_bright,
//    android.R.color.holo_orange_light,
//    android.R.color.holo_red_light);
//
//// 设置手指在屏幕下拉多少距离会触发下拉刷新
//    mSwipeRefreshLayout.setDistanceToTriggerSync(300);
//// 设定下拉圆圈的背景
//    mSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
//// 设定下拉圆圈的背景
//    mSwipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT); // 设置圆圈的大小
////设置下拉刷新的监听
//    mSwipeRefreshLayout.setOnRefreshListener(this);
//
//    3.实现接口逻辑以及自动显示刷新
//
//    new Handler().postDelayed(new Runnable() {
//        @Override
//        public void run() {
//
//            getDataFromServer();
//            L.v("SonHpagerFragment1", "onRefresh()");
//        }
//    }, 1000);
//
//
//
////显示刷新
//    mSwipeRefreshLayout.post(new Runnable() {
//        @Override
//        public void run() {
//            mSwipeRefreshLayout.setRefreshing(true);
//            getDataFromServer();
//        }
//    });
//
//    4.显示停止刷新
//
//    mSwipeRefreshLayout.setRefreshing(true);//开始刷新
//    mSwipeRefreshLayout.setRefreshing(false);//停止刷新
//    Boolean refresh = mSwipeRefreshLayout.isRefreshing();
////停止刷新
//    if (refresh) {
//        mSwipeRefreshLayout.setRefreshing(false);
//        L.v("SonHpagerFragment", "setRefreshing(false)");
//    }
//
//    5 在资源文件中配置xml
//            <com.ainisi.myn.form.widget.MySwipeRefreshLayout
//    android:id="@+id/list_refresh"
//    android:layout_width="match_parent"
//    android:layout_height="match_parent">
//
//    <android.support.v7.widget.RecyclerView
//    android:id="@+id/recycler_view"
//    android:layout_width="match_parent"
//    android:layout_height="match_parent" />
//
//    </com.ainisi.myn.form.widget.MySwipeRefreshLayout>
//
//
//            5.实现加载更多
//    Android RecycleView轻松实现下拉刷新、加载更多
//    http://www.jianshu.com/p/7396dc6d67f0
    
}
