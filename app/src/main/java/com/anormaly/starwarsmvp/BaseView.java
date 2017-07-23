package com.anormaly.starwarsmvp;

/**
 * Created by ichigo on 11/07/17.
 */

public interface BaseView<T>
{
    void setPresenter(T presenter);
}
