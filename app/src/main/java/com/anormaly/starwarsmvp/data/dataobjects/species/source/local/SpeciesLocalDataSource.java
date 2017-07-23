package com.anormaly.starwarsmvp.data.dataobjects.species.source.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.anormaly.starwarsmvp.data.dataobjects.species.source.Species;
import com.anormaly.starwarsmvp.data.dataobjects.species.source.SpeciesDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.species.source.local.SpeciesDBHelper;
import com.anormaly.starwarsmvp.data.dataobjects.species.source.local.SpeciesORM;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ichigo on 12/07/17.
 */

public class SpeciesLocalDataSource implements SpeciesDataSource
{

    private static SpeciesLocalDataSource INSTANCE;
    private SpeciesDBHelper mDbHelper;


    private SpeciesLocalDataSource(@NonNull Context context)
    {
        mDbHelper = new SpeciesDBHelper(context);
    }

    public static SpeciesLocalDataSource getInstance(Context context)
    {
        if (INSTANCE == null) INSTANCE = new SpeciesLocalDataSource(context);
        return INSTANCE;
    }

    @Override
    public void loadSpecies(LoadSpeciesCallback callback)
    {

        try
        {
            List<SpeciesORM> speciesOrm = mDbHelper.getSpeciesDao().queryForAll();
            List<Species> result = new ArrayList<>();
            for (int i = 0; i < speciesOrm.size(); i++)
            {
                result.add(speciesOrm.get(i).getSpecies());
            }
            callback.onSpeciesLoaded(result);
        } catch (SQLException e)
        {
            callback.onDataNotAvailable();
        }


    }

    public void saveSpecies(Species species, SaveSpeciesCallback callback)
    {

        try
        {
            SpeciesORM speciesORm = mDbHelper.getSpeciesDao().createIfNotExists(new SpeciesORM(species));
            if (speciesORm != null) callback.onSaved();
            else callback.onDataNotSaved();
        } catch (SQLException e)
        {
            callback.onDataNotSaved();
        }
    }
}
