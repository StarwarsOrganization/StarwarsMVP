package com.anormaly.starwarsmvp.data.dataobjects.vehicle.source;

import android.content.Context;
import android.support.annotation.NonNull;

import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.Vehicle;
import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.VehicleDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.local.VehicleLocalDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.remote.VehicleRemoteDataSource;

import java.util.List;

/**
 * Created by ichigo on 12/07/17.
 */

public class VehicleRepository implements VehicleDataSource
{

    private static VehicleRepository INSTANCE;
    private final VehicleDataSource mRemoteDS;
    private final VehicleDataSource mLocalDS;

    private VehicleRepository(@NonNull VehicleDataSource remoteDS, @NonNull VehicleDataSource localDS)
    {
        mRemoteDS = remoteDS;
        mLocalDS = localDS;
    }

    public static VehicleRepository getInstance(@NonNull Context context){
        if(INSTANCE == null) INSTANCE = new VehicleRepository(VehicleRemoteDataSource.getInstance(context), VehicleLocalDataSource.getInstance(context));
        return INSTANCE;
    }

    public static VehicleRepository getInstance(@NonNull VehicleDataSource remoteDS, @NonNull VehicleDataSource localDS){
        if(INSTANCE == null) INSTANCE = new VehicleRepository(remoteDS,localDS);
        return INSTANCE;
    }

    @Override
    public void loadVehicles(final LoadVehicleCallback callback)
    {
        mLocalDS.loadVehicles(new LoadVehicleCallback()
        {
            @Override
            public void onVehicleLoaded(List<Vehicle> vehicles)
            {
                if(vehicles!=null && vehicles.size()>0){
                    callback.onVehicleLoaded(vehicles);
                }else{
                    callRemote();
                }
            }

            @Override
            public void onDataNotAvailable()
            {
                callRemote();
            }

            public void callRemote(){
                mRemoteDS.loadVehicles(new LoadVehicleCallback()
                {
                    @Override
                    public void onVehicleLoaded(final List<Vehicle> vehicles)
                    {
                        if(vehicles!=null){
                            for(Vehicle p:vehicles){
                                saveVehicle(p, new SaveVehicleCallback()
                                {
                                    @Override
                                    public void onSaved()
                                    {
                                        callback.onVehicleLoaded(vehicles);
                                    }

                                    @Override
                                    public void onDataNotSaved()
                                    {
                                        callback.onVehicleLoaded(vehicles);
                                    }
                                });
                            }


                        }else{
                            callback.onDataNotAvailable();
                        }
                    }

                    @Override
                    public void onDataNotAvailable()
                    {
                        callback.onDataNotAvailable();
                    }
                });
            }
        });
    }

    @Override
    public void saveVehicle(Vehicle vehicle,@NonNull final SaveVehicleCallback callback)
    {

        mLocalDS.saveVehicle(vehicle, new SaveVehicleCallback()
        {
            @Override
            public void onSaved()
            {
                callback.onSaved();
            }

            @Override
            public void onDataNotSaved()
            {
                callback.onDataNotSaved();
            }
        });
    }
}
