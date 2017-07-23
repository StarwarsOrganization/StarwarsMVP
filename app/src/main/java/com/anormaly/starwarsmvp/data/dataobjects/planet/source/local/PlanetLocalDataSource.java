package com.anormaly.starwarsmvp.data.dataobjects.planet.source.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.anormaly.starwarsmvp.data.dataobjects.people.source.People;
import com.anormaly.starwarsmvp.data.dataobjects.planet.source.Planet;
import com.anormaly.starwarsmvp.data.dataobjects.planet.source.PlanetDataSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ichigo on 12/07/17.
 */
public class PlanetLocalDataSource implements PlanetDataSource
{

    private static PlanetLocalDataSource INSTANCE;
    private PlanetDBHelper mDbHelper;


    private PlanetLocalDataSource(@NonNull Context context)
    {
        mDbHelper = new PlanetDBHelper(context);
    }

    public static PlanetLocalDataSource getInstance(Context context)
    {
        if (INSTANCE == null) INSTANCE = new PlanetLocalDataSource(context);
        return INSTANCE;
    }

    @Override
    public void loadPlanets(LoadPlanetCallback callback)
    {

        try
        {
            List<PlanetORM> planetOrm = mDbHelper.getPlanetDao().queryForAll();
            List<Planet> result = new ArrayList<>();
            for (int i = 0; i < planetOrm.size(); i++)
            {
                result.add(planetOrm.get(i).getPlanet());
            }
            callback.onPlanetLoaded(result);
        } catch (SQLException e)
        {
            callback.onDataNotAvailable();
        }


    }

    public void savePlanet(Planet planet, SavePlanetCallback callback)
    {

        try
        {
            PlanetORM planetORm = mDbHelper.getPlanetDao().createIfNotExists(new PlanetORM(planet));
            if (planetORm != null) callback.onSaved();
            else callback.onDataNotSaved();
        } catch (SQLException e)
        {
            callback.onDataNotSaved();
        }
    }
}
