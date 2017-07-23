package com.anormaly.starwarsmvp.people;

import com.anormaly.starwarsmvp.BasePresenter;
import com.anormaly.starwarsmvp.BaseView;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.People;

import java.util.List;

/**
 * Created by ichigo on 13/07/17.
 */

public class PeopleContract
{

    interface View extends BaseView<PeopleContract.Presenter>{

        void bindButterknife();

        void initializePeopleRecylerView();

        void setPeople(List<People> peoples);

        void setEmptyDataView();

        void navigateToDetail(com.anormaly.starwarsmvp.data.dataobjects.people.source.People people);
    }

    interface Presenter extends BasePresenter {
        void initializeViews();

        void showList();

        void loadPeopleList();

        void selectedPeople(com.anormaly.starwarsmvp.data.dataobjects.people.source.People people);
    }
}
