package com.anormaly.starwarsmvp.data.dataobjects.planet.source;

import android.content.Context;
import android.support.annotation.NonNull;

import com.anormaly.starwarsmvp.data.dataobjects.people.source.People;
import com.anormaly.starwarsmvp.data.dataobjects.planet.source.local.PlanetLocalDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.planet.source.remote.PlanetRemoteDataSource;

import java.util.List;

/**
 * Created by ichigo on 12/07/17.
 */

public class PlanetRepository implements PlanetDataSource
{

    private static PlanetRepository INSTANCE;
    private final PlanetDataSource mRemoteDS;
    private final PlanetDataSource mLocalDS;

    private PlanetRepository(@NonNull PlanetDataSource remoteDS, @NonNull PlanetDataSource localDS)
    {
        mRemoteDS = remoteDS;
        mLocalDS = localDS;
    }

    public static PlanetRepository getInstance(@NonNull Context context){
        if(INSTANCE == null) INSTANCE = new PlanetRepository(PlanetRemoteDataSource.getInstance(context), PlanetLocalDataSource.getInstance(context));
        return INSTANCE;
    }

    public static PlanetRepository getInstance(@NonNull PlanetDataSource remoteDS, @NonNull PlanetDataSource localDS){
        if(INSTANCE == null) INSTANCE = new PlanetRepository(remoteDS,localDS);
        return INSTANCE;
    }

    @Override
    public void loadPlanets(final LoadPlanetCallback callback)
    {
        mLocalDS.loadPlanets(new LoadPlanetCallback()
        {
            @Override
            public void onPlanetLoaded(List<Planet> planets)
            {
                if(planets!=null && planets.size()>0){
                    callback.onPlanetLoaded(planets);
                }else{
                    callRemote();
                }
            }

            @Override
            public void onDataNotAvailable()
            {
                callRemote();
            }

            public void callRemote(){
                mRemoteDS.loadPlanets(new LoadPlanetCallback()
                {
                    @Override
                    public void onPlanetLoaded(final List<Planet> planets)
                    {
                        if(planets!=null){
                            for(Planet p:planets){
                                savePlanet(p, new SavePlanetCallback()
                                {
                                    @Override
                                    public void onSaved()
                                    {
                                        callback.onPlanetLoaded(planets);
                                    }

                                    @Override
                                    public void onDataNotSaved()
                                    {
                                        callback.onPlanetLoaded(planets);
                                    }
                                });
                            }


                        }else{
                            callback.onDataNotAvailable();
                        }
                    }

                    @Override
                    public void onDataNotAvailable()
                    {
                        callback.onDataNotAvailable();
                    }
                });
            }
        });
    }

    @Override
    public void savePlanet(Planet planet, @NonNull final SavePlanetCallback callback)
    {

        mLocalDS.savePlanet(planet, new SavePlanetCallback()
        {
            @Override
            public void onSaved()
            {
                callback.onSaved();
            }

            @Override
            public void onDataNotSaved()
            {
                callback.onDataNotSaved();
            }
        });
    }
}
