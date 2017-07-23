package com.anormaly.starwarsmvp.data.dataobjects.planet.source;

import android.support.annotation.NonNull;


import com.anormaly.starwarsmvp.data.dataobjects.people.source.People;

import java.util.List;

/**
 * Created by ichigo on 12/07/17.
 */

public interface PlanetDataSource
{
    interface LoadPlanetCallback {
        void onPlanetLoaded(List<Planet> planets);
        void onDataNotAvailable();
    }
    interface SavePlanetCallback {
        void onSaved();
        void onDataNotSaved();
    }
    void loadPlanets(@NonNull LoadPlanetCallback callback);

    void savePlanet(Planet planet, SavePlanetCallback callback);


}
