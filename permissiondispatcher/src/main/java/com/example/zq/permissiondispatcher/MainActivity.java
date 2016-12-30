package com.example.zq.permissiondispatcher;

/**
 * @RuntimePermissions 标记需要运行时判断的类
 @NeedsPermission 标记需要检查权限的方法
 @OnShowRationale 授权提示回调
 @OnPermissionDenied 授权被拒绝回调
 @OnNeverAskAgain 授权不再拒绝不再显示回调
 */

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * PermissionsDispatcher 使用此方式管理权限所有的Activity必须继承AppCompatActivity
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int CAMERA_REQUEST_CODE = 1;//权限申请码 拍照

    private TextView textView,btnCallPhone,btnCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVIew();
    }

    private void initVIew() {
        textView=(TextView)findViewById(R.id.tv_toast);
        textView.setOnClickListener(this);

        btnCallPhone=(TextView)findViewById(R.id.btn_call_phone);
        btnCallPhone.setOnClickListener(this);

        btnCamera=(TextView)findViewById(R.id.btn_camera);
        btnCamera.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_toast:
                break;
            case R.id.btn_call_phone:
                startActivity(new Intent(MainActivity.this,RequestPermissionSingleActivity.class));
                break;
            case R.id.btn_camera:
                startActivity(new Intent(MainActivity.this,RequestPermissionMultipleActivity.class));
                break;
            default:
                break;
        }
    }
}

