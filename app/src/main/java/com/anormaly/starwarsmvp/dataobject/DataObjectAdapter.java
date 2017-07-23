package com.anormaly.starwarsmvp.dataobject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anormaly.starwarsmvp.R;
import com.anormaly.starwarsmvp.data.categories.source.Category;
import com.anormaly.starwarsmvp.data.categories.source.CategoryDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.DataObject;
import com.anormaly.starwarsmvp.data.dataobjects.film.source.Film;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.People;
import com.anormaly.starwarsmvp.data.dataobjects.planet.source.Planet;
import com.anormaly.starwarsmvp.data.dataobjects.species.source.Species;
import com.anormaly.starwarsmvp.data.dataobjects.starship.source.Starship;
import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ichigo on 13/07/17.
 */

public class DataObjectAdapter extends RecyclerView.Adapter<DataObjectAdapter.ViewHolder>
{


    private final ArrayList<DataObject> mDataObjects;
    private final Category mCategory;
    private GetItemClick mListener;
    private OnLoadMoreListener mOnLoadMoreListener;
    private boolean loading;

    public DataObjectAdapter(Category category)
    {
        mDataObjects = new ArrayList<>();
        mCategory = category;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.people_recyler_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        String text = "";
        switch (mCategory.getId())
        {

            case CategoryDataSource.FILMS_TYPE:
                text = ((Film) mDataObjects.get(position)).getTitle();
                break;
            case CategoryDataSource.PEOPLE_TYPE:
                text = ((People) mDataObjects.get(position)).getName();
                break;
            case CategoryDataSource.PLANETS_TYPE:
                text = ((Planet) mDataObjects.get(position)).getName();
                break;
            case CategoryDataSource.SPECIES_TYPE:
                text = ((Species) mDataObjects.get(position)).getName();
                break;
            case CategoryDataSource.STARSHIPS_TYPE:
                text = ((Starship) mDataObjects.get(position)).getName();
                break;
            case CategoryDataSource.VEHICLES_TYPE:
                text = ((Vehicle) mDataObjects.get(position)).getName();
                break;
            default:

                break;


        }
        holder.nameTextView.setText(text);
        holder.nameTextView.setTag(mDataObjects.get(position));
        holder.nameTextView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (mListener != null) mListener.onItemClick(view);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mDataObjects.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView nameTextView;

        public ViewHolder(View itemView)
        {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
        }
    }

    public void add(List<? extends DataObject> dataObjects)
    {
        mDataObjects.clear();
        mDataObjects.addAll(dataObjects);
        notifyDataSetChanged();
    }

    public void setListener(GetItemClick listener)
    {
        mListener = listener;
    }


    public void setOnLoadMoreListener(OnLoadMoreListener listener)
    {
        mOnLoadMoreListener = listener;
    }

    public OnLoadMoreListener getOnLoadMoreListener()
    {
        return mOnLoadMoreListener;
    }

    interface GetItemClick
    {
        void onItemClick(View view);
    }

    public boolean isLoading()
    {
        return loading;
    }

    public void setLoading(boolean loading)
    {
        this.loading = loading;
    }
}
