package com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.Vehicle;
import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.VehicleDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.local.VehicleDBHelper;
import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.local.VehicleORM;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ichigo on 12/07/17.
 */

public class VehicleLocalDataSource implements VehicleDataSource
{

    private static VehicleLocalDataSource INSTANCE;
    private VehicleDBHelper mDbHelper;


    private VehicleLocalDataSource(@NonNull Context context)
    {
        mDbHelper = new VehicleDBHelper(context);
    }

    public static VehicleLocalDataSource getInstance(Context context)
    {
        if (INSTANCE == null) INSTANCE = new VehicleLocalDataSource(context);
        return INSTANCE;
    }

    @Override
    public void loadVehicles(LoadVehicleCallback callback)
    {

        try
        {
            List<VehicleORM> vehicleOrm = mDbHelper.getVehicleDao().queryForAll();
            List<Vehicle> result = new ArrayList<>();
            for (int i = 0; i < vehicleOrm.size(); i++)
            {
                result.add(vehicleOrm.get(i).getVehicle());
            }
            callback.onVehicleLoaded(result);
        } catch (SQLException e)
        {
            callback.onDataNotAvailable();
        }


    }

    public void saveVehicle(Vehicle vehicle, SaveVehicleCallback callback)
    {

        try
        {
            VehicleORM vehicleORm = mDbHelper.getVehicleDao().createIfNotExists(new VehicleORM(vehicle));
            if (vehicleORm != null) callback.onSaved();
            else callback.onDataNotSaved();
        } catch (SQLException e)
        {
            callback.onDataNotSaved();
        }
    }
}
