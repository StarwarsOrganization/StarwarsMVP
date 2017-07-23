package com.anormaly.starwarsmvp.dataobject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anormaly.starwarsmvp.R;
import com.anormaly.starwarsmvp.data.categories.source.Category;
import com.anormaly.starwarsmvp.data.dataobjects.DataObject;
import com.anormaly.starwarsmvp.data.dataobjects.film.source.FilmRepository;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.People;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.PeopleRepository;
import com.anormaly.starwarsmvp.data.dataobjects.planet.source.PlanetRepository;
import com.anormaly.starwarsmvp.data.dataobjects.species.source.SpeciesRepository;
import com.anormaly.starwarsmvp.data.dataobjects.starship.source.StarshipRepository;
import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.VehicleRepository;
import com.anormaly.starwarsmvp.main.MainActivity;
import com.anormaly.starwarsmvp.main.NavigationListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ichigo on 13/07/17.
 */

public class DataObjectFragment extends Fragment implements DataObjectContract.View
{
    private static final String TAG = DataObjectFragment.class.getSimpleName();
    private static final String CATEGORY_TAG = "category";
    private DataObjectContract.Presenter mPresenter;
    private LinearLayoutManager mLayoutManager;

    @BindView(R.id.peopleRecyclerView)
    RecyclerView dataObjectRecyclerView;

    private View mView;
    private DataObjectAdapter mAdapter;
    private Category category;

    public DataObjectFragment()
    {

    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        new DataObjectPresenter(this, PeopleRepository.getInstance(getContext()), PlanetRepository.getInstance(getContext()), SpeciesRepository.getInstance(getContext()), StarshipRepository.getInstance(getContext()), VehicleRepository.getInstance(getContext()), FilmRepository.getInstance(getContext()) );
    }

    public static DataObjectFragment newInstance(Category category)
    {
        DataObjectFragment fragment = new DataObjectFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(CATEGORY_TAG,category);

        fragment.setArguments(bundle);
        return fragment;
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
    public void setPresenter(DataObjectContract.Presenter presenter)
    {
        mPresenter = presenter;
    }

    @Override
    public void bindButterknife()
    {
        ButterKnife.bind(this, mView);
    }

    @Override
    public void initializeRecylerView()
    {
        ((MainActivity)getActivity()).showProgress();
        mLayoutManager = new LinearLayoutManager(getContext());

        category = (Category) getArguments().getSerializable(CATEGORY_TAG);
        mAdapter = new DataObjectAdapter(category);
        dataObjectRecyclerView.setAdapter(mAdapter);
        dataObjectRecyclerView.setLayoutManager(mLayoutManager);
        

        
        mAdapter.setListener(new DataObjectAdapter.GetItemClick()
        {
            @Override
            public void onItemClick(View view)
            {
                DataObject people = (DataObject) view.getTag();
                mPresenter.selectedDataObject(people);

            }
        });
        mPresenter.loadDataObjectList(category);
    }

    @Override
    public void setDataObjects(List<? extends DataObject> dataObjects)
    {
        mAdapter.add(dataObjects);
        ((MainActivity)getActivity()).hideProgress();
    }

    @Override
    public void setEmptyDataView()
    {

    }

    @Override
    public void navigateToDetail(DataObject dataObject)
    {
        ((NavigationListener) getActivity()).onDetailNavigate(dataObject);
    }
}
