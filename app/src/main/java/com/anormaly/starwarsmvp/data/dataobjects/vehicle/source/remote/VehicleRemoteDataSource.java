package com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.remote;

import android.content.Context;

import com.anormaly.starwarsmvp.data.dataobjects.DataObjectList;
import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.Vehicle;
import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.VehicleDataSource;
import com.anormaly.starwarsmvp.data.retrofit.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ichigo on 12/07/17.
 */

public class VehicleRemoteDataSource implements VehicleDataSource
{
    private static final String TAG = VehicleRemoteDataSource.class.getSimpleName();

    private static VehicleRemoteDataSource INSTANCE;
    private final Context mContext;

    private VehicleRemoteDataSource(Context context)
    {
        mContext = context;
    }

    public static VehicleRemoteDataSource getInstance(Context context)
    {
        if (INSTANCE == null) INSTANCE = new VehicleRemoteDataSource(context);
        return INSTANCE;
    }

    @Override
    public void loadVehicles(final LoadVehicleCallback callback)
    {
        new RetrofitHelper(mContext).getService().getVehicles("").enqueue(new Callback<DataObjectList<Vehicle>>()
        {
            @Override
            public void onResponse(Call<DataObjectList<Vehicle>> call, Response<DataObjectList<Vehicle>> response)
            {
                if(response.isSuccessful()){
                    callback.onVehicleLoaded(response.body().get());
                }else{
                    callback.onDataNotAvailable();
                }
            }

            @Override
            public void onFailure(Call<DataObjectList<Vehicle>> call, Throwable t)
            {
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void saveVehicle(Vehicle vehicle,SaveVehicleCallback callback)
    {
        callback.onDataNotSaved();
    }
}
