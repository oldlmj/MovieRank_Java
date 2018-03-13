package com.example.olo.movierank.ExpandableListTest;

import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.olo.movierank.R;

/**
 * Created by OLO on 2018/3/7.
 */

public class ExpandableListTestAdapter  extends BaseExpandableListAdapter {
    private static final String TAG = "ExpandableListTestAdapter";
    private String[] groupData;
    private String[][] childData;
    private String[][] childDataUrl;
    private OnGroupExpandedListener mOnGroupExpandedListener;
       //用於存放Indicaton的集合
    private SparseArray<ImageView> mIndicators;

    public ExpandableListTestAdapter(String[] groupData, String[][] childData,String[][] childDataUrl) {
        this.groupData = groupData;
        this.childData = childData;
        this.childDataUrl = childDataUrl;
        mIndicators = new SparseArray<>();
    }
    //            根据分组的展开闭合状态设置指示器
    public void setIndicatorState(int groupPosition, boolean isExpanded) {
        if (isExpanded) {
            mIndicators.get(groupPosition).setImageResource(R.drawable.ic_expand_less_white_24dp);
        } else {
            mIndicators.get(groupPosition).setImageResource(R.drawable.ic_expand_more_white_24dp);
        }
    }
    public void setOnGroupExpandedListener(OnGroupExpandedListener onGroupExpandedListener) {
        mOnGroupExpandedListener = onGroupExpandedListener;
    }

    @Override
    public int getGroupCount() {
        return groupData.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childData[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupData[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childData[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
    //获取显示指定分组的视图
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View
            convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandablelistview_group_item, parent, false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.tvTitle = (TextView) convertView.findViewById(R.id.txt_group);
            groupViewHolder.ivIndicator = (ImageView) convertView.findViewById(R.id.iv_indicator);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.tvTitle.setText(groupData[groupPosition]);
        //      把位置和图标添加到Map
        mIndicators.put(groupPosition, groupViewHolder.ivIndicator);
        //      根据分组状态设置Indicator
        setIndicatorState(groupPosition, isExpanded);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View
            convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandablelistview_child_item, parent, false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.tvTitle = (TextView) convertView.findViewById(R.id.txt_demo);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        childViewHolder.tvTitle.setText(childData[groupPosition][childPosition]);
        String X=childDataUrl[groupPosition][childPosition];

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        Log.d(TAG, "onGroupExpanded() called with: groupPosition = [" + groupPosition + "]");
        if (mOnGroupExpandedListener != null) {
            mOnGroupExpandedListener.onGroupExpanded(groupPosition);
        }
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        Log.d(TAG, "onGroupCollapsed() called with: groupPosition = [" + groupPosition + "]");
    }

    private static class GroupViewHolder {
        TextView tvTitle;
        ImageView ivIndicator;
    }

    private static class ChildViewHolder {
        TextView tvTitle;
    }
}
