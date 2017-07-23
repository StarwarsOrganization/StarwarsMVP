package com.anormaly.starwarsmvp.data.retrofit;

import android.content.Context;
import android.net.ConnectivityManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ichigo on 12/07/17.
 */

public class RetrofitHelper
{
    private final StarwarsRetrofitAPI service;
    private Retrofit retrofit;
    public static String BASE_URL = "https://swapi.co/api/";

    public RetrofitHelper(Context context)
    {
        if (retrofit == null)
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(provideClient(context))
                    .build();

            service = retrofit.create(StarwarsRetrofitAPI.class);

    }

    private OkHttpClient provideClient(Context context)
    {
        return new OkHttpClient.Builder()
                .addInterceptor(new ConnectivityInterceptor((ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE)))
                .addInterceptor(new LoggingInterceptor())
                .build();
    }

    public StarwarsRetrofitAPI getService()
    {
        return service;
    }

    public Retrofit getRetrofit()
    {
        return retrofit;
    }
}
