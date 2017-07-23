package com.anormaly.starwarsmvp.data.dataobjects.species.source.remote;

import android.content.Context;

import com.anormaly.starwarsmvp.data.dataobjects.DataObjectList;
import com.anormaly.starwarsmvp.data.dataobjects.species.source.Species;
import com.anormaly.starwarsmvp.data.dataobjects.species.source.SpeciesDataSource;
import com.anormaly.starwarsmvp.data.retrofit.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ichigo on 12/07/17.
 */

public class SpeciesRemoteDataSource implements SpeciesDataSource
{
    private static final String TAG = SpeciesRemoteDataSource.class.getSimpleName();

    private static SpeciesRemoteDataSource INSTANCE;
    private final Context mContext;

    private SpeciesRemoteDataSource(Context context)
    {
        mContext = context;
    }

    public static SpeciesRemoteDataSource getInstance(Context context)
    {
        if (INSTANCE == null) INSTANCE = new SpeciesRemoteDataSource(context);
        return INSTANCE;
    }

    @Override
    public void loadSpecies(final LoadSpeciesCallback callback)
    {
        new RetrofitHelper(mContext).getService().getSpecies("").enqueue(new Callback<DataObjectList<Species>>()
        {
            @Override
            public void onResponse(Call<DataObjectList<Species>> call, Response<DataObjectList<Species>> response)
            {
                if(response.isSuccessful()){
                    callback.onSpeciesLoaded(response.body().get());
                }else{
                    callback.onDataNotAvailable();
                }
            }

            @Override
            public void onFailure(Call<DataObjectList<Species>> call, Throwable t)
            {
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void saveSpecies(Species species,SaveSpeciesCallback callback)
    {
        callback.onDataNotSaved();
    }
}
