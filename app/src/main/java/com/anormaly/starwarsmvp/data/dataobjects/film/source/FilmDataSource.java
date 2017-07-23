package com.anormaly.starwarsmvp.data.dataobjects.film.source;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by ichigo on 12/07/17.
 */

public interface FilmDataSource
{
    interface LoadFilmCallback {
        void onFilmLoaded(List<Film> films);
        void onDataNotAvailable();
    }
    interface SaveFilmCallback {
        void onSaved();
        void onDataNotSaved();
    }
    void loadFilms(@NonNull LoadFilmCallback callback);

    void saveFilm(Film film, SaveFilmCallback callback);


}
