package com.anormaly.starwarsmvp.data.dataobjects.starship.source.remote;

import android.content.Context;
import android.support.annotation.NonNull;

import com.anormaly.starwarsmvp.data.dataobjects.DataObjectList;
import com.anormaly.starwarsmvp.data.dataobjects.starship.source.Starship;
import com.anormaly.starwarsmvp.data.dataobjects.starship.source.StarshipDataSource;
import com.anormaly.starwarsmvp.data.retrofit.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by ichigo on 12/07/17.
 */

public class StarshipRemoteDataSource implements StarshipDataSource
{
    private static final String TAG = StarshipRemoteDataSource.class.getSimpleName();

    private static StarshipRemoteDataSource INSTANCE;
    private final Context mContext;

    private StarshipRemoteDataSource(Context context)
    {
        mContext = context;
    }

    public static StarshipRemoteDataSource getInstance(Context context)
    {
        if (INSTANCE == null) INSTANCE = new StarshipRemoteDataSource(context);
        return INSTANCE;
    }

    @Override
    public void loadStarships(final LoadStarshipsCallback callback)
    {
        new RetrofitHelper(mContext).getService().getStarships("").enqueue(new Callback<DataObjectList<Starship>>()
        {
            @Override
            public void onResponse(Call<DataObjectList<Starship>> call, Response<DataObjectList<Starship>> response)
            {
                if(response.isSuccessful()){
                    callback.onStarshipLoaded(response.body().get());
                }else{
                    callback.onDataNotAvailable();
                }
            }

            @Override
            public void onFailure(Call<DataObjectList<Starship>> call, Throwable t)
            {
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void saveStarship(Starship starship, SaveStarshipCallback callback)
    {
        callback.onDataNotSaved();
    }

    @Override
    public void loadStarship(int id, @NonNull final LoadStarshipCallback callback)
    {
        new RetrofitHelper(mContext).getService().getStarship(id).enqueue(new Callback<Starship>()
        {
            @Override
            public void onResponse(Call<Starship> call, Response<Starship> response)
            {
                if(response.isSuccessful()){
                    callback.onStarshipLoaded(response.body());
                }else{
                    callback.onDataNotAvailable();
                }
            }

            @Override
            public void onFailure(Call<Starship> call, Throwable t)
            {
                callback.onDataNotAvailable();
            }
        });
    }
}
