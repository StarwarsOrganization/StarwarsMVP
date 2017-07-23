package com.anormaly.starwarsmvp.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.anormaly.starwarsmvp.R;
import com.anormaly.starwarsmvp.data.categories.source.Category;
import com.anormaly.starwarsmvp.data.dataobjects.DataObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ichigo on 22/07/17.
 */

public class DetailFragment extends Fragment implements DetailContract.View
{
    private static final String DATAOBJECT_TAG = "dataobject";
    private static final String CATEGORY_TAG = "category";
    private DetailContract.Presenter mPresenter;
    private View mView;

    @BindView(R.id.detailExpandableListView)
    ExpandableListView detailExapandableListView;
    private DataObject mDataObject;
    private Category mCategory;
    private DetailAdapter mAdapter;

    public DetailFragment()
    {
        new DetailPresenter(this);
    }

    public static DetailFragment newInstance(DataObject dataobject, Category category)
    {
        DetailFragment fragment = new DetailFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(DATAOBJECT_TAG,dataobject);
        bundle.putSerializable(CATEGORY_TAG,category);

        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.detail_frag,container,false);
        mView = view;
        mPresenter.initializeViews();
        return view;
    }

    @Override
    public void setPresenter(DetailContract.Presenter presenter)
    {
        mPresenter = presenter;
    }

    @Override
    public void bindViews()
    {
        ButterKnife.bind(this,mView);
    }

    @Override
    public void loadData()
    {
        mDataObject = (DataObject) getArguments().getSerializable(DATAOBJECT_TAG);
        mCategory = (Category) getArguments().getSerializable(CATEGORY_TAG);
        mPresenter.convertData(mDataObject,mCategory);
    }

    @Override
    public void initAdapter(List<DataRow> rows)
    {
        mAdapter = new DetailAdapter(getContext(),DataUtils.getParent(rows),DataUtils.getChild(rows));
        detailExapandableListView.setAdapter(mAdapter);
        for(int i =0;i<rows.size();i++)
        {
            detailExapandableListView.expandGroup(i);
        }
        detailExapandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
        {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l)
            {
                return true;
            }
        });
    }
}
