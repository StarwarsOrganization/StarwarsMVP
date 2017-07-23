package com.anormaly.starwarsmvp.data.dataobjects.planet.source.remote;

import android.content.Context;

import com.anormaly.starwarsmvp.data.dataobjects.DataObjectList;
import com.anormaly.starwarsmvp.data.dataobjects.planet.source.PlanetDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.planet.source.Planet;
import com.anormaly.starwarsmvp.data.retrofit.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ichigo on 12/07/17.
 */

public class PlanetRemoteDataSource implements PlanetDataSource
{
    private static final String TAG = PlanetRemoteDataSource.class.getSimpleName();

    private static PlanetRemoteDataSource INSTANCE;
    private final Context mContext;

    private PlanetRemoteDataSource(Context context)
    {
        mContext = context;
    }

    public static PlanetRemoteDataSource getInstance(Context context)
    {
        if (INSTANCE == null) INSTANCE = new PlanetRemoteDataSource(context);
        return INSTANCE;
    }

    @Override
    public void loadPlanets(final PlanetDataSource.LoadPlanetCallback callback)
    {
        new RetrofitHelper(mContext).getService().getPlanets("").enqueue(new Callback<DataObjectList<Planet>>()
        {
            @Override
            public void onResponse(Call<DataObjectList<Planet>> call, Response<DataObjectList<Planet>> response)
            {
                if(response.isSuccessful()){
                    callback.onPlanetLoaded(response.body().get());
                }else{
                    callback.onDataNotAvailable();
                }
            }

            @Override
            public void onFailure(Call<DataObjectList<Planet>> call, Throwable t)
            {
                callback.onDataNotAvailable();
            }
        });
    }


    @Override
    public void savePlanet(Planet planet, SavePlanetCallback callback)
    {
        callback.onDataNotSaved();
    }
}
