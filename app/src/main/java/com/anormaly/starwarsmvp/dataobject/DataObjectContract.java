package com.anormaly.starwarsmvp.dataobject;

import com.anormaly.starwarsmvp.BasePresenter;
import com.anormaly.starwarsmvp.BaseView;
import com.anormaly.starwarsmvp.data.categories.source.Category;
import com.anormaly.starwarsmvp.data.dataobjects.DataObject;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.People;

import java.util.List;

/**
 * Created by ichigo on 13/07/17.
 */

public class DataObjectContract
{

    interface View extends BaseView<DataObjectContract.Presenter>{

        void bindButterknife();

        void initializeRecylerView();

        void setDataObjects(List<? extends DataObject> dataObjects);

        void setEmptyDataView();

        void navigateToDetail(DataObject dataObject);
    }

    interface Presenter extends BasePresenter {
        void initializeViews();

        void showList();

        void loadDataObjectList(Category category);

        void selectedDataObject(DataObject dataObject);


    }
}
