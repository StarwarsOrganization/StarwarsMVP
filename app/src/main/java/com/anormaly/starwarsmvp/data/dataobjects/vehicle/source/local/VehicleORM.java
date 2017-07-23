
package com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.local;

import com.anormaly.starwarsmvp.data.dataobjects.people.source.local.CustomString;
import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.Vehicle;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.local.ORMUtils;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


/**
 * Starship
 * <p>
 * A vehicle.
 * 
 */
public class VehicleORM
{

    public VehicleORM()
    {
    }

    public VehicleORM(Vehicle vehicle)
    {
        this.maxAtmospheringSpeed = vehicle.getMaxAtmospheringSpeed();
        this.edited = vehicle.getEdited();
        this.consumables = vehicle.getConsumables();
        this.vehicleClass = vehicle.getVehicleClass();
        this.costInCredits = vehicle.getCostInCredits();
        this.model = vehicle.getModel();
        this.cargoCapacity = vehicle.getCargoCapacity();
        this.crew = vehicle.getCrew();
        this.created = vehicle.getCreated();
        this.length = vehicle.getLength();
        this.pilots = ORMUtils.getStrings(vehicle.getPilots());
        this.name = vehicle.getName();
        this.url = vehicle.getUrl();
        this.passengers = vehicle.getPassengers();
        this.films = ORMUtils.getStrings(vehicle.getFilms());
        this.manufacturer = vehicle.getManufacturer();
    }

    public Vehicle getVehicle(){
        return new Vehicle(
                getMaxAtmospheringSpeed(),
                getEdited(),
                getConsumables(),
                getVehicleClass(),
                getCostInCredits(),
                getModel(),
                getCargoCapacity(),
                getCrew(),
                getCreated(),
                getLength(),
                ORMUtils.getList(getPilots()),
                getName(),
                getUrl(),
                getPassengers(),
                ORMUtils.getList(getFilms()),
                getManufacturer()
        );
    }

    /**
     * The maximum speed of this vehicle in atmosphere.
     * (Required)
     * 
     */
    @DatabaseField
    private String maxAtmospheringSpeed;
    /**
     * the ISO 8601 date format of the time that this resource was edited.
     * (Required)
     * 
     */
    @DatabaseField(dataType = DataType.DATE_STRING, format = "YYYY-MM-DD'T'hh:mm:ss.SSSZ")
    private Date edited;
    /**
     * The maximum length of time that this vehicle can provide consumables for its entire crew without having to resupply.
     * (Required)
     * 
     */
    @DatabaseField
    private String consumables;
    /**
     * The class of this vehicle, such as Wheeled.
     * (Required)
     * 
     */
    @DatabaseField
    private String vehicleClass;
    /**
     * The cost of this vehicle new, in galactic credits.
     * (Required)
     * 
     */
    @DatabaseField
    private String costInCredits;
    /**
     * The model or official name of this vehicle. Such as All Terrain Attack Transport.
     * (Required)
     * 
     */
    @DatabaseField
    private String model;
    /**
     * The maximum number of kilograms that this vehicle can transport.
     * (Required)
     * 
     */
    @DatabaseField
    private String cargoCapacity;
    /**
     * The number of personnel needed to run or pilot this vehicle.
     * (Required)
     * 
     */
    @DatabaseField
    private String crew;
    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
     * 
     */
    @DatabaseField(dataType = DataType.DATE_STRING, format = "YYYY-MM-DD'T'hh:mm:ss.SSSZ")
    private Date created;
    /**
     * The length of this vehicle in meters.
     * (Required)
     * 
     */
    @DatabaseField
    private String length;
    /**
     * An array of DataObject URL Resources that this vehicle has been piloted by.
     * (Required)
     * 
     */
    @ForeignCollectionField
    private Collection<CustomString> pilots = null;
    /**
     * The name of this vehicle. The common name, such as Sand Crawler.
     * (Required)
     * 
     */
    @DatabaseField
    private String name;
    /**
     * The hypermedia URL of this resource.
     * (Required)
     * 
     */
    @DatabaseField(id = true)
    private String url;
    /**
     * The number of non-essential people this vehicle can transport.
     * (Required)
     * 
     */
    @DatabaseField
    private String passengers;
    /**
     * An array of Film URL Resources that this vehicle has appeared in.
     * (Required)
     * 
     */
    @ForeignCollectionField
    private Collection<CustomString> films = null;
    /**
     * The manufacturer of this vehicle. Comma seperated if more than one.
     * (Required)
     * 
     */
    @DatabaseField
    private String manufacturer;

