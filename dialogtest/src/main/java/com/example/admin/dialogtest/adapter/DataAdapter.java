package com.example.admin.dialogtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.dialogtest.R;

import java.util.List;

/**
 * Created by steven on 2017/11/7 0007.
 */

public class DataAdapter extends BaseAdapter {

    private List<String> listData;
    private Context mContext;
    private LayoutInflater inflater;

    public DataAdapter(List<String> data, Context context) {

        this.listData = data;
        this.mContext = context;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {

        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_list, parent, false);
            viewHolder.tvItem = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvItem.setText(listData.get(position));
        return convertView;

    }

    static class ViewHolder {
        private TextView tvItem;


    }


}
