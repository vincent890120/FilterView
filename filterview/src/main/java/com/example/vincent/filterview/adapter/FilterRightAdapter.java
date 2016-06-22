package com.example.vincent.filterview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vincent.filterview.entity.FilterEntity;
import com.example.vincent.filterview.R;

import java.util.List;

/**
 * Created by vincent on 16/6/21.
 */
public class FilterRightAdapter extends BaseListAdapter<FilterEntity> {

    private FilterEntity selectedEntity;

    public FilterRightAdapter(Context context) {
        super(context);
    }

    public FilterRightAdapter(Context context, List<FilterEntity> list) {
        super(context, list);
    }

    public void setSelectedEntity(FilterEntity filterEntity) {
        this.selectedEntity = filterEntity;
        for (FilterEntity entity : getData()) {
            entity.setSelected(entity.getKey().equals(selectedEntity.getKey()));
        }
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_filter_right, null);
            holder.ivImage = (ImageView) convertView.findViewById(R.id.iv_image);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        FilterEntity entity = getItem(position);

        holder.tvTitle.setText(entity.getKey());
        if (entity.isSelected()) {
            holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.orange));
        } else {
            holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.font_black_3));
        }

        return convertView;
    }

    private class ViewHolder {
        private ImageView ivImage;
        private TextView tvTitle;
    }
}

