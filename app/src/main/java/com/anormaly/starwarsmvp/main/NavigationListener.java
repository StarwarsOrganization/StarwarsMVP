package com.anormaly.starwarsmvp.main;

import com.anormaly.starwarsmvp.data.categories.source.Category;
import com.anormaly.starwarsmvp.data.dataobjects.DataObject;

/**
 * Created by ichigo on 14/07/17.
 */

public interface NavigationListener
{
    void onPeopleNavigate();
    void onDetailNavigate(DataObject dataobject);

    void onDataObjectNavigate(Category category);
}
