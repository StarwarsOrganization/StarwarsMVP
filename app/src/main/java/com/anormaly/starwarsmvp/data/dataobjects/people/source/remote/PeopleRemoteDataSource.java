package com.anormaly.starwarsmvp.data.dataobjects.people.source.remote;

import android.content.Context;
import android.support.annotation.NonNull;

import com.anormaly.starwarsmvp.data.dataobjects.DataObjectList;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.People;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.PeopleDataSource;
import com.anormaly.starwarsmvp.data.retrofit.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ichigo on 12/07/17.
 */

public class PeopleRemoteDataSource implements PeopleDataSource
{
    private static final String TAG = PeopleRemoteDataSource.class.getSimpleName();

    private static PeopleRemoteDataSource INSTANCE;
    private final Context mContext;

    private PeopleRemoteDataSource(Context context)
    {
        mContext = context;
    }

    public static PeopleRemoteDataSource getInstance(Context context)
    {
        if (INSTANCE == null) INSTANCE = new PeopleRemoteDataSource(context);
        return INSTANCE;
    }

    @Override
    public void loadPeoples(final PeopleDataSource.LoadPeopleCallback callback)
    {
        loadPeoples(1,callback);
    }

    @Override
    public void loadPeoples(int page,final @NonNull LoadPeopleCallback callback)
    {
        new RetrofitHelper(mContext).getService().getPeoples("",page).enqueue(new Callback<DataObjectList<com.anormaly.starwarsmvp.data.dataobjects.people.source.People>>()
        {
            @Override
            public void onResponse(Call<DataObjectList<com.anormaly.starwarsmvp.data.dataobjects.people.source.People>> call, Response<DataObjectList<com.anormaly.starwarsmvp.data.dataobjects.people.source.People>> response)
            {
                if(response.isSuccessful()){
                    callback.onPeopleLoaded(response.body().get());
                }else{
                    callback.onDataNotAvailable();
                }
            }

            @Override
            public void onFailure(Call<DataObjectList<com.anormaly.starwarsmvp.data.dataobjects.people.source.People>> call, Throwable t)
            {
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void savePeople(People people, SavePeopleCallback callback)
    {
        callback.onDataNotSaved();
    }

    @Override
    public void loadPerson(int id, @NonNull final LoadPersonCallback callback)
    {
        new RetrofitHelper(mContext).getService().getPeople(id).enqueue(new Callback<com.anormaly.starwarsmvp.data.dataobjects.people.source.People>()
        {
            @Override
            public void onResponse(Call<com.anormaly.starwarsmvp.data.dataobjects.people.source.People> call, Response<com.anormaly.starwarsmvp.data.dataobjects.people.source.People> response)
            {
                if(response.isSuccessful()){
                    callback.onPersonLoaded(response.body());
                }else{
                    callback.onDataNotAvailable();
                }
            }

            @Override
            public void onFailure(Call<com.anormaly.starwarsmvp.data.dataobjects.people.source.People> call, Throwable t)
            {
                callback.onDataNotAvailable();
            }
        });
    }
}
