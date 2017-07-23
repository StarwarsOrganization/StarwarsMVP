
package com.anormaly.starwarsmvp.data.dataobjects.planet.source.local;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


import com.anormaly.starwarsmvp.data.dataobjects.planet.source.Planet;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;


/**
 * Planet
 * <p>
 * A planet.
 *
 */
@DatabaseTable(tableName = "planet")
public class PlanetORM
{

    public PlanetORM(){}

    public PlanetORM(Planet planet)
    {
        this.residents = ORMUtils.getStrings(planet.getResidents());
        this.rotationPeriod = planet.getRotationPeriod();
        this.diameter = planet.getDiameter();
        this.terrain = planet.getTerrain();
        this.orbitalPeriod = planet.getOrbitalPeriod();
        this.created = planet.getCreated();
        this.surfaceWater = planet.getSurfaceWater();
        this.gravity = planet.getGravity();
        this.name = planet.getName();
        this.url = planet.getUrl();
        this.climate = planet.getClimate();
        this.edited = planet.getEdited();
        this.films = ORMUtils.getStrings(planet.getFilms());
        this.population = planet.getPopulation();
    }

    public Planet getPlanet(){
        return new Planet(
                ORMUtils.getList(getResidents()),
                getRotationPeriod(),
                getDiameter(),
                getTerrain(),
                getOrbitalPeriod(),
                getCreated(),
                getSurfaceWater(),
                getGravity(),
                getName(),
                getUrl(),
                getClimate(),
                getEdited(),
                ORMUtils.getList(getFilms()),
                getPopulation()
        );
    }

    /**
     * An array of DataObject URL Resources that live on this planet.
     * (Required)
     *
     */
    @ForeignCollectionField
    private Collection<CustomString> residents = new ArrayList<>();
    /**
     * The number of standard hours it takes for this planet to complete a single rotation on its axis.
     * (Required)
     *
     */
    @DatabaseField
    private String rotationPeriod;
    /**
     * The diameter of this planet in kilometers.
     * (Required)
     *
     */
    @DatabaseField
    private String diameter;
    /**
     * the terrain of this planet. Comma-seperated if diverse.
     * (Required)
     *
     */
    @DatabaseField
    private String terrain;
    /**
     * The number of standard days it takes for this planet to complete a single orbit of its local star.
     * (Required)
     *
     */
    @DatabaseField
    private String orbitalPeriod;
    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
     *
     */
    @DatabaseField(dataType = DataType.DATE_STRING, format = "YYYY-MM-DD'T'hh:mm:ss.SSSZ")
    private Date created;
    /**
     * The percentage of the planet surface that is naturally occuring water or bodies of water.
     * (Required)
     *
     */
    @DatabaseField
    private String surfaceWater;
    /**
     * A number denoting the gravity of this planet. Where 1 is normal.
     * (Required)
     *
     */
    @DatabaseField
    private String gravity;
    /**
     * The name of this planet.
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
     * The climate of this planet. Comma-seperated if diverse.
     * (Required)
     *
     */
    @DatabaseField
    private String climate;
    /**
     * the ISO 8601 date format of the time that this resource was edited.
     * (Required)
     *
     */
    @DatabaseField(dataType = DataType.DATE_STRING, format = "YYYY-MM-DD'T'hh:mm:ss.SSSZ")
    private Date edited;
    /**
     * An array of Film URL Resources that this planet has appeared in.
     * (Required)
     *
     */
    @ForeignCollectionField
    private Collection<CustomString> films = new ArrayList<>();
    /**
     * The average populationof sentient beings inhabiting this planet.
     * (Required)
     *
     */
    @DatabaseField
    private String population;

    /**
     * An array of DataObject URL Resources that live on this planet.
     * (Required)
     *
     */
    public Collection<CustomString> getResidents() {
        return residents;
    }

    /**
     * An array of DataObject URL Resources that live on this planet.
     * (Required)
     *
     */
    public void setResidents(ArrayList<CustomString> residents) {
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
    public Collection<CustomString> getFilms() {
        return films;
    }

    /**
     * An array of Film URL Resources that this planet has appeared in.
     * (Required)
     *
     */
    public void setFilms(ArrayList<CustomString> films) {
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
