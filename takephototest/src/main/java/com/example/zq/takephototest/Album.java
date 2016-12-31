package com.example.zq.takephototest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Album extends Activity  implements View.OnClickListener{
	
	private static int REQCODE1=1;
	private static int REQCODE2=2;
	private static int REQCODE3=3;
	private File tmDir;
	private ImageView image;
	private Bitmap bitmap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		
		initData();
	}

	private void initData() {
		
		Button btnCameral = (Button) findViewById(R.id.btn_camera);
		Button btnGallery = (Button) findViewById(R.id.btn_gallery);
		image = (ImageView) findViewById(R.id.imageView);
		btnCameral.setOnClickListener(this);
		btnGallery.setOnClickListener(this);
	
		boolean sdCard = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
		if(sdCard){
			String filePath = Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"temp.png";
			tmDir = new File(filePath);
			//转换为file对象 如果路径不存在，则创建
			if(!tmDir.exists()){
				tmDir.mkdirs();
			}
		}
		//回收bitmap
		destroyBitmap();
	}
	@Override
	public void onClick(View view) {
		switch (view.getId()){
			
			case R.id.btn_camera:
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(intent,REQCODE1);
				break;
			case R.id.btn_gallery:
				Intent intent2 = new Intent(Intent.ACTION_GET_CONTENT);
				intent2.setType("image/*");
				startActivityForResult(intent2,REQCODE2);
				break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if(resultCode==RESULT_OK)
		{
			if(requestCode==REQCODE1){
				Bundle bundle = data.getExtras();
				Bitmap bitmap =  bundle.getParcelable("data");
				//进行裁减处理
				Uri uri  = saveBitmap(bitmap);
				//或者通过TakePhoto类中的下面两行代码获得uri
//				File  file  = new File(mFilePath);
//				Uri uri = Uri.fromFile(file);
				startImageZoom(uri);
			}else if(requestCode==REQCODE2){
				Uri uri = data.getData();
				Uri fileUri = convertUri(uri);
				startImageZoom(fileUri);
			}else if(requestCode==REQCODE3){
				Bundle bundle = data.getExtras();
				//获取的内容是否为空
				bitmap =  bundle.getParcelable("data");
				image.setImageBitmap(bitmap);
			}
		}
	}
	//拍照
	private Uri saveBitmap(Bitmap mBitmap) {
		try {
//			File tmpDir = new File(Environment.getExternalStorageDirectory() + "/com.jikexueyuan.avater");
//			//如果路径不存在，则创建
//			if(!tmpDir.exists())
//			{
//				tmpDir.mkdir();
//			}
//			//保存在这个文件夹下
//			File file_img = new File(tmpDir.getAbsolutePath() + "avater.png");
			FileOutputStream fos = new FileOutputStream(tmDir);
			//把图像写入流中
			mBitmap.compress(Bitmap.CompressFormat.PNG,100,fos);
			fos.flush();
			fos.close();
			//把file文件转换为uri 
			return Uri.fromFile(tmDir);
		}  catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	//相册
	private Uri convertUri(Uri uri) {

		InputStream is = null;

		try {
			is = getContentResolver().openInputStream(uri);
			Bitmap bitmap = BitmapFactory.decodeStream(is);
			is.close();
		return saveBitmap(bitmap);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	
//	//照片裁减
//	private void startImageZoom(Uri uri) {
//		Intent intent = new Intent ("com.android.camera.action.CROP");
//		//设置uri和图像类型
//		intent.setDataAndType(uri,"image/*");
//		intent.putExtra("crop","true");
//		//缩放比例
//		intent.putExtra("aspectX",1);
//		intent.putExtra("aspectY",1);
//		//裁减图片的宽高
//		intent.putExtra("outputX",150);
//		intent.putExtra("outputY",150);
//		//返回数据
//		intent.putExtra("return-data",true);
//		startActivityForResult(intent,REQCODE3);
//	
//	}

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
		startActivityForResult(intent, REQCODE3);
	}
	
	private void destroyBitmap() {
		
		if(bitmap!=null&&!bitmap.isRecycled()){
			bitmap.recycle();
			bitmap=null;
		}
		
	}
	
	
	
}
