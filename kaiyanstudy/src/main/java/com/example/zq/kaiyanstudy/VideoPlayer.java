package com.example.zq.kaiyanstudy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by stevenzhang on 2017/1/5 0005.
 */
public class VideoPlayer  extends RecyclerView.Adapter<VideoPlayer.ViewHolder>{

    private Context context;
    private List<String> list;
    private LayoutInflater inflater;
    public VideoPlayer (Context context,List list){
        
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }
    
    
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View view = inflater.inflate(R.layout.video_item,parent,false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        View view =holder.mView;

        String str = list.get(position);
        holder.text.setText(list.get(position));



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView text;
        public final View  mView;
        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
           text= (TextView) itemView.findViewById(R.id.tv_item);

        }
    }


}
