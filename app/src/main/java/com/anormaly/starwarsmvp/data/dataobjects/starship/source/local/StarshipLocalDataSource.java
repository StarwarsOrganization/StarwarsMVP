package com.anormaly.starwarsmvp.data.dataobjects.starship.source.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.anormaly.starwarsmvp.data.dataobjects.starship.source.Starship;
import com.anormaly.starwarsmvp.data.dataobjects.starship.source.StarshipDataSource;
import com.anormaly.starwarsmvp.data.retrofit.RetrofitHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ichigo on 12/07/17.
 */

public class StarshipLocalDataSource implements StarshipDataSource
{

    private static StarshipLocalDataSource INSTANCE;
    private StarshipDBHelper mDbHelper;


    private StarshipLocalDataSource(@NonNull Context context)
    {
        mDbHelper = new StarshipDBHelper(context);
    }

    public static StarshipLocalDataSource getInstance(Context context)
    {
        if (INSTANCE == null) INSTANCE = new StarshipLocalDataSource(context);
        return INSTANCE;
    }

    @Override
    public void loadStarships(LoadStarshipsCallback callback)
    {

        try
        {
            List<StarshipORM> starshipOrm = mDbHelper.getStarshipDao().queryForAll();
            List<Starship> result = new ArrayList<>();
            for (int i = 0; i < starshipOrm.size(); i++)
            {
                result.add(starshipOrm.get(i).getStarship());
            }
            callback.onStarshipLoaded(result);
        } catch (SQLException e)
        {
            callback.onDataNotAvailable();
        }


    }

    public void saveStarship(Starship starship, SaveStarshipCallback callback)
    {

        try
        {
            StarshipORM starshipORm = mDbHelper.getStarshipDao().createIfNotExists(new StarshipORM(starship));
            if (starshipORm != null) callback.onSaved();
            else callback.onDataNotSaved();
        } catch (SQLException e)
        {
            callback.onDataNotSaved();
        }
    }

    @Override
    public void loadStarship(int id, @NonNull LoadStarshipCallback callback)
    {
        try{
            List<StarshipORM> starshipORM = mDbHelper.getStarshipDao().queryForEq("url", RetrofitHelper.BASE_URL+"starships/"+id+"/");
            if(starshipORM!=null && !starshipORM.isEmpty()) callback.onStarshipLoaded(starshipORM.get(0).getStarship());
        } catch (SQLException e)
        {
            callback.onDataNotAvailable();
        }
    }
}
