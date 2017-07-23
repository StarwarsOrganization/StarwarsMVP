package com.anormaly.starwarsmvp.people;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anormaly.starwarsmvp.R;
import com.anormaly.starwarsmvp.data.dataobjects.DataObject;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.People;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ichigo on 13/07/17.
 */

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder>
{


    private final ArrayList<People> mPeopleList;
    private GetItemClick mListener;

    public PeopleAdapter()
    {
        mPeopleList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.people_recyler_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.nameTextView.setText(mPeopleList.get(position).getName());
        holder.nameTextView.setTag(mPeopleList.get(position));
        holder.nameTextView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(mListener!=null) mListener.onItemClick(view);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mPeopleList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView nameTextView;
        public ViewHolder(View itemView)
        {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
        }
    }

    public void add(List<People> peopleList){
        mPeopleList.clear();
        mPeopleList.addAll(peopleList);
        notifyDataSetChanged();
    }

    public void setListener(GetItemClick listener)
    {
        mListener = listener;
    }

    interface GetItemClick{
        void onItemClick(View view);
    }
}
