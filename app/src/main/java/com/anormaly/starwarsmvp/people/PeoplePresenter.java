package com.anormaly.starwarsmvp.people;

import com.anormaly.starwarsmvp.data.dataobjects.people.source.People;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.PeopleDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.PeopleRepository;

import java.util.List;

/**
 * Created by ichigo on 13/07/17.
 */

public class PeoplePresenter implements PeopleContract.Presenter
{
    private final PeopleContract.View mView;
    private final PeopleRepository mPeopleRepository;

    public PeoplePresenter(PeopleContract.View view, PeopleRepository peopleRepository)
    {
        mView = view;
        mPeopleRepository = peopleRepository;

        mView.setPresenter(this);
    }


    @Override
    public void start()
    {

    }

    @Override
    public void initializeViews()
    {
        mView.bindButterknife();
        mView.initializePeopleRecylerView();
    }

    @Override
    public void showList()
    {

    }

    @Override
    public void loadPeopleList()
    {
        mPeopleRepository.loadPeoples(new PeopleDataSource.LoadPeopleCallback()
        {
            @Override
            public void onPeopleLoaded(List<People> peoples)
            {
                mView.setPeople(peoples);
            }

            @Override
            public void onDataNotAvailable()
            {
                mView.setEmptyDataView();
            }
        });
    }

    @Override
    public void selectedPeople(com.anormaly.starwarsmvp.data.dataobjects.people.source.People people)
    {
        mView.navigateToDetail(people);
    }
}
