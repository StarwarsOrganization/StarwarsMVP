package com.anormaly.starwarsmvp.data.dataobjects.species.source;

import android.content.Context;
import android.support.annotation.NonNull;

import com.anormaly.starwarsmvp.data.dataobjects.species.source.Species;
import com.anormaly.starwarsmvp.data.dataobjects.species.source.SpeciesDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.species.source.local.SpeciesLocalDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.species.source.remote.SpeciesRemoteDataSource;

import java.util.List;

/**
 * Created by ichigo on 12/07/17.
 */

public class SpeciesRepository implements SpeciesDataSource
{

    private static SpeciesRepository INSTANCE;
    private final SpeciesDataSource mRemoteDS;
    private final SpeciesDataSource mLocalDS;

    private SpeciesRepository(@NonNull SpeciesDataSource remoteDS, @NonNull SpeciesDataSource localDS)
    {
        mRemoteDS = remoteDS;
        mLocalDS = localDS;
    }

    public static SpeciesRepository getInstance(@NonNull Context context){
        if(INSTANCE == null) INSTANCE = new SpeciesRepository(SpeciesRemoteDataSource.getInstance(context), SpeciesLocalDataSource.getInstance(context));
        return INSTANCE;
    }

    public static SpeciesRepository getInstance(@NonNull SpeciesDataSource remoteDS, @NonNull SpeciesDataSource localDS){
        if(INSTANCE == null) INSTANCE = new SpeciesRepository(remoteDS,localDS);
        return INSTANCE;
    }

    @Override
    public void loadSpecies(final LoadSpeciesCallback callback)
    {
        mLocalDS.loadSpecies(new LoadSpeciesCallback()
        {
            @Override
            public void onSpeciesLoaded(List<Species> species)
            {
                if(species!=null && species.size()>0){
                    callback.onSpeciesLoaded(species);
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
                mRemoteDS.loadSpecies(new LoadSpeciesCallback()
                {
                    @Override
                    public void onSpeciesLoaded(final List<Species> species)
                    {
                        if(species!=null){
                            for(Species p:species){
                                saveSpecies(p, new SaveSpeciesCallback()
                                {
                                    @Override
                                    public void onSaved()
                                    {
                                        callback.onSpeciesLoaded(species);
                                    }

                                    @Override
                                    public void onDataNotSaved()
                                    {
                                        callback.onSpeciesLoaded(species);
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
    public void saveSpecies(Species species,@NonNull final SaveSpeciesCallback callback)
    {

        mLocalDS.saveSpecies(species, new SaveSpeciesCallback()
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
