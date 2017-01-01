package com.example.zq.takephototest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 注意权限，大于22会出现异常，因为没有获得写入权限或者拍照权限
 */
public class TakePhoto extends AppCompatActivity {
    private static final int REQ_1 = 1;
    private static final int REQ_2 = 2;
    private static final int REQ_3 = 3;
    private ImageView imageView ;
    private String mFilePath;
    FileInputStream fis;
    Bitmap bitmap=null;
    private static final String TAG = "TakePhoto";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private void initData() {
        imageView = (ImageView) findViewById(R.id.iv);
        //获取路径 
        boolean sdCardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if(sdCardExist){
            mFilePath = Environment.getExternalStorageDirectory().getPath()+File.separator+"temp.png";
            Log.e(TAG,"filePath=="+mFilePath);//路径是  TakePhoto: filePath==/storage/emulated/0/temp.png

        }
        destroyBitmap(); 
    }
    

    //调用系统的camera ,缩略图
        public void startCamera1(View view){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,REQ_1);
        }
            //调用系统相机，保存原图
            public void startCamera2(View view){
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //file转换为uri
                Uri bitmapUri = Uri.fromFile(new File(mFilePath));
                intent.putExtra(MediaStore.EXTRA_OUTPUT,bitmapUri);
                startActivityForResult(intent,REQ_2);
            }
          public void customCamera(View view){
         }
        //打开图库
        public void Album(View view){
            //选择界面的intent
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            //设置内容为image类型
            intent.setType("image/*");
            //打开图库界面
            startActivityForResult(intent,REQ_3);
        }
    
        
    
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //结果码
        if(resultCode==RESULT_OK){
            Log.d("TakePhoto","result_ok");
            if(data==null){
                return;
            }
            //压缩图，请求码
            if(requestCode==REQ_1){
                Bundle bundle = data.getExtras();
                bitmap = (Bitmap) bundle.get("data");
                imageView.setImageBitmap(bitmap);
            }
            //原图，请求码,这边必须要有Camera权限，要不然呢fis会报null
            else if(requestCode==REQ_2){
                try {
                    fis=new FileInputStream(mFilePath);
//                    File  file  = new File(mFilePath);
//                    Uri uri = Uri.fromFile(file);
                    bitmap=BitmapFactory.decodeStream(fis);
                    imageView.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally{
                    try {
                        fis.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }else if(requestCode==REQ_3){
                Uri uri = data.getData();
                
            }
        }
    }
      
    private void destroyBitmap() {
        if(bitmap!=null&&!bitmap.isRecycled()){
            bitmap.recycle();
            bitmap = null;
        }
    }
}
