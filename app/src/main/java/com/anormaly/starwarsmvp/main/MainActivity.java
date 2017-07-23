package com.anormaly.starwarsmvp.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.anormaly.bb8progressview.BB8ProgressView2;
import com.anormaly.starwarsmvp.R;
import com.anormaly.starwarsmvp.data.dataobjects.DataObject;
import com.anormaly.starwarsmvp.data.categories.source.Category;
import com.anormaly.starwarsmvp.data.categories.source.CategoryRepository;
import com.anormaly.starwarsmvp.dataobject.DataObjectFragment;
import com.anormaly.starwarsmvp.detail.DetailFragment;
import com.anormaly.starwarsmvp.people.PeopleFragment;
import com.anormaly.starwarsmvp.root.RootFragment;
import com.anormaly.starwarsmvp.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by ichigo on 13/07/17.
 */

public class MainActivity extends AppCompatActivity implements MainContract.View, NavigationListener
{


    private static final int ROOT_FRAGMENT_ID = 1;

    @BindView(R.id.progressView)
    BB8ProgressView2 progressView;

    @BindView(R.id.contentFrame)
    FrameLayout contentFrame;

    @BindView(R.id.emptyTextView)
    TextView emptyTextView;

    private Fragment rootFragment;
    private MainContract.Presenter mPresenter;
    private CategoryRepository mCategoryRepo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
        ButterKnife.bind(this);
        mCategoryRepo = CategoryRepository.getInstance();
        new MainPresenter(this,mCategoryRepo);
        mPresenter.start();

    }

    @Override
    public void setPresenter(MainContract.Presenter presenter)
    {
        mPresenter = presenter;
    }

    @Override
    public void initializeShowRoot()
    {
        rootFragment = getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (rootFragment == null)
        {
            rootFragment = RootFragment.newInstance();
        }
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), rootFragment, R.id.contentFrame);
    }

    @Override
    public void onPeopleNavigate()
    {
        mPresenter.changeViewToPeople();
    }

    @Override
    public void navigateToPeople()
    {

        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out)
                .replace(R.id.contentFrame, PeopleFragment.newInstance())

                .addToBackStack(null)
                .commit();

    }

    @Override
    public void onDetailNavigate(DataObject dataobject)
    {
        mPresenter.changeViewToDetail(dataobject);

    }

    @Override
    public void onDataObjectNavigate(Category category)
    {
        mPresenter.changeViewToDataObject(category);
    }

    @Override
    public void navigateToView(Category category)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out)
                .replace(R.id.contentFrame, DataObjectFragment.newInstance(category))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void navigateToDetail(DataObject dataobject, Category category)
    {

        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out)
                .replace(R.id.contentFrame, DetailFragment.newInstance(dataobject,category))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void setEmptyDataView(String text)
    {
        if(text!=null)
        emptyTextView.setText(text);
        else
            emptyTextView.setText("Sorry! No data available.");

        emptyTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgress()
    {
        progressView.setVisibility(View.VISIBLE);
        contentFrame.setVisibility(View.GONE);
        progressView.start();
    }

    @Override
    public void hideProgress()
    {
        contentFrame.setVisibility(View.VISIBLE);
        progressView.setVisibility(View.GONE);
        progressView.end();
    }
}
