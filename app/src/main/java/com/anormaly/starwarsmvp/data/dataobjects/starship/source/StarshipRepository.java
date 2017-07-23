package com.anormaly.starwarsmvp.data.dataobjects.starship.source;

import android.content.Context;
import android.support.annotation.NonNull;

import com.anormaly.starwarsmvp.data.dataobjects.starship.source.local.StarshipLocalDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.starship.source.remote.StarshipRemoteDataSource;

import java.util.List;

/**
 * Created by ichigo on 12/07/17.
 */

public class StarshipRepository implements StarshipDataSource
{

    private static StarshipRepository INSTANCE;
    private final StarshipDataSource mRemoteDS;
    private final StarshipDataSource mLocalDS;

    private StarshipRepository(@NonNull StarshipDataSource remoteDS, @NonNull StarshipDataSource localDS)
    {
        mRemoteDS = remoteDS;
        mLocalDS = localDS;
    }

    public static StarshipRepository getInstance(@NonNull Context context){
        if(INSTANCE == null) INSTANCE = new StarshipRepository(StarshipRemoteDataSource.getInstance(context), StarshipLocalDataSource.getInstance(context));
        return INSTANCE;
    }

    public static StarshipRepository getInstance(@NonNull StarshipDataSource remoteDS, @NonNull StarshipDataSource localDS){
        if(INSTANCE == null) INSTANCE = new StarshipRepository(remoteDS,localDS);
        return INSTANCE;
    }

    @Override
    public void loadStarships(final LoadStarshipsCallback callback)
    {
        mLocalDS.loadStarships(new LoadStarshipsCallback()
        {
            @Override
            public void onStarshipLoaded(List<Starship> starships)
            {
                if(starships!=null && starships.size()>0){
                    callback.onStarshipLoaded(starships);
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
                mRemoteDS.loadStarships(new LoadStarshipsCallback()
                {
                    @Override
                    public void onStarshipLoaded(final List<Starship> starships)
                    {
                        if(starships!=null){
                            for(Starship p:starships){
                                saveStarship(p, new SaveStarshipCallback()
                                {
                                    @Override
                                    public void onSaved()
                                    {
                                        callback.onStarshipLoaded(starships);
                                    }

                                    @Override
                                    public void onDataNotSaved()
                                    {
                                        callback.onStarshipLoaded(starships);
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
    public void saveStarship(Starship starship,@NonNull final SaveStarshipCallback callback)
    {

        mLocalDS.saveStarship(starship, new SaveStarshipCallback()
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

    @Override
    public void loadStarship(final int id, @NonNull final LoadStarshipCallback callback)
    {
        mLocalDS.loadStarship(id, new LoadStarshipCallback()
        {
            @Override
            public void onStarshipLoaded(Starship starship)
            {
                if(starship!=null)
                    callback.onStarshipLoaded(starship);
                else
                    callRemote();
            }

            private void callRemote()
            {
                mRemoteDS.loadStarship(id, new LoadStarshipCallback()
                {
                    @Override
                    public void onStarshipLoaded(Starship starship)
                    {
                        if(starship!=null)
                            callback.onStarshipLoaded(starship);
                        else
                            callback.onDataNotAvailable();
                    }

                    @Override
                    public void onDataNotAvailable()
                    {
                        callback.onDataNotAvailable();
                    }
                });
            }

            @Override
            public void onDataNotAvailable()
            {
                callRemote();
            }
        });
    }
}
