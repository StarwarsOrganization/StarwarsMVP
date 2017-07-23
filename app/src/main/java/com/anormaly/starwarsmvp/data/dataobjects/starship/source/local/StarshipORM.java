
package com.anormaly.starwarsmvp.data.dataobjects.starship.source.local;

import com.anormaly.starwarsmvp.data.dataobjects.people.source.local.CustomString;
import com.anormaly.starwarsmvp.data.dataobjects.starship.source.Starship;
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
 * A Starship
 * 
 */
public class StarshipORM
{

    public StarshipORM()
    {
    }

    public StarshipORM(Starship starship)
    {
        this.maxAtmospheringSpeed = starship.getMaxAtmospheringSpeed();
        this.edited = starship.getEdited();
        this.starshipClass = starship.getStarshipClass();
        this.costInCredits = starship.getCostInCredits();
        this.model = starship.getModel();
        this.cargoCapacity = starship.getCargoCapacity();
        this.crew = starship.getCrew();
        this.created = starship.getCreated();
        this.length = starship.getLength();
        this.mGLT = starship.getMGLT();
        this.hyperdriveRating = starship.getHyperdriveRating();
        this.consumables = starship.getConsumables();
        this.pilots = ORMUtils.getStrings(starship.getPilots());
        this.name = starship.getName();
        this.url = starship.getUrl();
        this.passengers = starship.getPassengers();
        this.films = ORMUtils.getStrings(starship.getFilms());
        this.manufacturer = starship.getManufacturer();
    }

    public Starship getStarship(){
        return new Starship(
                getMaxAtmospheringSpeed(),
                getEdited(),
                getStarshipClass(),
                getCostInCredits(),
                getModel(),
                getCargoCapacity(),
                getCrew(),
                getCreated(),
                getLength(),
                getMGLT(),
                getHyperdriveRating(),
                getConsumables(),
                ORMUtils.getList(getPilots()),
                getName(),
                getUrl(),
                getPassengers(),
                ORMUtils.getList(getFilms()),
                getManufacturer()
        );
    }

    /**
     * The maximum speed of this starship in atmosphere. n/a if this starship is incapable of atmosphering flight.
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
     * The class of this starship, such as Starfighter or Deep Space Mobile Battlestation.
     * (Required)
     */
    @DatabaseField
    private String starshipClass;
    /**
     * The cost of this starship new, in galactic credits.
     * (Required)
     */
    @DatabaseField
    private String costInCredits;

    /**
     * The model or official name of this starship. Such as T-65 X-wing or DS-1 Orbital Battle Station.
     * (Required)
     */
    @DatabaseField
    private String model;

    /**
     * The maximum number of kilograms that this starship can transport.
     * (Required)
     */
    @DatabaseField
    private String cargoCapacity;

    /**
     * The number of personnel needed to run or pilot this starship.
     * (Required)
     */
    @DatabaseField
    private String crew;

    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
     */
    @DatabaseField(dataType = DataType.DATE_STRING, format = "YYYY-MM-DD'T'hh:mm:ss.SSSZ")
    private Date created;

    /**
     * The length of this starship in meters.
     * (Required)
     */
    @DatabaseField
    private String length;

    /**
     * The Maximum number of Megalights this starship can travel in a standard hour. A Megalight is a standard unit of distance and has never been defined before within the Star Wars universe. This figure is only really useful for measuring the difference in speed of starships. We can assume it is similar to AU, the distance between our Sun (Sol) and Earth.
     * (Required)
     */
    @DatabaseField
    private String mGLT;

    /**
     * The class of this starships hyperdrive.
     * (Required)
     */
    @DatabaseField
    private String hyperdriveRating;

    /**
     * The maximum length of time that this starship can provide consumables for its entire crew without having to resupply.
     * (Required)
     */
    @DatabaseField
    private String consumables;

    /**
     * An array of PeopleORM URL Resources that this starship has been piloted by.
     * (Required)
     */
    @ForeignCollectionField
    private Collection<CustomString> pilots = new ArrayList<>();

    /**
     * The name of this starship. The common name, such as Death Star.
     * (Required)
     */
    @DatabaseField
    private String name;

    /**
     * The hypermedia URL of this resource.
     * (Required)
     */
    @DatabaseField( id = true )
    private String url;

    /**
     * The number of non-essential people this starship can transport.
     * (Required)
     */
    @DatabaseField
    private String passengers;

    /**
     * An array of Film URL Resources that this starship has appeared in.
     * (Required)
     */
    @ForeignCollectionField
    private Collection<CustomString> films = new ArrayList<>();

    /**
     * The manufacturer of this starship. Comma seperated if more than one.
     * (Required)
     */
    @DatabaseField
    private String manufacturer;

    /**
     * The maximum speed of this starship in atmosphere. n/a if this starship is incapable of atmosphering flight.
     * (Required)
     */
    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    /**
     * The maximum speed of this starship in atmosphere. n/a if this starship is incapable of atmosphering flight.
     * (Required)
     */
    public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    /**
     * the ISO 8601 date format of the time that this resource was edited.
     * (Required)
     */
    public Date getEdited() {
        return edited;
    }

    /**
     * the ISO 8601 date format of the time that this resource was edited.
     * (Required)
     */
    public void setEdited(Date edited) {
        this.edited = edited;
    }

    /**
     * The class of this starship, such as Starfighter or Deep Space Mobile Battlestation.
     * (Required)
     */
    public String getStarshipClass() {
        return starshipClass;
    }

    /**
     * The class of this starship, such as Starfighter or Deep Space Mobile Battlestation.
     * (Required)
     */
    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    /**
     * The cost of this starship new, in galactic credits.
     * (Required)
     */
    public String getCostInCredits() {
        return costInCredits;
    }

    /**
     * The cost of this starship new, in galactic credits.
     * (Required)
     */
    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    /**
     * The model or official name of this starship. Such as T-65 X-wing or DS-1 Orbital Battle Station.
     * (Required)
     */
    public String getModel() {
        return model;
    }

    /**
     * The model or official name of this starship. Such as T-65 X-wing or DS-1 Orbital Battle Station.
     * (Required)
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * The maximum number of kilograms that this starship can transport.
     * (Required)
     */
    public String getCargoCapacity() {
        return cargoCapacity;
    }

    /**
     * The maximum number of kilograms that this starship can transport.
     * (Required)
     */
    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    /**
     * The number of personnel needed to run or pilot this starship.
     * (Required)
     */
    public String getCrew() {
        return crew;
    }

    /**
     * The number of personnel needed to run or pilot this starship.
     * (Required)
     */
    public void setCrew(String crew) {
        this.crew = crew;
    }

    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
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
    public Collection<CustomString> getPilots() {
        return pilots;
    }

    /**
     * An array of PeopleORM URL Resources that this starship has been piloted by.
     * (Required)
     * 
     */
    public void setPilots(ArrayList<CustomString> pilots) {
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
    public Collection<CustomString> getFilms() {
        return films;
    }

    /**
     * An array of Film URL Resources that this starship has appeared in.
     * (Required)
     * 
     */
    public void setFilms(Collection<CustomString> films) {
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
