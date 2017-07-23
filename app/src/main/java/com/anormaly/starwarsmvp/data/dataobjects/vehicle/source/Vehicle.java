
package com.anormaly.starwarsmvp.data.dataobjects.vehicle.source;

import java.util.ArrayList;
import java.util.Date;

import com.anormaly.starwarsmvp.data.dataobjects.DataObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Starship
 * <p>
 * A vehicle.
 * 
 */
public class Vehicle implements DataObject
{

    public Vehicle()
    {
    }

    public Vehicle(String maxAtmospheringSpeed, Date edited, String consumables, String vehicleClass, String costInCredits, String model, String cargoCapacity, String crew, Date created, String length, ArrayList<String> pilots, String name, String url, String passengers, ArrayList<String> films, String manufacturer)
    {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
        this.edited = edited;
        this.consumables = consumables;
        this.vehicleClass = vehicleClass;
        this.costInCredits = costInCredits;
        this.model = model;
        this.cargoCapacity = cargoCapacity;
        this.crew = crew;
        this.created = created;
        this.length = length;
        this.pilots = pilots;
        this.name = name;
        this.url = url;
        this.passengers = passengers;
        this.films = films;
        this.manufacturer = manufacturer;
    }

    /**
     * The maximum speed of this vehicle in atmosphere.
     * (Required)
     * 
     */
    @SerializedName("max_atmosphering_speed")
    @Expose
    private String maxAtmospheringSpeed;
    /**
     * the ISO 8601 date format of the time that this resource was edited.
     * (Required)
     * 
     */
    @SerializedName("edited")
    @Expose
    private Date edited;
    /**
     * The maximum length of time that this vehicle can provide consumables for its entire crew without having to resupply.
     * (Required)
     * 
     */
    @SerializedName("consumables")
    @Expose
    private String consumables;
    /**
     * The class of this vehicle, such as Wheeled.
     * (Required)
     * 
     */
    @SerializedName("vehicle_class")
    @Expose
    private String vehicleClass;
    /**
     * The cost of this vehicle new, in galactic credits.
     * (Required)
     * 
     */
    @SerializedName("cost_in_credits")
    @Expose
    private String costInCredits;
    /**
     * The model or official name of this vehicle. Such as All Terrain Attack Transport.
     * (Required)
     * 
     */
    @SerializedName("model")
    @Expose
    private String model;
    /**
     * The maximum number of kilograms that this vehicle can transport.
     * (Required)
     * 
     */
    @SerializedName("cargo_capacity")
    @Expose
    private String cargoCapacity;
    /**
     * The number of personnel needed to run or pilot this vehicle.
     * (Required)
     * 
     */
    @SerializedName("crew")
    @Expose
    private String crew;
    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
     * 
     */
    @SerializedName("created")
    @Expose
    private Date created;
    /**
     * The length of this vehicle in meters.
     * (Required)
     * 
     */
    @SerializedName("length")
    @Expose
    private String length;
    /**
     * An array of DataObject URL Resources that this vehicle has been piloted by.
     * (Required)
     * 
     */
    @SerializedName("pilots")
    @Expose
    private ArrayList<String> pilots = null;
    /**
     * The name of this vehicle. The common name, such as Sand Crawler.
     * (Required)
     * 
     */
    @SerializedName("name")
    @Expose
    private String name;
    /**
     * The hypermedia URL of this resource.
     * (Required)
     * 
     */
    @SerializedName("url")
    @Expose
    private String url;
    /**
     * The number of non-essential people this vehicle can transport.
     * (Required)
     * 
     */
    @SerializedName("passengers")
    @Expose
    private String passengers;
    /**
     * An array of Film URL Resources that this vehicle has appeared in.
     * (Required)
     * 
     */
    @SerializedName("films")
    @Expose
    private ArrayList<String> films = null;
    /**
     * The manufacturer of this vehicle. Comma seperated if more than one.
     * (Required)
     * 
     */
    @SerializedName("manufacturer")
    @Expose
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
    public ArrayList<String> getPilots() {
        return pilots;
    }

    /**
     * An array of DataObject URL Resources that this vehicle has been piloted by.
     * (Required)
     * 
     */
    public void setPilots(ArrayList<String> pilots) {
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
    public ArrayList<String> getFilms() {
        return films;
    }

    /**
     * An array of Film URL Resources that this vehicle has appeared in.
     * (Required)
     * 
     */
    public void setFilms(ArrayList<String> films) {
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
