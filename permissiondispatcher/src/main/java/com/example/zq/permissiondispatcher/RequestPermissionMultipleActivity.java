package com.example.zq.permissiondispatcher;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by stevenzhang on 2016/12/30 0030.
 */

@RuntimePermissions
public class RequestPermissionMultipleActivity  extends Activity implements View.OnClickListener{

    private TextView tvReadSMS;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_permission_multiple);
        init();
    }

    private void init() {
        tvReadSMS=(TextView)findViewById(R.id.tv_read_sms);
        tvReadSMS.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_read_sms:
                RequestPermissionMultipleActivityPermissionsDispatcher.readSMSWithCheck(this);
                break;
        }
    }
    ////////////////////动态申请权限相关操作/////////////////////////
    @NeedsPermission({Manifest.permission.READ_SMS, Manifest.permission.READ_EXTERNAL_STORAGE})
    void readSMS(){
        String sms= getSmsInPhone();
        Log.d("sms",sms);
    }
    @OnShowRationale({Manifest.permission.READ_SMS, Manifest.permission.READ_EXTERNAL_STORAGE})
    void noPermission(PermissionRequest request){
        showRationaleDialog("必须有权限才能使用", request);
    }
    @OnPermissionDenied({Manifest.permission.READ_SMS, Manifest.permission.READ_EXTERNAL_STORAGE})
    void juJue(){
        ToastUtils.defaultToast(this,"用户拒绝了申请");
    }
    @OnNeverAskAgain({Manifest.permission.READ_SMS, Manifest.permission.READ_EXTERNAL_STORAGE})
    void juJueAndNoTiShi(){
        ToastUtils.defaultToast(this,"拒绝且不提示");
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        RequestPermissionMultipleActivityPermissionsDispatcher.onRequestPermissionsResult(this,requestCode,grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public String getSmsInPhone()
    {
        final String SMS_URI_ALL = "content://sms/";
        final String SMS_URI_INBOX = "content://sms/inbox";
        final String SMS_URI_SEND = "content://sms/sent";
        final String SMS_URI_DRAFT = "content://sms/draft";

        StringBuilder smsBuilder = new StringBuilder();

        try{
            ContentResolver cr = getContentResolver();
            String[] projection = new String[]{"_id", "address", "person",
                    "body", "date", "type"};
            Uri uri = Uri.parse(SMS_URI_ALL);
            Cursor cur = cr.query(uri, projection, null, null, "date desc");

            if (cur.moveToFirst()) {
                String name;
                String phoneNumber;
                String smsbody;
                String date;
                String type;

                int nameColumn = cur.getColumnIndex("person");
                int phoneNumberColumn = cur.getColumnIndex("address");
                int smsbodyColumn = cur.getColumnIndex("body");
                int dateColumn = cur.getColumnIndex("date");
                int typeColumn = cur.getColumnIndex("type");

                do{
                    name = cur.getString(nameColumn);
                    phoneNumber = cur.getString(phoneNumberColumn);
                    smsbody = cur.getString(smsbodyColumn);

                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "yyyy-MM-dd hh:mm:ss");
                    Date d = new Date(Long.parseLong(cur.getString(dateColumn)));
                    date = dateFormat.format(d);

                    int typeId = cur.getInt(typeColumn);
                    if(typeId == 1){
                        type = "接收";
                    } else if(typeId == 2){
                        type = "发送";
                    } else {
                        type = "";
                    }

                    smsBuilder.append("[");
                    smsBuilder.append(name+",");
                    smsBuilder.append(phoneNumber+",");
                    smsBuilder.append(smsbody+",");
                    smsBuilder.append(date+",");
                    smsBuilder.append(type);
                    smsBuilder.append("] ");

                    if(smsbody == null) smsbody = "";
                }while(cur.moveToNext());
            } else {
                smsBuilder.append("no result!");
            }

            smsBuilder.append("getSmsInPhone has executed!");
        } catch(SQLiteException ex) {
            Log.d("SQL in getSmsInPhone", ex.getMessage());
        }
        return smsBuilder.toString();
    }

    private void showRationaleDialog(String messageResId, final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setPositiveButton("好", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        request.proceed();
                    }
                })
                .setNegativeButton("算了吧", new DialogInterface.OnClickListener() {
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
