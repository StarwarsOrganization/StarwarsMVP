package com.anormaly.starwarsmvp.splash;

import com.anormaly.starwarsmvp.BasePresenter;
import com.anormaly.starwarsmvp.BaseView;

/**
 * Created by ichigo on 12/07/17.
 */

public class SplashContract
{
    interface View extends BaseView<Presenter> {

        void setAnimationListener();

        void navigateToMainView();

        void bindButterknife();
    }

    interface Presenter extends BasePresenter {

        void animationCompleteEvent();
    }
}
