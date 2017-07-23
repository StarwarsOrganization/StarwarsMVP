
package com.anormaly.starwarsmvp.data.dataobjects.planet.source;

import java.util.ArrayList;
import java.util.Date;

import com.anormaly.starwarsmvp.data.dataobjects.DataObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Planet
 * <p>
 * A planet.
 * 
 */
public class Planet implements DataObject
{

    public Planet(ArrayList<String> residents, String rotationPeriod, String diameter, String terrain, String orbitalPeriod, Date created, String surfaceWater, String gravity, String name, String url, String climate, Date edited, ArrayList<String> films, String population)
    {
        this.residents = residents;
        this.rotationPeriod = rotationPeriod;
        this.diameter = diameter;
        this.terrain = terrain;
        this.orbitalPeriod = orbitalPeriod;
        this.created = created;
        this.surfaceWater = surfaceWater;
        this.gravity = gravity;
        this.name = name;
        this.url = url;
        this.climate = climate;
        this.edited = edited;
        this.films = films;
        this.population = population;
    }


    /**
     * An array of DataObject URL Resources that live on this planet.
     * (Required)
     * 
     */
    @SerializedName("residents")
    @Expose
    private ArrayList<String> residents = null;
    /**
     * The number of standard hours it takes for this planet to complete a single rotation on its axis.
     * (Required)
     * 
     */
    @SerializedName("rotation_period")
    @Expose
    private String rotationPeriod;
    /**
     * The diameter of this planet in kilometers.
     * (Required)
     * 
     */
    @SerializedName("diameter")
    @Expose
    private String diameter;
    /**
     * the terrain of this planet. Comma-seperated if diverse.
     * (Required)
     * 
     */
    @SerializedName("terrain")
    @Expose
    private String terrain;
    /**
     * The number of standard days it takes for this planet to complete a single orbit of its local star.
     * (Required)
     * 
     */
    @SerializedName("orbital_period")
    @Expose
    private String orbitalPeriod;
    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
     * 
     */
    @SerializedName("created")
    @Expose
    private Date created;
    /**
     * The percentage of the planet surface that is naturally occuring water or bodies of water.
     * (Required)
     * 
     */
    @SerializedName("surface_water")
    @Expose
    private String surfaceWater;
    /**
     * A number denoting the gravity of this planet. Where 1 is normal.
     * (Required)
     * 
     */
    @SerializedName("gravity")
    @Expose
    private String gravity;
    /**
     * The name of this planet.
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
     * The climate of this planet. Comma-seperated if diverse.
     * (Required)
     * 
     */
    @SerializedName("climate")
    @Expose
    private String climate;
    /**
     * the ISO 8601 date format of the time that this resource was edited.
     * (Required)
     * 
     */
    @SerializedName("edited")
    @Expose
    private Date edited;
    /**
     * An array of Film URL Resources that this planet has appeared in.
     * (Required)
     * 
     */
    @SerializedName("films")
    @Expose
    private ArrayList<String> films = null;
    /**
     * The average populationof sentient beings inhabiting this planet.
     * (Required)
     * 
     */
    @SerializedName("population")
    @Expose
    private String population;

    /**
     * An array of DataObject URL Resources that live on this planet.
     * (Required)
     * 
     */
    public ArrayList<String> getResidents() {
        return residents;
    }

    /**
     * An array of DataObject URL Resources that live on this planet.
     * (Required)
     * 
     */
    public void setResidents(ArrayList<String> residents) {
        this.residents = residents;
    }

    /**
     * The number of standard hours it takes for this planet to complete a single rotation on its axis.
     * (Required)
     * 
     */
    public String getRotationPeriod() {
        return rotationPeriod;
    }

    /**
     * The number of standard hours it takes for this planet to complete a single rotation on its axis.
     * (Required)
     * 
     */
    public void setRotationPeriod(String rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    /**
     * The diameter of this planet in kilometers.
     * (Required)
     * 
     */
    public String getDiameter() {
        return diameter;
    }

    /**
     * The diameter of this planet in kilometers.
     * (Required)
     * 
     */
    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    /**
     * the terrain of this planet. Comma-seperated if diverse.
     * (Required)
     * 
     */
    public String getTerrain() {
        return terrain;
    }

    /**
     * the terrain of this planet. Comma-seperated if diverse.
     * (Required)
     * 
     */
    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    /**
     * The number of standard days it takes for this planet to complete a single orbit of its local star.
     * (Required)
     * 
     */
    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    /**
     * The number of standard days it takes for this planet to complete a single orbit of its local star.
     * (Required)
     * 
     */
    public void setOrbitalPeriod(String orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
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
     * The percentage of the planet surface that is naturally occuring water or bodies of water.
     * (Required)
     * 
     */
    public String getSurfaceWater() {
        return surfaceWater;
    }

    /**
     * The percentage of the planet surface that is naturally occuring water or bodies of water.
     * (Required)
     * 
     */
    public void setSurfaceWater(String surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    /**
     * A number denoting the gravity of this planet. Where 1 is normal.
     * (Required)
     * 
     */
    public String getGravity() {
        return gravity;
    }

    /**
     * A number denoting the gravity of this planet. Where 1 is normal.
     * (Required)
     * 
     */
    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    /**
     * The name of this planet.
     * (Required)
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * The name of this planet.
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
     * The climate of this planet. Comma-seperated if diverse.
     * (Required)
     * 
     */
    public String getClimate() {
        return climate;
    }

    /**
     * The climate of this planet. Comma-seperated if diverse.
     * (Required)
     * 
     */
    public void setClimate(String climate) {
        this.climate = climate;
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
     * An array of Film URL Resources that this planet has appeared in.
     * (Required)
     * 
     */
    public ArrayList<String> getFilms() {
        return films;
    }

    /**
     * An array of Film URL Resources that this planet has appeared in.
     * (Required)
     * 
     */
    public void setFilms(ArrayList<String> films) {
        this.films = films;
    }

    /**
     * The average populationof sentient beings inhabiting this planet.
     * (Required)
     * 
     */
    public String getPopulation() {
        return population;
    }

    /**
     * The average populationof sentient beings inhabiting this planet.
     * (Required)
     * 
     */
    public void setPopulation(String population) {
        this.population = population;
    }

}
