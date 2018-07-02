package com.example.zq.popwindowtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.example.zq.popwindowtest.R;

import java.util.List;

/**
 * ClassName:
 * Description:
 * Create by: steven
 * Date: 2018/6/27
 */
public class ListAdapters extends BaseAdapter {

    private Context context;
    private List<String> list;
    private LayoutInflater inflater;


    public ListAdapters( List<String> list,Context context) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new viewHolder();
            convertView = inflater.inflate(R.layout.item_tv, parent, false);

            viewHolder.et = (EditText) convertView.findViewById(R.id.et);

            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ListAdapters.viewHolder) convertView.getTag();
        }


        viewHolder.et.setText(list.get(position));
        return convertView;
    }


    static class viewHolder {
        EditText et;

    }


}
