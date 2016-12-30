package com.example.zq.permissiondispatcher;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

/**
 @RuntimePermissions 标记需要运行时判断的类
 @NeedsPermission 标记需要检查权限的方法
 @OnShowRationale 授权提示回调
 @OnPermissionDenied 授权被拒绝回调
 @OnNeverAskAgain 授权不再拒绝不再显示回调
  * 一次性申请一个权限
  * Created by Vincent on 2016/8/26.
 */
@RuntimePermissions
public class RequestPermissionSingleActivity extends Activity implements View.OnClickListener {

    private static final int CALL_CAMERA_REQUEST_CODE = 1;
    private TextView tvCallPhone;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_permission_single);
        init();
    }

    private void init() {
        tvCallPhone=(TextView)findViewById(R.id.tv_call_phone);
        tvCallPhone.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_call_phone:
                RequestPermissionSingleActivityPermissionsDispatcher.callPhoneWithCheck(this);
                break;
        }
    }

    /**
     * 方法前面不能带有private修饰符
     */
    @NeedsPermission(Manifest.permission.CAMERA)
    void callPhone() {
        Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(openCameraIntent, CALL_CAMERA_REQUEST_CODE);
    }


    @OnShowRationale(Manifest.permission.CAMERA)
    void showRationaleForCamera(PermissionRequest request) {
        showRationaleDialog("使用此功能需要打开照相机的权限", request);
    }

    @OnPermissionDenied(Manifest.permission.CAMERA)
    void onCameraDenied() {
        ToastUtils.defaultToast(this,"你拒绝了权限，该功能不可用");
    }

    @OnNeverAskAgain(Manifest.permission.CAMERA)
    void onCameraNeverAskAgain() {
        ToastUtils.defaultToast(this,"不再允许询问该权限，该功能不可用");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        
        RequestPermissionSingleActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);

        Log.d("TAG","result=="+grantResults);

    }

    private void showRationaleDialog(String messageResId, final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        request.proceed();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        request.cancel();
                    }
                })
                .setCancelable(false)
                .setMessage(messageResId)
                .show();
    }
}
