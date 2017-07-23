package com.anormaly.starwarsmvp.root;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anormaly.starwarsmvp.R;
import com.anormaly.starwarsmvp.data.categories.source.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ichigo on 13/07/17.
 */

public class RootAdapter extends RecyclerView.Adapter<RootAdapter.ViewHolder>
{

    private List<Category> mCategoriesList;
    private GetItemClick listener;

    public RootAdapter()
    {
        mCategoriesList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.root_recyler_item,parent,false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.mCategoryTextView.setText(mCategoriesList.get(position).getName());
        holder.mCategoryTextView.setTag(mCategoriesList.get(position));
        holder.mCategoryTextView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(listener!=null) listener.onItemClick(view);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mCategoriesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mCategoryTextView;
        public ViewHolder(View itemView)
        {
            super(itemView);
            mCategoryTextView = (TextView) itemView;
        }
    }

    public void add(List<Category> categories){

        mCategoriesList.clear();
        mCategoriesList.addAll(categories);
        notifyDataSetChanged();
    }

    public void setListener(GetItemClick listener)
    {
        this.listener = listener;
    }

    interface GetItemClick{
        void onItemClick(View view);
    }
}
