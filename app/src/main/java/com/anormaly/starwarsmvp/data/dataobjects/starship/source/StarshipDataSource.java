package com.anormaly.starwarsmvp.data.dataobjects.starship.source;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by ichigo on 12/07/17.
 */

public interface StarshipDataSource
{
    interface LoadStarshipsCallback
    {
        void onStarshipLoaded(List<Starship> starships);
        void onDataNotAvailable();
    }

    interface SaveStarshipCallback {
        void onSaved();
        void onDataNotSaved();
    }
    void loadStarships(@NonNull LoadStarshipsCallback callback);

    void saveStarship(Starship starship, SaveStarshipCallback callback);

    interface LoadStarshipCallback
    {
        void onStarshipLoaded(Starship starship);
        void onDataNotAvailable();
    }
    void loadStarship(int id,@NonNull LoadStarshipCallback callback);

}
