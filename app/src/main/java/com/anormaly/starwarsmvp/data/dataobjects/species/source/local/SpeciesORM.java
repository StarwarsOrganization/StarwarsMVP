
package com.anormaly.starwarsmvp.data.dataobjects.species.source.local;

import com.anormaly.starwarsmvp.data.dataobjects.people.source.local.CustomString;
import com.anormaly.starwarsmvp.data.dataobjects.species.source.Species;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.local.ORMUtils;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


/**
 * PeopleORM
 * <p>
 * A species within the Star Wars universe
 * 
 */
public class SpeciesORM
{

    public SpeciesORM()
    {
    }

    public SpeciesORM(Species species)
    {
        this.classification = species.getClassification();
        this.eyeColors = species.getEyeColors();
        this.averageLifespan = species.getAverageLifespan();
        this.hairColors = species.getHairColors();
        this.people = ORMUtils.getStrings(species.getPeople());
        this.created = species.getCreated();
        this.language = species.getLanguage();
        this.skinColors = species.getSkinColors();
        this.designation = species.getDesignation();
        this.name = species.getName();
        this.url = species.getUrl();
        this.averageHeight = species.getAverageHeight();
        this.edited = species.getEdited();
        this.films = ORMUtils.getStrings(species.getFilms());
        this.homeworld = species.getHomeworld();
    }

    public Species getSpecies(){
        return new Species(
                getClassification(),
                getEyeColors(),
                getAverageLifespan(),
                getHairColors(),
                ORMUtils.getList(getPeople()),
                getCreated(),
                getLanguage(),
                getSkinColors(),
                getDesignation(),
                getName(),
                getUrl(),
                getAverageHeight(),
                getEdited(),
                ORMUtils.getList(getFilms()),
                getHomeworld()
        );
    }

    /**
     * The classification of this species.
     * (Required)
     * 
     */
    @DatabaseField
    private String classification;
    /**
     * A comma-seperated string of common eye colors for this species, none if this species does not typically have eyes.
     * (Required)
     * 
     */
    @DatabaseField
    private String eyeColors;
    /**
     * The average lifespan of this species in years.
     * (Required)
     * 
     */
    @DatabaseField
    private String averageLifespan;
    /**
     * A comma-seperated string of common hair colors for this species, none if this species does not typically have hair.
     * (Required)
     * 
     */
    @DatabaseField
    private String hairColors;
    /**
     * An array of PeopleORM URL Resources that are a part of this species.
     * (Required)
     * 
     */
    @ForeignCollectionField
    private Collection<CustomString> people = new ArrayList<>();
    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
     * 
     */
    @DatabaseField(dataType = DataType.DATE_STRING, format = "YYYY-MM-DD'T'hh:mm:ss.SSSZ")
    private Date created;
    /**
     * The language commonly spoken by this species.
     * (Required)
     * 
     */
    @DatabaseField
    private String language;
    /**
     * A comma-seperated string of common skin colors for this species, none if this species does not typically have skin.
     * (Required)
     * 
     */
    @DatabaseField
    private String skinColors;
    /**
     * The designation of this species.
     * (Required)
     * 
     */
    @DatabaseField
    private String designation;
    /**
     * The name of this species.
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
     * The average height of this person in centimeters.
     * (Required)
     * 
     */
    @DatabaseField
    private String averageHeight;
    /**
     * The ISO 8601 date format of the time that this resource was edited.
     * (Required)
     * 
     */
    @DatabaseField(dataType = DataType.DATE_STRING, format = "YYYY-MM-DD'T'hh:mm:ss.SSSZ")
    private Date edited;
    /**
     *  An array of Film URL Resources that this species has appeared in.
     * (Required)
     * 
     */
    @ForeignCollectionField
    private Collection<CustomString> films = new ArrayList<>();
    /**
     * The URL of a planet resource, a planet that this species originates from.
     * (Required)
     * 
     */
    @DatabaseField
    private String homeworld;

