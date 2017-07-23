package com.anormaly.starwarsmvp.data.dataobjects.species.source;

import android.support.annotation.NonNull;

import com.anormaly.starwarsmvp.data.dataobjects.species.source.Species;

import java.util.List;

/**
 * Created by ichigo on 12/07/17.
 */

public interface SpeciesDataSource
{
    interface LoadSpeciesCallback {
        void onSpeciesLoaded(List<Species> speciess);
        void onDataNotAvailable();
    }
    interface SaveSpeciesCallback {
        void onSaved();
        void onDataNotSaved();
    }
    void loadSpecies(@NonNull LoadSpeciesCallback callback);

    void saveSpecies(Species species, SaveSpeciesCallback callback);


}
