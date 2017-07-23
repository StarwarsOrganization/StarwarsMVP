package com.anormaly.starwarsmvp.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.anormaly.starwarsmvp.R;

import java.util.List;
import java.util.Map;

/**
 * Created by ichigo on 22/07/17.
 */

public class DetailAdapter extends BaseExpandableListAdapter
{
    private final List<String> mGroups;
    private final Map<String, List<String>> mChilds;
    private Context mContext;

    public DetailAdapter(Context context,List<String> groups, Map<String,List<String>> childs)
    {

        this.mGroups = groups;
        this.mChilds = childs;
        this.mContext = context;

    }

    @Override
    public int getGroupCount()
    {
        return mGroups.size();
    }

    @Override
    public int getChildrenCount(int groupIndex)
    {
        return mChilds.get(mGroups.get(groupIndex)).size();
    }

    @Override
    public Object getGroup(int groupIndex)
    {
        return mGroups.get(groupIndex);
    }

    @Override
    public Object getChild(int groupIndex, int childIndex)
    {
        return mChilds.get(mGroups.get(groupIndex)).get(childIndex);
    }

    @Override
    public long getGroupId(int groupIndex)
    {
        return groupIndex;
    }

    @Override
    public long getChildId(int groupIndex, int childIndex)
    {
        return childIndex;
    }

    @Override
    public boolean hasStableIds()
    {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup viewGroup)
    {
        ViewHolder holder;
        if(view==null){
            view = LayoutInflater.from(mContext).inflate(R.layout.detail_parent_item,viewGroup,false);
            holder = new ViewHolder();
            holder.nameTextView = (TextView) view;
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.nameTextView.setText(mGroups.get(groupPosition));
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isExpanded, View view, ViewGroup viewGroup)
    {
        ViewHolder holder;
        if(view==null){
            view = LayoutInflater.from(mContext).inflate(R.layout.detail_child_item,viewGroup,false);
            holder = new ViewHolder();
            holder.nameTextView = (TextView)view;
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.nameTextView.setText(mChilds.get(mGroups.get(groupPosition)).get(childPosition));
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1)
    {
        return false;
    }

    static class ViewHolder {
        TextView nameTextView;
    }



}