    /**
     * The maximum speed of this vehicle in atmosphere.
     * (Required)
     * 
     */
    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    /**
     * The maximum speed of this vehicle in atmosphere.
     * (Required)
     * 
     */
    public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    /**
     * the ISO 8601 date format of the time that this resource was edited.
     * (Required)
     * 
     */
    public Date getEdited() {
        return edited;
    }

    /**
     * the ISO 8601 date format of the time that this resource was edited.
     * (Required)
     * 
     */
    public void setEdited(Date edited) {
        this.edited = edited;
    }

    /**
     * The maximum length of time that this vehicle can provide consumables for its entire crew without having to resupply.
     * (Required)
     * 
     */
    public String getConsumables() {
        return consumables;
    }

    /**
     * The maximum length of time that this vehicle can provide consumables for its entire crew without having to resupply.
     * (Required)
     * 
     */
    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    /**
     * The class of this vehicle, such as Wheeled.
     * (Required)
     * 
     */
    public String getVehicleClass() {
        return vehicleClass;
    }

    /**
     * The class of this vehicle, such as Wheeled.
     * (Required)
     * 
     */
    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    /**
     * The cost of this vehicle new, in galactic credits.
     * (Required)
     * 
     */
    public String getCostInCredits() {
        return costInCredits;
    }

    /**
     * The cost of this vehicle new, in galactic credits.
     * (Required)
     * 
     */
    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    /**
     * The model or official name of this vehicle. Such as All Terrain Attack Transport.
     * (Required)
     * 
     */
    public String getModel() {
        return model;
    }

    /**
     * The model or official name of this vehicle. Such as All Terrain Attack Transport.
     * (Required)
     * 
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * The maximum number of kilograms that this vehicle can transport.
     * (Required)
     * 
     */
    public String getCargoCapacity() {
        return cargoCapacity;
    }

    /**
     * The maximum number of kilograms that this vehicle can transport.
     * (Required)
     * 
     */
    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    /**
     * The number of personnel needed to run or pilot this vehicle.
     * (Required)
     * 
     */
    public String getCrew() {
        return crew;
    }

    /**
     * The number of personnel needed to run or pilot this vehicle.
     * (Required)
     * 
     */
    public void setCrew(String crew) {
        this.crew = crew;
    }

    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
     * 
     */
    public Date getCreated() {
        return created;
    }

    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
     * 
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * The length of this vehicle in meters.
     * (Required)
     * 
     */
    public String getLength() {
        return length;
    }

    /**
     * The length of this vehicle in meters.
     * (Required)
     * 
     */
    public void setLength(String length) {
        this.length = length;
    }

    /**
     * An array of DataObject URL Resources that this vehicle has been piloted by.
     * (Required)
     * 
     */
    public Collection<CustomString> getPilots() {
        return pilots;
    }

    /**
     * An array of DataObject URL Resources that this vehicle has been piloted by.
     * (Required)
     * 
     */
    public void setPilots(ArrayList<CustomString> pilots) {
        this.pilots = pilots;
    }

    /**
     * The name of this vehicle. The common name, such as Sand Crawler.
     * (Required)
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * The name of this vehicle. The common name, such as Sand Crawler.
     * (Required)
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The hypermedia URL of this resource.
     * (Required)
     * 
     */
    public String getUrl() {
        return url;
    }

    /**
     * The hypermedia URL of this resource.
     * (Required)
     * 
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * The number of non-essential people this vehicle can transport.
     * (Required)
     * 
     */
    public String getPassengers() {
        return passengers;
    }

    /**
     * The number of non-essential people this vehicle can transport.
     * (Required)
     * 
     */
    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    /**
     * An array of Film URL Resources that this vehicle has appeared in.
     * (Required)
     * 
     */
    public Collection<CustomString> getFilms() {
        return films;
    }

    /**
     * An array of Film URL Resources that this vehicle has appeared in.
     * (Required)
     * 
     */
    public void setFilms(ArrayList<CustomString> films) {
        this.films = films;
    }

    /**
     * The manufacturer of this vehicle. Comma seperated if more than one.
     * (Required)
     * 
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * The manufacturer of this vehicle. Comma seperated if more than one.
     * (Required)
     * 
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

}
