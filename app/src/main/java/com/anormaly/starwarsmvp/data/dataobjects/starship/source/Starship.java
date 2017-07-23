
package com.anormaly.starwarsmvp.data.dataobjects.starship.source;

import java.util.ArrayList;
import java.util.Date;

import com.anormaly.starwarsmvp.data.dataobjects.DataObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Starship
 * <p>
 * A Starship
 * 
 */
public class Starship implements DataObject
{

    public Starship()
    {
    }

    public Starship(String maxAtmospheringSpeed, Date edited, String starshipClass, String costInCredits, String model, String cargoCapacity, String crew, Date created, String length, String mGLT, String hyperdriveRating, String consumables, ArrayList<String> pilots, String name, String url, String passengers, ArrayList<String> films, String manufacturer)
    {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
        this.edited = edited;
        this.starshipClass = starshipClass;
        this.costInCredits = costInCredits;
        this.model = model;
        this.cargoCapacity = cargoCapacity;
        this.crew = crew;
        this.created = created;
        this.length = length;
        this.mGLT = mGLT;
        this.hyperdriveRating = hyperdriveRating;
        this.consumables = consumables;
        this.pilots = pilots;
        this.name = name;
        this.url = url;
        this.passengers = passengers;
        this.films = films;
        this.manufacturer = manufacturer;
    }


    /**
     * The maximum speed of this starship in atmosphere. n/a if this starship is incapable of atmosphering flight.
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
     * The class of this starship, such as Starfighter or Deep Space Mobile Battlestation.
     * (Required)
     * 
     */
    @SerializedName("starship_class")
    @Expose
    private String starshipClass;
    /**
     * The cost of this starship new, in galactic credits.
     * (Required)
     * 
     */
    @SerializedName("cost_in_credits")
    @Expose
    private String costInCredits;
    /**
     * The model or official name of this starship. Such as T-65 X-wing or DS-1 Orbital Battle Station.
     * (Required)
     * 
     */
    @SerializedName("model")
    @Expose
    private String model;
    /**
     * The maximum number of kilograms that this starship can transport.
     * (Required)
     * 
     */
    @SerializedName("cargo_capacity")
    @Expose
    private String cargoCapacity;
    /**
     * The number of personnel needed to run or pilot this starship.
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
     * The length of this starship in meters.
     * (Required)
     * 
     */
    @SerializedName("length")
    @Expose
    private String length;
    /**
     * The Maximum number of Megalights this starship can travel in a standard hour. A Megalight is a standard unit of distance and has never been defined before within the Star Wars universe. This figure is only really useful for measuring the difference in speed of starships. We can assume it is similar to AU, the distance between our Sun (Sol) and Earth.
     * (Required)
     * 
     */
    @SerializedName("MGLT")
    @Expose
    private String mGLT;
    /**
     * The class of this starships hyperdrive.
     * (Required)
     * 
     */
    @SerializedName("hyperdrive_rating")
    @Expose
    private String hyperdriveRating;
    /**
     * The maximum length of time that this starship can provide consumables for its entire crew without having to resupply.
     * (Required)
     * 
     */
    @SerializedName("consumables")
    @Expose
    private String consumables;
    /**
     * An array of PeopleORM URL Resources that this starship has been piloted by.
     * (Required)
     * 
     */
    @SerializedName("pilots")
    @Expose
    private ArrayList<String> pilots = null;
    /**
     * The name of this starship. The common name, such as Death Star.
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
     * The number of non-essential people this starship can transport.
     * (Required)
     * 
     */
    @SerializedName("passengers")
    @Expose
    private String passengers;
    /**
     * An array of Film URL Resources that this starship has appeared in.
     * (Required)
     * 
     */
    @SerializedName("films")
    @Expose
    private ArrayList<String> films = null;
    /**
     * The manufacturer of this starship. Comma seperated if more than one.
     * (Required)
     * 
     */
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;

    /**
     * The maximum speed of this starship in atmosphere. n/a if this starship is incapable of atmosphering flight.
     * (Required)
     * 
     */
    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    /**
     * The maximum speed of this starship in atmosphere. n/a if this starship is incapable of atmosphering flight.
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
     * The class of this starship, such as Starfighter or Deep Space Mobile Battlestation.
     * (Required)
     * 
     */
    public String getStarshipClass() {
        return starshipClass;
    }