    /**
     * The classification of this species.
     * (Required)
     * 
     */
    public String getClassification() {
        return classification;
    }

    /**
     * The classification of this species.
     * (Required)
     * 
     */
    public void setClassification(String classification) {
        this.classification = classification;
    }

    /**
     * A comma-seperated string of common eye colors for this species, none if this species does not typically have eyes.
     * (Required)
     * 
     */
    public String getEyeColors() {
        return eyeColors;
    }

    /**
     * A comma-seperated string of common eye colors for this species, none if this species does not typically have eyes.
     * (Required)
     * 
     */
    public void setEyeColors(String eyeColors) {
        this.eyeColors = eyeColors;
    }

    /**
     * The average lifespan of this species in years.
     * (Required)
     * 
     */
    public String getAverageLifespan() {
        return averageLifespan;
    }

    /**
     * The average lifespan of this species in years.
     * (Required)
     * 
     */
    public void setAverageLifespan(String averageLifespan) {
        this.averageLifespan = averageLifespan;
    }

    /**
     * A comma-seperated string of common hair colors for this species, none if this species does not typically have hair.
     * (Required)
     * 
     */
    public String getHairColors() {
        return hairColors;
    }

    /**
     * A comma-seperated string of common hair colors for this species, none if this species does not typically have hair.
     * (Required)
     * 
     */
    public void setHairColors(String hairColors) {
        this.hairColors = hairColors;
    }

    /**
     * An array of PeopleORM URL Resources that are a part of this species.
     * (Required)
     * 
     */
    public Collection<CustomString> getPeople() {
        return people;
    }

    /**
     * An array of PeopleORM URL Resources that are a part of this species.
     * (Required)
     * 
     */
    public void setPeople(ArrayList<CustomString> people) {
        this.people = people;
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
     * The language commonly spoken by this species.
     * (Required)
     * 
     */
    public String getLanguage() {
        return language;
    }

    /**
     * The language commonly spoken by this species.
     * (Required)
     * 
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * A comma-seperated string of common skin colors for this species, none if this species does not typically have skin.
     * (Required)
     * 
     */
    public String getSkinColors() {
        return skinColors;
    }

    /**
     * A comma-seperated string of common skin colors for this species, none if this species does not typically have skin.
     * (Required)
     * 
     */
    public void setSkinColors(String skinColors) {
        this.skinColors = skinColors;
    }

    /**
     * The designation of this species.
     * (Required)
     * 
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * The designation of this species.
     * (Required)
     * 
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * The name of this species.
     * (Required)
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * The name of this species.
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
     * The average height of this person in centimeters.
     * (Required)
     * 
     */
    public String getAverageHeight() {
        return averageHeight;
    }

    /**
     * The average height of this person in centimeters.
     * (Required)
     * 
     */
    public void setAverageHeight(String averageHeight) {
        this.averageHeight = averageHeight;
    }

    /**
     * The ISO 8601 date format of the time that this resource was edited.
     * (Required)
     * 
     */
    public Date getEdited() {
        return edited;
    }

    /**
     * The ISO 8601 date format of the time that this resource was edited.
     * (Required)
     * 
     */
    public void setEdited(Date edited) {
        this.edited = edited;
    }

    /**
     *  An array of Film URL Resources that this species has appeared in.
     * (Required)
     * 
     */
    public Collection<CustomString> getFilms() {
        return films;
    }

    /**
     *  An array of Film URL Resources that this species has appeared in.
     * (Required)
     * 
     */
    public void setFilms(ArrayList<CustomString> films) {
        this.films = films;
    }

    /**
     * The URL of a planet resource, a planet that this species originates from.
     * (Required)
     * 
     */
    public String getHomeworld() {
        return homeworld;
    }

    /**
     * The URL of a planet resource, a planet that this species originates from.
     * (Required)
     * 
     */
    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

}
