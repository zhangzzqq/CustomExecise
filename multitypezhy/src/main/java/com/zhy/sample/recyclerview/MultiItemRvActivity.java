package com.zhy.sample.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zhy.adapter.recyclerview.wrapper.LoadMoreWrapper;
import com.zhy.sample.R;
import com.zhy.sample.adapter.rv.ChatAdapterForRv;
import com.zhy.sample.bean.ChatMessage;

import java.util.ArrayList;
import java.util.List;

public class MultiItemRvActivity extends AppCompatActivity
{
    private RecyclerView mRecyclerView;

    private LoadMoreWrapper mLoadMoreWrapper;
    //数据源
    private List<ChatMessage> mDatas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);


        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //添加数据源
        mDatas.addAll(ChatMessage.MOCK_DATAS);
        //复杂adapter,把数据传递进去
        ChatAdapterForRv adapter = new ChatAdapterForRv(this, mDatas);
        
        mRecyclerView.setAdapter(adapter);
//        //加载更多
//        mLoadMoreWrapper = new LoadMoreWrapper(adapter);
//        mLoadMoreWrapper.setLoadMoreView(LayoutInflater.from(this).inflate(R.layout.default_loading, mRecyclerView, false));
//        mLoadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener()
//        {
//            @Override
//            public void onLoadMoreRequested()
//            {
//                new Handler().postDelayed(new Runnable()
//                {
//                    @Override
//                    public void run()
//                    {
//                        boolean coming = Math.random() > 0.5;
//                        ChatMessage msg = null;
//                        msg = new ChatMessage(coming ? R.drawable.renma : R.drawable.xiaohei, coming ? "人马" : "xiaohei", "where are you " + mDatas.size(),
//                                null, coming);
//                        mDatas.add(msg);
//                        mLoadMoreWrapper.notifyDataSetChanged();
//
//                    }
//                }, 3000);
//            }
//        });
//
//        adapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener()
//        {
//            @Override
//            public void onItemClick(View view, RecyclerView.ViewHolder holder,  int position)
//            {
//                Toast.makeText(MultiItemRvActivity.this, "Click:" + position , Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position)
//            {
//                Toast.makeText(MultiItemRvActivity.this, "LongClick:" + position , Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
//        mRecyclerView.setAdapter(mLoadMoreWrapper);
    }


}