    /**
     * The class of this starship, such as Starfighter or Deep Space Mobile Battlestation.
     * (Required)
     * 
     */
    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    /**
     * The cost of this starship new, in galactic credits.
     * (Required)
     * 
     */
    public String getCostInCredits() {
        return costInCredits;
    }

    /**
     * The cost of this starship new, in galactic credits.
     * (Required)
     * 
     */
    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    /**
     * The model or official name of this starship. Such as T-65 X-wing or DS-1 Orbital Battle Station.
     * (Required)
     * 
     */
    public String getModel() {
        return model;
    }

    /**
     * The model or official name of this starship. Such as T-65 X-wing or DS-1 Orbital Battle Station.
     * (Required)
     * 
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * The maximum number of kilograms that this starship can transport.
     * (Required)
     * 
     */
    public String getCargoCapacity() {
        return cargoCapacity;
    }

    /**
     * The maximum number of kilograms that this starship can transport.
     * (Required)
     * 
     */
    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    /**
     * The number of personnel needed to run or pilot this starship.
     * (Required)
     * 
     */
    public String getCrew() {
        return crew;
    }

    /**
     * The number of personnel needed to run or pilot this starship.
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
     * The length of this starship in meters.
     * (Required)
     * 
     */
    public String getLength() {
        return length;
    }

    /**
     * The length of this starship in meters.
     * (Required)
     * 
     */
    public void setLength(String length) {
        this.length = length;
    }

    /**
     * The Maximum number of Megalights this starship can travel in a standard hour. A Megalight is a standard unit of distance and has never been defined before within the Star Wars universe. This figure is only really useful for measuring the difference in speed of starships. We can assume it is similar to AU, the distance between our Sun (Sol) and Earth.
     * (Required)
     * 
     */
    public String getMGLT() {
        return mGLT;
    }

    /**
     * The Maximum number of Megalights this starship can travel in a standard hour. A Megalight is a standard unit of distance and has never been defined before within the Star Wars universe. This figure is only really useful for measuring the difference in speed of starships. We can assume it is similar to AU, the distance between our Sun (Sol) and Earth.
     * (Required)
     * 
     */
    public void setMGLT(String mGLT) {
        this.mGLT = mGLT;
    }

    /**
     * The class of this starships hyperdrive.
     * (Required)
     * 
     */
    public String getHyperdriveRating() {
        return hyperdriveRating;
    }

    /**
     * The class of this starships hyperdrive.
     * (Required)
     * 
     */
    public void setHyperdriveRating(String hyperdriveRating) {
        this.hyperdriveRating = hyperdriveRating;
    }

    /**
     * The maximum length of time that this starship can provide consumables for its entire crew without having to resupply.
     * (Required)
     * 
     */
    public String getConsumables() {
        return consumables;
    }

    /**
     * The maximum length of time that this starship can provide consumables for its entire crew without having to resupply.
     * (Required)
     * 
     */
    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    /**
     * An array of PeopleORM URL Resources that this starship has been piloted by.
     * (Required)
     * 
     */
    public ArrayList<String> getPilots() {
        return pilots;
    }

    /**
     * An array of PeopleORM URL Resources that this starship has been piloted by.
     * (Required)
     * 
     */
    public void setPilots(ArrayList<String> pilots) {
        this.pilots = pilots;
    }

    /**
     * The name of this starship. The common name, such as Death Star.
     * (Required)
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * The name of this starship. The common name, such as Death Star.
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
     * The number of non-essential people this starship can transport.
     * (Required)
     * 
     */
    public String getPassengers() {
        return passengers;
    }

    /**
     * The number of non-essential people this starship can transport.
     * (Required)
     * 
     */
    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    /**
     * An array of Film URL Resources that this starship has appeared in.
     * (Required)
     * 
     */
    public ArrayList<String> getFilms() {
        return films;
    }

    /**
     * An array of Film URL Resources that this starship has appeared in.
     * (Required)
     * 
     */
    public void setFilms(ArrayList<String> films) {
        this.films = films;
    }

    /**
     * The manufacturer of this starship. Comma seperated if more than one.
     * (Required)
     * 
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * The manufacturer of this starship. Comma seperated if more than one.
     * (Required)
     * 
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

}
