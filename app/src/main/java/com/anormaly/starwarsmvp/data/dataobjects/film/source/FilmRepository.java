package com.anormaly.starwarsmvp.data.dataobjects.film.source;

import android.content.Context;
import android.support.annotation.NonNull;

import com.anormaly.starwarsmvp.data.dataobjects.film.source.Film;
import com.anormaly.starwarsmvp.data.dataobjects.film.source.FilmDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.film.source.local.FilmLocalDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.film.source.remote.FilmRemoteDataSource;

import java.util.List;

/**
 * Created by ichigo on 12/07/17.
 */

public class FilmRepository implements FilmDataSource
{

    private static FilmRepository INSTANCE;
    private final FilmDataSource mRemoteDS;
    private final FilmDataSource mLocalDS;

    private FilmRepository(@NonNull FilmDataSource remoteDS, @NonNull FilmDataSource localDS)
    {
        mRemoteDS = remoteDS;
        mLocalDS = localDS;
    }

    public static FilmRepository getInstance(@NonNull Context context){
        if(INSTANCE == null) INSTANCE = new FilmRepository(FilmRemoteDataSource.getInstance(context), FilmLocalDataSource.getInstance(context));
        return INSTANCE;
    }

    public static FilmRepository getInstance(@NonNull FilmDataSource remoteDS, @NonNull FilmDataSource localDS){
        if(INSTANCE == null) INSTANCE = new FilmRepository(remoteDS,localDS);
        return INSTANCE;
    }

    @Override
    public void loadFilms(final LoadFilmCallback callback)
    {
        mLocalDS.loadFilms(new LoadFilmCallback()
        {
            @Override
            public void onFilmLoaded(List<Film> films)
            {
                if(films!=null && films.size()>0){
                    callback.onFilmLoaded(films);
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
                mRemoteDS.loadFilms(new LoadFilmCallback()
                {
                    @Override
                    public void onFilmLoaded(final List<Film> films)
                    {
                        if(films!=null){
                            for(Film p:films){
                                saveFilm(p, new SaveFilmCallback()
                                {
                                    @Override
                                    public void onSaved()
                                    {
                                        callback.onFilmLoaded(films);
                                    }

                                    @Override
                                    public void onDataNotSaved()
                                    {
                                        callback.onFilmLoaded(films);
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
    public void saveFilm(Film film,@NonNull final SaveFilmCallback callback)
    {

        mLocalDS.saveFilm(film, new SaveFilmCallback()
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
