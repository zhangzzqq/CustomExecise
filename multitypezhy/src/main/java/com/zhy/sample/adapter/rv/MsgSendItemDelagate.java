package com.zhy.sample.adapter.rv;

import android.util.Log;

import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.sample.R;
import com.zhy.sample.bean.ChatMessage;

/**
 * Created by zhy on 16/6/22.
 */
public class MsgSendItemDelagate implements ItemViewDelegate<ChatMessage>
{             
    private static final String TAG = "MsgSendItemDelagate";
    
    @Override
    public int getItemViewLayoutId()
    {
        Log.v(TAG,"===getItemViewLayoutId===");
        return R.layout.main_chat_send_msg;
    }

    @Override
    public boolean isForViewType(ChatMessage item, int position)
    {
        Log.v(TAG,"position=="+position);
      //从position 等于0的时候就开始显示，true代表是当前的view类型，false表示不是当前的view类型，所以就不会显示出来
        
        if(position==1){
            return  true;
        }else {
            return false;
        }

        //或者 return item.getType()==
        
//        return !item.isComMeg();
//        return true;
        
    }

    @Override
    public void convert(ViewHolder holder, ChatMessage chatMessage, int position)
    {
        Log.v(TAG,"===convert===");
        holder.setText(R.id.chat_send_content, chatMessage.getContent());
        holder.setText(R.id.chat_send_name, chatMessage.getName());
        holder.setImageResource(R.id.chat_send_icon, chatMessage.getIcon());
        
    }
}
