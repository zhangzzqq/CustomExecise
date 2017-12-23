# CustomExecise

自定义的等待进度 
custom3(效果类似boss直聘)
custom2显示的效果已经非常的好了
nomal 是正常的dialog还是比较好用的
custom 只是一个练习，还不完成 ，但是动画效果不错

一个不错的效果
 https://gold.xitu.io/entry/5816a68a128fe1005591391d
https://github.com/linglongxin24/LoadingDialog


custom2
布商中的布局
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/dialog_view"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:background="@drawable/dialog_bg"
    android:paddingLeft="20dp"
    android:paddingRight="20dp"
    android:paddingTop="10dp"
    android:paddingBottom="10dp"
    android:orientation="vertical">

    <com.yunfc.widget.LVCircularRing
        android:id="@+id/lv_circularring"
        android:layout_width="35dp"
        android:layout_height="35dp"/>

    <TextView
        android:id="@+id/loading_text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textColor="#ffffff"
        android:layout_marginTop="5dp"
        android:textSize="12sp"/>

</LinearLayout>

