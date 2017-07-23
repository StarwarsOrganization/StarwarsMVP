package com.anormaly.starwarsmvp.root;

import android.support.annotation.NonNull;

import com.anormaly.starwarsmvp.data.categories.source.Category;
import com.anormaly.starwarsmvp.data.categories.source.CategoryDataSource;
import com.anormaly.starwarsmvp.data.categories.source.CategoryRepository;

import java.util.List;

/**
 * Created by ichigo on 12/07/17.
 */

public class RootPresenter implements RootContract.Presenter
{

    private static final String TAG = RootPresenter.class.getSimpleName();

    private final RootContract.View mView;
    private final CategoryRepository mCategoryRepository;

    public RootPresenter(@NonNull RootContract.View view, @NonNull CategoryRepository categoryRepository)
    {
        mView = view;
        mView.setPresenter(this);

        mCategoryRepository = categoryRepository;
    }

    @Override
    public void start()
    {
    }

    @Override
    public void initializeViews()
    {
        mView.bindButterknife();
    }

    @Override
    public void showList()
    {
        mView.initializeRootRecylerView();
    }


    @Override
    public void fillCategories()
    {
        mCategoryRepository.loadCategories(new CategoryDataSource.LoadCategoriesCallback()
        {
            @Override
            public void onCategoriesLoaded(List<Category> categories)
            {
                mView.setCategories(categories);
            }

            @Override
            public void onDataNotAvailable()
            {
                mView.setEmptyView();
            }
        });
    }

    @Override
    public void selectedCategory(Category category)
    {
        switch (category.getId())
        {
            case CategoryRepository.PEOPLE_TYPE:
                mView.navigateToDataObjectView(category);
                break;
            default:
                mView.navigateToDataObjectView(category);
                break;
        }
    }
}
