package com.example.zq.kaiyanstudy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by stevenzhang on 2017/1/5 0005.
 */
public class VideoPlayer  extends RecyclerView.Adapter<VideoPlayer.ViewHolder>{

    private Context context;
    private List<String> list;
    public VideoPlayer (Context context,List list){
        
        
    }
    
    
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
