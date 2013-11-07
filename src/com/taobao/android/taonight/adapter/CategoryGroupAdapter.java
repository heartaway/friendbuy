package com.taobao.android.taonight.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.taobao.android.taonight.R;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 13-1-14
 * Time: ����11:13
 * To change this template use File | Settings | File Templates.
 */
public class CategoryGroupAdapter extends BaseAdapter {

    private Context context;

    private List<String> list;

    public CategoryGroupAdapter() {
    }

    public CategoryGroupAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }


    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.category_item, null);
            holder = new ViewHolder();
            convertView.setTag(holder);
            holder.goupItem = (TextView) convertView.findViewById(R.id.category_group_item);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.goupItem.setTextColor(Color.parseColor("#666666"));
        holder.goupItem.setText(list.get(position));
        return convertView;
    }


    @Override
    public long getItemId(int i) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    static class ViewHolder {
        TextView goupItem;
    }
}
