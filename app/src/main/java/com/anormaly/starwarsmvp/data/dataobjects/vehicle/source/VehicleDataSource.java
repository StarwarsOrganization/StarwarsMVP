package com.anormaly.starwarsmvp.data.dataobjects.vehicle.source;

import android.support.annotation.NonNull;

import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.Vehicle;

import java.util.List;

/**
 * Created by ichigo on 12/07/17.
 */

public interface VehicleDataSource
{
    interface LoadVehicleCallback {
        void onVehicleLoaded(List<Vehicle> vehicles);
        void onDataNotAvailable();
    }
    interface SaveVehicleCallback {
        void onSaved();
        void onDataNotSaved();
    }
    void loadVehicles(@NonNull LoadVehicleCallback callback);

    void saveVehicle(Vehicle vehicle, SaveVehicleCallback callback);


}
