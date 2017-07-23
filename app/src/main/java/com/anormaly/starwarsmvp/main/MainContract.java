package com.anormaly.starwarsmvp.main;

import com.anormaly.starwarsmvp.BasePresenter;
import com.anormaly.starwarsmvp.BaseView;
import com.anormaly.starwarsmvp.data.dataobjects.DataObject;
import com.anormaly.starwarsmvp.data.categories.source.Category;

/**
 * Created by ichigo on 13/07/17.
 */

public class MainContract
{
    interface View extends BaseView<Presenter>{
        void initializeShowRoot();

        void navigateToPeople();

        void navigateToDetail(DataObject dataobject, Category category);

        void setEmptyDataView(String text);

        void navigateToView(Category category);

        void showProgress();

        void hideProgress();
    }

    interface Presenter extends BasePresenter{
        void changeViewToPeople();
        void changeViewToDetail(DataObject dataobject);

        void changeViewToDataObject(Category category);
    }
}
