package com.example.zq.customimageview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private static final String Url = "http://www.meiyaoni.com.cn//Uploads/app/avatar/head_6/head.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       RoundImageView  roundImage = (RoundImageView) findViewById(R.id.roundimage);
       CircleImageView  circleImageView = (CircleImageView) findViewById(R.id.circleimageview);
        ImageView view1 = (ImageView) findViewById(R.id.iv1);
        ImageView view2 = (ImageView) findViewById(R.id.iv2);

//        Glide.with(MainActivity.this).load(Url).into(roundImage);
//        Picasso.with(MainActivity.this).load(Url).into(roundImage);

//        Glide.with(MainActivity.this).load(Url).into(circleImageView);

        Glide.with(MainActivity.this).load(Url).transform(new GlideCircleTransform(MainActivity.this)).into(view1);
         //必须写，否则会报类型转化异常
        Glide.with(MainActivity.this).load(Url).asBitmap().transform(new GlideRoundTransform(MainActivity.this)).into(view2 );
        
    }
    
    public static Bitmap drawableToBitmap(Drawable drawable) {
        // 取 drawable 的长宽
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();

        // 取 drawable 的颜色格式
        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                : Bitmap.Config.RGB_565;
        // 建立对应 bitmap
        Bitmap bitmap = Bitmap.createBitmap(w, h, config);
        // 建立对应 bitmap 的画布
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        // 把 drawable 内容画到画布中
        drawable.draw(canvas);
        return bitmap;
    }
/**
 * RoundedBitmapDrawable 是 V4 下的一个类，不能简单的通过：强制转换成 BitmapDrawable 来获取 bitmap
 * Bitmap bitmap = ((BitmapDrawable)xxx).getBitmap();
 */
}
