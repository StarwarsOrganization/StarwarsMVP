package com.anormaly.starwarsmvp.data.dataobjects.film.source.remote;

import android.content.Context;

import com.anormaly.starwarsmvp.data.dataobjects.DataObjectList;
import com.anormaly.starwarsmvp.data.dataobjects.film.source.Film;
import com.anormaly.starwarsmvp.data.dataobjects.film.source.FilmDataSource;
import com.anormaly.starwarsmvp.data.retrofit.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ichigo on 12/07/17.
 */

public class FilmRemoteDataSource implements FilmDataSource
{
    private static final String TAG = FilmRemoteDataSource.class.getSimpleName();

    private static FilmRemoteDataSource INSTANCE;
    private final Context mContext;

    private FilmRemoteDataSource(Context context)
    {
        mContext = context;
    }

    public static FilmRemoteDataSource getInstance(Context context)
    {
        if (INSTANCE == null) INSTANCE = new FilmRemoteDataSource(context);
        return INSTANCE;
    }

    @Override
    public void loadFilms(final LoadFilmCallback callback)
    {
        new RetrofitHelper(mContext).getService().getFilms("").enqueue(new Callback<DataObjectList<Film>>()
        {
            @Override
            public void onResponse(Call<DataObjectList<Film>> call, Response<DataObjectList<Film>> response)
            {
                if(response.isSuccessful()){
                    callback.onFilmLoaded(response.body().get());
                }else{
                    callback.onDataNotAvailable();
                }
            }

            @Override
            public void onFailure(Call<DataObjectList<Film>> call, Throwable t)
            {
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void saveFilm(Film film,SaveFilmCallback callback)
    {
        callback.onDataNotSaved();
    }
}
