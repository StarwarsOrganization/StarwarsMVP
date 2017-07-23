package com.anormaly.starwarsmvp.people;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anormaly.starwarsmvp.R;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.People;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.PeopleRepository;
import com.anormaly.starwarsmvp.main.NavigationListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ichigo on 13/07/17.
 */

public class PeopleFragment extends Fragment implements PeopleContract.View
{
    private static final String TAG = PeopleFragment.class.getSimpleName();
    private PeopleContract.Presenter mPresenter;
    private LinearLayoutManager mLayoutManager;

    @BindView(R.id.peopleRecyclerView)
    RecyclerView peopleRecyclerView;

    private View mView;
    private PeopleAdapter mAdapter;

    public PeopleFragment()
    {

        new PeoplePresenter(this, PeopleRepository.getInstance(getContext()));
    }

    public static PeopleFragment newInstance()
    {
        return new PeopleFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.people_list_frag, container, false);
        mView = view;
        mPresenter.initializeViews();
        return view;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(PeopleContract.Presenter presenter)
    {
        mPresenter = presenter;
    }

    @Override
    public void bindButterknife()
    {
        ButterKnife.bind(this, mView);
    }

    @Override
    public void initializePeopleRecylerView()
    {
        mLayoutManager = new LinearLayoutManager(getContext());

        mAdapter = new PeopleAdapter();
        peopleRecyclerView.setAdapter(mAdapter);
        peopleRecyclerView.setHasFixedSize(true);
        peopleRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter.setListener(new PeopleAdapter.GetItemClick()
        {
            @Override
            public void onItemClick(View view)
            {
                com.anormaly.starwarsmvp.data.dataobjects.people.source.People people = (com.anormaly.starwarsmvp.data.dataobjects.people.source.People) view.getTag();
                mPresenter.selectedPeople(people);

            }
        });
        mPresenter.loadPeopleList();
    }

    @Override
    public void setPeople(List<People> peoples)
    {
        mAdapter.add(peoples);
    }

    @Override
    public void setEmptyDataView()
    {

    }

    @Override
    public void navigateToDetail(com.anormaly.starwarsmvp.data.dataobjects.people.source.People people)
    {
        ((NavigationListener) getActivity()).onDetailNavigate(people);
    }
}
