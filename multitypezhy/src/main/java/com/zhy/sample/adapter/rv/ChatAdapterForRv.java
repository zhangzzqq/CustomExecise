package com.zhy.sample.adapter.rv;

import android.content.Context;

import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.sample.bean.ChatMessage;

import java.util.List;

/**
 * Created by zhy on 15/9/4.
 */
public class ChatAdapterForRv extends MultiItemTypeAdapter<ChatMessage>
{
    public static final int TYPE_VIEWPAGER = 0;
    public ChatAdapterForRv(Context context, List<ChatMessage> datas)
    {
        super(context, datas);
        //ChatMessage25条数据被被两个addItemViewDelegate()所瓜分显示。
        //如果是一个addItemViewDelegate 那数据都会显示在当前的itemView
        addItemViewDelegate(new MsgSendItemDelagate());
        addItemViewDelegate(new MsgComingItemDelagate());


        addItemViewDelegate(TYPE_VIEWPAGER,new MsgComingItemDelagate());
    }
}
