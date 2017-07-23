package com.anormaly.starwarsmvp.splash;

import com.anormaly.starwarsmvp.data.dataobjects.people.source.PeopleRepository;

/**
 * Created by ichigo on 12/07/17.
 */

public class SplashPresenter implements SplashContract.Presenter
{
    private static final String TAG = SplashPresenter.class.getSimpleName();

    private final SplashContract.View mView;
    private final PeopleRepository mRepo;

    public SplashPresenter(SplashContract.View view, PeopleRepository repo)
    {
        mView = view;

        mRepo = repo;

        mView.setPresenter(this);

    }

    @Override
    public void animationCompleteEvent()
    {
        mView.navigateToMainView();
    }

    @Override
    public void start()
    {
        mView.bindButterknife();
        mView.setAnimationListener();
    }
}
