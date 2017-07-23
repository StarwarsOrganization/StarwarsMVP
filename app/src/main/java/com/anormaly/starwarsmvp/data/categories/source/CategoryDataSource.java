package com.anormaly.starwarsmvp.data.categories.source;

import com.anormaly.starwarsmvp.data.dataobjects.DataObject;

import java.util.List;

/**
 * Created by ichigo on 13/07/17.
 */

public interface CategoryDataSource
{
    int PEOPLE_TYPE = 0;
    int FILMS_TYPE = 1;
    int PLANETS_TYPE = 2;
    int SPECIES_TYPE = 3;
    int STARSHIPS_TYPE = 4;
    int VEHICLES_TYPE = 5;

    interface LoadCategoriesCallback {
        void onCategoriesLoaded(List<Category> categories);
        void onDataNotAvailable();
    }
    void loadCategories(LoadCategoriesCallback callback);

    interface CategoryTypeCallback {
        void onCategoryType(Category category);
        void onCategoryNotFound();
    }
    void obtainCategoryType(DataObject dataobject, CategoryTypeCallback callback);
}
