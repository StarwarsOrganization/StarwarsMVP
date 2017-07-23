package com.anormaly.starwarsmvp.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anormaly.starwarsmvp.Injection;
import com.anormaly.starwarsmvp.R;
import com.anormaly.starwarsmvp.main.MainActivity;
import com.anormaly.views.lightsaberview.AnimationStateListener;
import com.anormaly.views.lightsaberview.LightSaberView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity implements SplashContract.View
{

    @BindView(R.id.lightSaberView)
    LightSaberView lightSaberView;

    private SplashContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_act);
        mPresenter = new SplashPresenter(this, Injection.providePeopleRepository(this));
        mPresenter.start();
    }

    @Override
    public void setPresenter(SplashContract.Presenter presenter)
    {
        this.mPresenter = presenter;
    }

    public void navigateToMainView(){
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void bindButterknife()
    {
        ButterKnife.bind(this);
    }


    @Override
    public void setAnimationListener()
    {
        lightSaberView.onAnimationStateListener(new AnimationStateListener()
        {
            @Override
            public void onAnimationEnd()
            {
                mPresenter.animationCompleteEvent();
            }
        });
    }
}
