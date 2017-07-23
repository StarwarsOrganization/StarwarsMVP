package com.anormaly.starwarsmvp.data.dataobjects.starship.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.anormaly.starwarsmvp.data.dataobjects.people.source.local.CustomString;
import com.anormaly.starwarsmvp.data.ormlite.StarwarsOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by ichigo on 12/07/17.
 */

public class StarshipDBHelper extends StarwarsOpenHelper
{


    private Dao<StarshipORM,Integer> mStarshipDao;

    public StarshipDBHelper(Context context)
    {
        super(context);
    }

    public Dao<StarshipORM, Integer> getStarshipDao() throws SQLException
    {
        if (mStarshipDao == null) {
            mStarshipDao = getDao(StarshipORM.class);
        }

        return mStarshipDao;
    }

    /**
     * What to do when your database needs to be created. Usually this entails creating the tables and loading any
     * initial data.
     * <p>
     * <p>
     * <b>NOTE:</b> You should use the connectionSource argument that is passed into this method call or the one
     * returned by getConnectionSource(). If you use your own, a recursive call or other unexpected results may result.
     * </p>
     *
     * @param database         Database being created.
     * @param connectionSource
     */
    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource)
    {
        try{
            TableUtils.createTable(connectionSource,StarshipORM.class);
            TableUtils.createTable(connectionSource,CustomString.class);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * What to do when your database needs to be updated. This could mean careful migration of old data to new data.
     * Maybe adding or deleting database columns, etc..
     * <p>
     * <p>
     * <b>NOTE:</b> You should use the connectionSource argument that is passed into this method call or the one
     * returned by getConnectionSource(). If you use your own, a recursive call or other unexpected results may result.
     * </p>
     *
     * @param database         Database being upgraded.
     * @param connectionSource To use get connections to the database to be updated.
     * @param oldVersion       The version of the current database so we can know what to do to the database.
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion)
    {
    }

    @Override
    public void close()
    {
        mStarshipDao = null;
        super.close();
    }
}


