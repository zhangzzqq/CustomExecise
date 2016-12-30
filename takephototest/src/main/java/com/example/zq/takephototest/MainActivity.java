package com.example.zq.takephototest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by stevenzhang on 2016/12/30 0030.
 */

public class MainActivity extends ActionBarActivity {

    private static int CAMERA_REQUEST_CODE = 1;
    private static int GALLERY_REQUEST_CODE = 2;
    private static int CROP_REQUEST_CODE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_camera = (Button)findViewById(R.id.btn_camera);
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_REQUEST_CODE);
            }
        });

        Button btn_gallery = (Button)findViewById(R.id.btn_gallery);
        btn_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new 一个内容选择界面的intent
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                //设置内容为图像类型
                intent.setType("image/*");
                //打开图库界面
                startActivityForResult(intent, GALLERY_REQUEST_CODE);
            }
        });
    }

    //把bitmap图像保存到sd卡中
    private Uri saveBitmap(Bitmap bm)
    {
        File tmpDir = new File(Environment.getExternalStorageDirectory() + "/com.jikexueyuan.avater");
        //如果路径不存在，则创建
        if(!tmpDir.exists())
        {
            tmpDir.mkdir();
        }
        //保存在这个文件夹下
        File file_img = new File(tmpDir.getAbsolutePath() + "avater.png");

//        boolean sdCard = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
//        if(sdCard){
//            String filePath = Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"temp.png";
//            tmDir = new File(filePath);
//            //转换为file对象 如果路径不存在，则创建
//            if(!tmDir.exists()){
//                tmDir.mkdirs();
//            }
//        }
        
        try {
            //把图像写入文件操作
            FileOutputStream fos = new FileOutputStream(file_img);
            //压缩操作
            bm.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            //把文件路径转为成为一个uri,然后返回
            return Uri.fromFile(file_img);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //转换uri的方法
    private Uri convertUri(Uri uri)
    {
        InputStream is = null;
        try {
            is = getContentResolver().openInputStream(uri);
            //把contenturi转换成一个bitmap图像
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            is.close();
            return saveBitmap(bitmap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    //图像裁剪方法
    private void startImageZoom(Uri uri)
    {
        //new一个图像裁剪的intent
        Intent intent = new Intent("com.android.camera.action.CROP");
        //设置数据和类型 uri和图像类型
        intent.setDataAndType(uri, "image/*");
        //可以裁剪的
        intent.putExtra("crop", "true");
        //图片的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        //裁剪图片的宽和高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        //返回数据
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //拍照
        if(requestCode == CAMERA_REQUEST_CODE)
        {
            //这句话的意思是当用于点击了取消，并没有相片数据就这样操作
            if(data == null)
            {
                return;
            }
            else
            {
                Bundle extras = data.getExtras();
                //获取的内容不为空
                if(extras != null)
                {
                    Bitmap bm = extras.getParcelable("data");
                    //保存sd卡后返回一个file类型的uri
                    Uri file_uri = saveBitmap(bm);
                    //图像裁剪的uri必须是file类型的
                    startImageZoom(file_uri);
                }
            }
        }
        //图库
        else if(requestCode == GALLERY_REQUEST_CODE)
        {
            //如果图库不为空
            if(data == null)
            {
                return;
            }
            Uri uri;
            //从图库中获取的content类型的uri是content类型的，必须要转化
            uri = data.getData();
            //把content类型的uri转换为file类型的uri，然后保存sd卡后把文件路径转为成为一个uri,然后返回
            Uri fileUri = convertUri(uri);

            startImageZoom(fileUri);
//            不裁剪
        }
        //是否从裁剪界面返回
        else if(requestCode == CROP_REQUEST_CODE)
        {
            //用户是保存还是取消
            if(data == null)
            {
                return;
            }
            Bundle extras = data.getExtras();
            //获取的内容是否为空
            if(extras == null){
                return;
            }
            Bitmap bm = extras.getParcelable("data");
            ImageView imageView = (ImageView)findViewById(R.id.imageView);
            imageView.setImageBitmap(bm);
            //图片上传
//            sendImage(bm);
        }
    }
    //图片上传
//    private void sendImage(Bitmap bm)
//    {
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        bm.compress(Bitmap.CompressFormat.PNG, 60, stream);
//        //把bitmap转换为数组类型
//        byte[] bytes = stream.toByteArray();
//        //把字符数组转换为Base64位的数据，这样好传输到服务器
//        String img = new String(Base64.encodeToString(bytes, Base64.DEFAULT));
//        //new 一个对象
//        AsyncHttpClient client = new AsyncHttpClient();
//        //new 一个RequestParams对象，这个对象用来保存img数据
//        RequestParams params = new RequestParams();
//        params.add("img", img);
//
//        client.post("http://192.168.56.1/ImgUpload.php", params, new AsyncHttpResponseHandler() {
//            @Override
//            public void onSuccess(int i, Header[] headers, byte[] bytes) {
//                Toast.makeText(MainActivity.this, "Upload Success!", Toast.LENGTH_LONG).show();
//
//            }
//
//            @Override
//            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
//                Toast.makeText(MainActivity.this, "Upload Fail!", Toast.LENGTH_LONG).show();
//            }
//        });
//    }

 
}

