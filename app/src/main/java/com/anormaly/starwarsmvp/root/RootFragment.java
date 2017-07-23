package com.anormaly.starwarsmvp.root;

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
import com.anormaly.starwarsmvp.data.categories.source.CategoryRepository;
import com.anormaly.starwarsmvp.main.NavigationListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ichigo on 13/07/17.
 */

public class RootFragment extends Fragment implements RootContract.View
{
    private RootContract.Presenter mPresenter;
    private View mView;

    @BindView(R.id.rootRecyclerView)
    RecyclerView rootRecyclerView;

    private LinearLayoutManager mLayoutManager;
    private RootAdapter mAdapter;

    public RootFragment()
    {
        new RootPresenter(this, CategoryRepository.getInstance());
    }

    public static RootFragment newInstance(){
        return new RootFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.root_frag,container,false);
        this.mView = view;
        mPresenter.initializeViews();
        mPresenter.showList();
        return view;
    }

    @Override
    public void initializeRootRecylerView()
    {
        mLayoutManager = new LinearLayoutManager(getContext());

        mAdapter = new RootAdapter();
        rootRecyclerView.setAdapter(mAdapter);
        rootRecyclerView.setHasFixedSize(true);
        rootRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter.setListener(new RootAdapter.GetItemClick()
        {
            @Override
            public void onItemClick(View view)
            {
                mPresenter.selectedCategory((Category) view.getTag());
            }
        });
        mPresenter.fillCategories();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(RootContract.Presenter presenter)
    {
        mPresenter = presenter;
    }

    @Override
    public void bindButterknife()
    {
        ButterKnife.bind(this,mView);
    }

    @Override
    public void setCategories(List<Category> categoryList)
    {

        mAdapter.add(categoryList);
    }

    @Override
    public void setEmptyView()
    {
    }

    @Override
    public void navigateToPeopleView()
    {
        ((NavigationListener)getActivity()).onPeopleNavigate();
    }

    @Override
    public void navigateToDataObjectView(Category category)
    {
        ((NavigationListener)getActivity()).onDataObjectNavigate(category);
    }
}
