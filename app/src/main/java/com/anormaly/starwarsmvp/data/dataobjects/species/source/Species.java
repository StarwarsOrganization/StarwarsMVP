
package com.anormaly.starwarsmvp.data.dataobjects.species.source;

import com.anormaly.starwarsmvp.data.dataobjects.DataObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;


/**
 * PeopleORM
 * <p>
 * A species within the Star Wars universe
 * 
 */
public class Species implements DataObject
{

    public Species()
    {
    }

    public Species(String classification, String eyeColors, String averageLifespan, String hairColors, ArrayList<String> people, Date created, String language, String skinColors, String designation, String name, String url, String averageHeight, Date edited, ArrayList<String> films, String homeworld)
    {
        this.classification = classification;
        this.eyeColors = eyeColors;
        this.averageLifespan = averageLifespan;
        this.hairColors = hairColors;
        this.people = people;
        this.created = created;
        this.language = language;
        this.skinColors = skinColors;
        this.designation = designation;
        this.name = name;
        this.url = url;
        this.averageHeight = averageHeight;
        this.edited = edited;
        this.films = films;
        this.homeworld = homeworld;
    }

    /**
     * The classification of this species.
     * (Required)
     * 
     */
    @SerializedName("classification")
    @Expose
    private String classification;
    /**
     * A comma-seperated string of common eye colors for this species, none if this species does not typically have eyes.
     * (Required)
     * 
     */
    @SerializedName("eye_colors")
    @Expose
    private String eyeColors;
    /**
     * The average lifespan of this species in years.
     * (Required)
     * 
     */
    @SerializedName("average_lifespan")
    @Expose
    private String averageLifespan;
    /**
     * A comma-seperated string of common hair colors for this species, none if this species does not typically have hair.
     * (Required)
     * 
     */
    @SerializedName("hair_colors")
    @Expose
    private String hairColors;
    /**
     * An array of PeopleORM URL Resources that are a part of this species.
     * (Required)
     * 
     */
    @SerializedName("people")
    @Expose
    private ArrayList<String> people = null;
    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
     * 
     */
    @SerializedName("created")
    @Expose
    private Date created;
    /**
     * The language commonly spoken by this species.
     * (Required)
     * 
     */
    @SerializedName("language")
    @Expose
    private String language;
    /**
     * A comma-seperated string of common skin colors for this species, none if this species does not typically have skin.
     * (Required)
     * 
     */
    @SerializedName("skin_colors")
    @Expose
    private String skinColors;
    /**
     * The designation of this species.
     * (Required)
     * 
     */
    @SerializedName("designation")
    @Expose
    private String designation;
    /**
     * The name of this species.
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
     * The average height of this person in centimeters.
     * (Required)
     * 
     */
    @SerializedName("average_height")
    @Expose
    private String averageHeight;
    /**
     * The ISO 8601 date format of the time that this resource was edited.
     * (Required)
     * 
     */
    @SerializedName("edited")
    @Expose
    private Date edited;
    /**
     *  An array of Film URL Resources that this species has appeared in.
     * (Required)
     * 
     */
    @SerializedName("films")
    @Expose
    private ArrayList<String> films = null;
    /**
     * The URL of a planet resource, a planet that this species originates from.
     * (Required)
     * 
     */
    @SerializedName("homeworld")
    @Expose
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
    public ArrayList<String> getPeople() {
        return people;
    }

    /**
     * An array of PeopleORM URL Resources that are a part of this species.
     * (Required)
     * 
     */
    public void setPeople(ArrayList<String> people) {
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
    public ArrayList<String> getFilms() {
        return films;
    }

    /**
     *  An array of Film URL Resources that this species has appeared in.
     * (Required)
     * 
     */
    public void setFilms(ArrayList<String> films) {
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
