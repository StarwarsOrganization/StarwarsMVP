package com.anormaly.starwarsmvp.root;

import com.anormaly.starwarsmvp.BasePresenter;
import com.anormaly.starwarsmvp.BaseView;
import com.anormaly.starwarsmvp.data.categories.source.Category;

import java.util.List;


/**
 * Created by ichigo on 12/07/17.
 */

public class RootContract
{
    interface View extends BaseView<Presenter>{

        void bindButterknife();

        void initializeRootRecylerView();

        void setCategories(List<Category> categoryList);

        void setEmptyView();

        void navigateToPeopleView();

        void navigateToDataObjectView(Category category);
    }

    interface Presenter extends BasePresenter {
        void initializeViews();

        void showList();

        void fillCategories();

        void selectedCategory(Category category);
    }
}
