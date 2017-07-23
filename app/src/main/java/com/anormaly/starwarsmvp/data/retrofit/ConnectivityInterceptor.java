package com.anormaly.starwarsmvp.data.retrofit;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ichigo on 12/07/17.
 */

public class ConnectivityInterceptor implements Interceptor {

    final ConnectivityManager connectivityManager;

    private static final String TAG = ConnectivityInterceptor.class.getSimpleName();
    public ConnectivityInterceptor(ConnectivityManager connectivityManager) {
        this.connectivityManager = connectivityManager;
    }

    @Override
    public Response intercept(Chain chain) throws IOException
    {
        if (!isConnected()) {
            throw new NoConnectivityException("no internet");
        }

        Request.Builder r = chain.request().newBuilder();

        return chain.proceed(r.build());
    }

    protected boolean isConnected() {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

}