package com.example.zq.kaiyanstudy.donghua;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.zq.kaiyanstudy.R;


/**
 * Created by stevenzhang on 2017/1/6 0006.
 */

public class MainActivity  extends AppCompatActivity{
    
    private static final String TAG ="MainActivity";
    
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void imageClick(View view){

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,view,getString(R.string.image_transition));
        Intent intent = new Intent(this,DetailActivity.class);
       CustomImageView image = (CustomImageView) view;
        intent.putExtra(DetailActivity.EXTRA_IMAGE,image.getImageId());
        startActivity(intent,options.toBundle());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_img);
//        setSupportActionBar((Toolbar) findViewById(R.id.activity_img_toolbar));
    }
}
