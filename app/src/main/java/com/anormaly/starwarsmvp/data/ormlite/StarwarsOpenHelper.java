package com.anormaly.starwarsmvp.data.ormlite;

import android.content.Context;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;

/**
 * Created by ichigo on 12/07/17.
 */

public abstract class StarwarsOpenHelper extends OrmLiteSqliteOpenHelper
{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Starwars.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";


    public StarwarsOpenHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


}
