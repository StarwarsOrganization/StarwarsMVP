package com.anormaly.starwarsmvp.data.dataobjects.people.source;

import android.content.Context;
import android.support.annotation.NonNull;

import com.anormaly.starwarsmvp.data.dataobjects.people.source.local.PeopleLocalDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.remote.PeopleRemoteDataSource;

import java.util.List;

/**
 * Created by ichigo on 12/07/17.
 */

public class PeopleRepository implements PeopleDataSource
{

    private static PeopleRepository INSTANCE;
    private final PeopleDataSource mRemoteDS;
    private final PeopleDataSource mLocalDS;

    private PeopleRepository(@NonNull PeopleDataSource remoteDS, @NonNull PeopleDataSource localDS)
    {
        mRemoteDS = remoteDS;
        mLocalDS = localDS;
    }

    public static PeopleRepository getInstance(@NonNull Context context){
        if(INSTANCE == null) INSTANCE = new PeopleRepository(PeopleRemoteDataSource.getInstance(context), PeopleLocalDataSource.getInstance(context));
        return INSTANCE;
    }

    public static PeopleRepository getInstance(@NonNull PeopleDataSource remoteDS, @NonNull PeopleDataSource localDS){
        if(INSTANCE == null) INSTANCE = new PeopleRepository(remoteDS,localDS);
        return INSTANCE;
    }

    @Override
    public void loadPeoples(final LoadPeopleCallback callback)
    {
        mLocalDS.loadPeoples(new LoadPeopleCallback()
        {
            @Override
            public void onPeopleLoaded(List<People> peoples)
            {
                if(peoples!=null && peoples.size()>0){
                    callback.onPeopleLoaded(peoples);
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
                mRemoteDS.loadPeoples(new LoadPeopleCallback()
                {
                    @Override
                    public void onPeopleLoaded(final List<People> peoples)
                    {
                        if(peoples!=null){
                            for(People p:peoples){
                                savePeople(p, new SavePeopleCallback()
                                {
                                    @Override
                                    public void onSaved()
                                    {
                                        callback.onPeopleLoaded(peoples);
                                    }

                                    @Override
                                    public void onDataNotSaved()
                                    {
                                        callback.onPeopleLoaded(peoples);
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
    public void loadPeoples(final int page, @NonNull final LoadPeopleCallback callback)
    {
        mLocalDS.loadPeoples(page,new LoadPeopleCallback()
        {
            @Override
            public void onPeopleLoaded(List<People> peoples)
            {
                if(peoples!=null && peoples.size()>0){
                    callback.onPeopleLoaded(peoples);
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
                mRemoteDS.loadPeoples(page,new LoadPeopleCallback()
                {
                    @Override
                    public void onPeopleLoaded(final List<People> peoples)
                    {
                        if(peoples!=null){
                            for(People p:peoples){
                                savePeople(p, new SavePeopleCallback()
                                {
                                    @Override
                                    public void onSaved()
                                    {
                                        callback.onPeopleLoaded(peoples);
                                    }

                                    @Override
                                    public void onDataNotSaved()
                                    {
                                        callback.onPeopleLoaded(peoples);
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
    public void savePeople(People people, @NonNull final SavePeopleCallback callback)
    {

        mLocalDS.savePeople(people, new SavePeopleCallback()
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
    public void loadPerson(final int id, @NonNull final LoadPersonCallback callback)
    {
        mLocalDS.loadPerson(id, new LoadPersonCallback()
        {
            @Override
            public void onPersonLoaded(com.anormaly.starwarsmvp.data.dataobjects.people.source.People people)
            {
                if(people!=null)
                    callback.onPersonLoaded(people);
                else
                    callRemote();
            }

            private void callRemote()
            {
                mRemoteDS.loadPerson(id, new LoadPersonCallback()
                {
                    @Override
                    public void onPersonLoaded(com.anormaly.starwarsmvp.data.dataobjects.people.source.People people)
                    {
                        if(people!=null)
                            callback.onPersonLoaded(people);
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
