package com.anormaly.starwarsmvp.data.dataobjects.film.source.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.anormaly.starwarsmvp.data.dataobjects.film.source.Film;
import com.anormaly.starwarsmvp.data.dataobjects.film.source.FilmDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.film.source.local.FilmDBHelper;
import com.anormaly.starwarsmvp.data.dataobjects.film.source.local.FilmORM;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ichigo on 12/07/17.
 */

public class FilmLocalDataSource implements FilmDataSource
{

    private static FilmLocalDataSource INSTANCE;
    private FilmDBHelper mDbHelper;


    private FilmLocalDataSource(@NonNull Context context)
    {
        mDbHelper = new FilmDBHelper(context);
    }

    public static FilmLocalDataSource getInstance(Context context)
    {
        if (INSTANCE == null) INSTANCE = new FilmLocalDataSource(context);
        return INSTANCE;
    }

    @Override
    public void loadFilms(LoadFilmCallback callback)
    {

        try
        {
            List<FilmORM> filmOrm = mDbHelper.getFilmDao().queryForAll();
            List<Film> result = new ArrayList<>();
            for (int i = 0; i < filmOrm.size(); i++)
            {
                result.add(filmOrm.get(i).getFilm());
            }
            callback.onFilmLoaded(result);
        } catch (SQLException e)
        {
            callback.onDataNotAvailable();
        }


    }

    public void saveFilm(Film film, SaveFilmCallback callback)
    {

        try
        {
            FilmORM filmORm = mDbHelper.getFilmDao().createIfNotExists(new FilmORM(film));
            if (filmORm != null) callback.onSaved();
            else callback.onDataNotSaved();
        } catch (SQLException e)
        {
            callback.onDataNotSaved();
        }
    }
}
