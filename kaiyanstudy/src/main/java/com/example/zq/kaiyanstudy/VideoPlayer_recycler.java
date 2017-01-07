package com.example.zq.kaiyanstudy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by stevenzhang on 2017/1/5 0005.
 */
public class VideoPlayer_recycler extends RecyclerView.Adapter<VideoPlayer_recycler.ViewHolder>{

    private Context context;
    private List<Integer> list;
    private LayoutInflater inflater;
    public ImageView image;
    public static final int TYPE_HEADER = 0;  //说明是带有Header的
    public static final int TYPE_FOOTER = 1;  //说明是带有Footer的
    public static final int TYPE_NORMAL = 2;  //说明是不带有header和footer的,一般情况recyclerView
    //HeaderView, FooterView
    private View mHeaderView;
    private View mFooterView;
    private static final String TAG = "VideoPlayer_recycler";
    public VideoPlayer_recycler(Context context, List list){
        
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    public View getHeaderView() {
        return mHeaderView;
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public View getFooterView() {
        return mFooterView;
    }
    public void setFooterView(View footerView) {
        mFooterView = footerView;
        notifyItemInserted(getItemCount()-1);
    }
    /**
     * 重写这个方法，很重要，是加入Header和Footer的关键，我们通过判断item的类型，从而绑定不同的view
     * */
    @Override
    public int getItemViewType(int position) {
        
        if (position == 0&&mHeaderView!=null){
            //第一个item应该加载Header
            return TYPE_HEADER;
        }else if(position==getItemCount()-1&&mFooterView!=null){
            return TYPE_FOOTER;
        }else {
            return TYPE_NORMAL; 
        }
        
        //atention,没有判断mFooterView是否为null
//        if (position == getItemCount()-1){
//            //最后一个,应该加载Footer
//            return TYPE_FOOTER;
//        }
      
    }
    
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加入头部和尾部
        if( viewType == TYPE_HEADER) {
            return new ViewHolder(mHeaderView);
        }
        if(viewType == TYPE_FOOTER){
            return new ViewHolder(mFooterView);
        }
       View view = inflater.inflate(R.layout.item_video_recycler,parent,false);
        return new ViewHolder(view);
    }

    //绑定View，这里是根据返回的这个position的类型，从而进行绑定的， HeaderView和FooterView, 就不同绑定了
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        View view = holder.mView;
       Log.e(TAG,"position=="+position) ;
        if(getItemViewType(position) == TYPE_NORMAL){
            if(holder instanceof ViewHolder) {
                int str = list.get(position-1);
                Log.e(TAG,"str=="+position);
                //这里加载数据的时候要注意，是从position-1开始，因为position==0已经被header占用了
                ((ViewHolder) holder).image.setImageResource(list.get(position-1));
                return;
            }
            return;
        }else if(getItemViewType(position) == TYPE_HEADER){
                
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    
                    firstItemTouchListener.onFirstItemTouch(view,motionEvent);
                    return true;
                }
            });
            
            return;
        }else{
            return;
        }
      
        
    }
        //size=list.size()+2
    @Override
    public int getItemCount() {
        if(mHeaderView == null && mFooterView == null){
            return list.size();
        }else if(mHeaderView == null && mFooterView != null){
            return list.size() + 1;
        }else if (mHeaderView != null && mFooterView == null){
            return list.size() + 1;
        }else if(mHeaderView!=null&&mFooterView!=null){
            return list.size() + 2;
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        public final View  mView;
        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            //如果是headerview或者是footerview,直接返回，暂不处理
            if (itemView == mHeaderView){
                return;
            }
            if (itemView == mFooterView){
                return;
            }
            //正常一般情况
           image= (ImageView) itemView.findViewById(R.id.iv_head);

        }
    }

    public interface  FirstItemTouchListener{
        boolean onFirstItemTouch(View view, MotionEvent motionEvent);
    }
    private FirstItemTouchListener firstItemTouchListener;
    public void setOnItemTouchListener (FirstItemTouchListener listener){
        this.firstItemTouchListener = listener;
    }
    
}
