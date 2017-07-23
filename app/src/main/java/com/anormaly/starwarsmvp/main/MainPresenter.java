package com.anormaly.starwarsmvp.main;

import com.anormaly.starwarsmvp.data.dataobjects.DataObject;
import com.anormaly.starwarsmvp.data.categories.source.Category;
import com.anormaly.starwarsmvp.data.categories.source.CategoryDataSource;
import com.anormaly.starwarsmvp.data.categories.source.CategoryRepository;

/**
 * Created by ichigo on 13/07/17.
 */

public class MainPresenter implements MainContract.Presenter
{
    private final MainContract.View mView;
    private final CategoryRepository mCategoryRepository;

    public MainPresenter(MainContract.View view, CategoryRepository categoryRepository)
    {
        mView = view;
        mCategoryRepository = categoryRepository;
        mView.setPresenter(this);
    }

    @Override
    public void start()
    {
        mView.initializeShowRoot();

    }

    @Override
    public void changeViewToPeople()
    {
        mView.navigateToPeople();
    }

    @Override
    public void changeViewToDetail(final DataObject dataobject)
    {
        mCategoryRepository.obtainCategoryType(dataobject, new CategoryDataSource.CategoryTypeCallback()
        {
            @Override
            public void onCategoryType(Category category)
            {
                mView.navigateToDetail(dataobject,category);
            }

            @Override
            public void onCategoryNotFound()
            {
                mView.setEmptyDataView(null);
            }
        });

    }

    @Override
    public void changeViewToDataObject(Category category)
    {
        mView.navigateToView(category);
    }
}
