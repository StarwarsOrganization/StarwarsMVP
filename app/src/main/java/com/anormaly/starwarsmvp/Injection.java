package com.anormaly.starwarsmvp;

import android.content.Context;
import android.support.annotation.NonNull;

import com.anormaly.starwarsmvp.data.dataobjects.people.source.PeopleRepository;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.local.PeopleLocalDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.remote.PeopleRemoteDataSource;

/**
 * Created by ichigo on 12/07/17.
 */

public class Injection
{

    public static PeopleRepository providePeopleRepository(@NonNull Context context){
        return PeopleRepository.getInstance(PeopleRemoteDataSource.getInstance(context), PeopleLocalDataSource.getInstance(context));
    }
}
