package com.anormaly.starwarsmvp.data.dataobjects.people.source;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by ichigo on 12/07/17.
 */

public interface PeopleDataSource
{
    interface LoadPeopleCallback {
        void onPeopleLoaded(List<People> peoples);
        void onDataNotAvailable();
    }
    interface SavePeopleCallback {
        void onSaved();
        void onDataNotSaved();
    }
    interface LoadPersonCallback {
        void onPersonLoaded(People people);
        void onDataNotAvailable();
    }

    void loadPeoples(@NonNull LoadPeopleCallback callback);

    void loadPeoples(int page,@NonNull LoadPeopleCallback callback);

    void savePeople(People people, SavePeopleCallback callback);

    void loadPerson(int id,@NonNull LoadPersonCallback callback);

}
