package com.anormaly.starwarsmvp.data.categories.source;

import android.support.annotation.NonNull;

import com.anormaly.starwarsmvp.data.dataobjects.DataObject;
import com.anormaly.starwarsmvp.data.categories.source.staticds.CategoryStaticDataSource;

import java.util.List;

/**
 * Created by ichigo on 13/07/17.
 */

public class CategoryRepository implements CategoryDataSource
{
    private static CategoryRepository INSTANCE;
    private final CategoryDataSource mStaticDS;

    private CategoryRepository(@NonNull CategoryDataSource staticDS)
    {
        mStaticDS = staticDS;
    }

    public static CategoryRepository getInstance(){
        if(INSTANCE == null) INSTANCE = new CategoryRepository(CategoryStaticDataSource.getInstance());
        return INSTANCE;
    }
    @Override
    public void loadCategories(final LoadCategoriesCallback callback)
    {
        mStaticDS.loadCategories(new LoadCategoriesCallback()
        {
            @Override
            public void onCategoriesLoaded(List<Category> categories)
            {
                callback.onCategoriesLoaded(categories);
            }

            @Override
            public void onDataNotAvailable()
            {
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void obtainCategoryType(DataObject dataobject, final CategoryTypeCallback callback)
    {
        mStaticDS.obtainCategoryType(dataobject,new CategoryTypeCallback()
        {
            @Override
            public void onCategoryType(Category category)
            {
                callback.onCategoryType(category);
            }

            @Override
            public void onCategoryNotFound()
            {
                callback.onCategoryNotFound();
            }
        });
    }
}
