package com.anormaly.starwarsmvp.detail;

import com.anormaly.starwarsmvp.BasePresenter;
import com.anormaly.starwarsmvp.BaseView;
import com.anormaly.starwarsmvp.data.categories.source.Category;
import com.anormaly.starwarsmvp.data.dataobjects.DataObject;

import java.util.List;

/**
 * Created by ichigo on 22/07/17.
 */

public class DetailContract
{
    interface View extends BaseView<Presenter>
    {
        void bindViews();

        void loadData();

        void initAdapter(List<DataRow> rows);
    }

    interface Presenter extends BasePresenter
    {

        void initializeViews();

        void initData();

        void convertData(DataObject mDataObject, Category mCategory);
    }
}
