package com.anormaly.starwarsmvp.data.dataobjects.people.source.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.anormaly.starwarsmvp.data.dataobjects.people.source.People;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.PeopleDataSource;
import com.anormaly.starwarsmvp.data.retrofit.RetrofitHelper;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ichigo on 12/07/17.
 */

public class PeopleLocalDataSource implements PeopleDataSource
{

    private static PeopleLocalDataSource INSTANCE;
    private PeopleDBHelper mDbHelper;


    private PeopleLocalDataSource(@NonNull Context context)
    {
        mDbHelper = new PeopleDBHelper(context);
    }

    public static PeopleLocalDataSource getInstance(Context context)
    {
        if (INSTANCE == null) INSTANCE = new PeopleLocalDataSource(context);
        return INSTANCE;
    }

    @Override
    public void loadPeoples(LoadPeopleCallback callback)
    {
        loadPeoples(1,callback);

    }

    @Override
    public void loadPeoples(int page, @NonNull LoadPeopleCallback callback)
    {
        try
        {
            int size =10;
            QueryBuilder<PeopleORM, Integer> builder = mDbHelper.getPeopleDao().queryBuilder();
            builder.offset((long) ((page-1)*size)).limit(10L);
            List<PeopleORM> peopleOrm = mDbHelper.getPeopleDao().query(builder.prepare());
            List<People> result = new ArrayList<>();
            for (int i = 0; i < peopleOrm.size(); i++)
            {
                result.add(peopleOrm.get(i).getPeople());
            }
            callback.onPeopleLoaded(result);
        } catch (SQLException e)
        {
            callback.onDataNotAvailable();
        }
    }

    public void savePeople(People people, SavePeopleCallback callback)
    {

        try
        {
            PeopleORM peopleORm = mDbHelper.getPeopleDao().createIfNotExists(new PeopleORM(people));
            if (peopleORm != null) callback.onSaved();
            else callback.onDataNotSaved();
        } catch (SQLException e)
        {
            callback.onDataNotSaved();
        }
    }

    @Override
    public void loadPerson(int id, @NonNull LoadPersonCallback callback)
    {
        try{
            List<PeopleORM> peopleORM = mDbHelper.getPeopleDao().queryForEq("url", RetrofitHelper.BASE_URL+"people/"+id+"/");
            if(peopleORM!=null && !peopleORM.isEmpty()) callback.onPersonLoaded(peopleORM.get(0).getPeople());
        } catch (SQLException e)
        {
            callback.onDataNotAvailable();
        }
    }
}
