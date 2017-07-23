
package com.anormaly.starwarsmvp.data.dataobjects.people.source;

import java.util.ArrayList;
import java.util.Date;

import com.anormaly.starwarsmvp.data.dataobjects.DataObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * PeopleORM
 * <p>
 * A person within the Star Wars universe
 * 
 */
public class People implements DataObject
{

    /**
     * An array of starship resources that this person has piloted
     * (Required)
     * 
     */
    @SerializedName("starships")
    @Expose
    private ArrayList<String> starships = null;
    /**
     * The height of this person in meters.
     * (Required)
     * 
     */
    @SerializedName("height")
    @Expose
    private String height;
    /**
     * The eye color of this person.
     * (Required)
     * 
     */
    @SerializedName("eye_color")
    @Expose
    private String eyeColor;
    /**
     * The gender of this person (if known).
     * (Required)
     * 
     */
    @SerializedName("gender")
    @Expose
    private String gender;
    /**
     * The hair color of this person.
     * (Required)
     * 
     */
    @SerializedName("hair_color")
    @Expose
    private String hairColor;
    /**
     * The mass of this person in kilograms.
     * (Required)
     * 
     */
    @SerializedName("mass")
    @Expose
    private String mass;
    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
     * 
     */
    @SerializedName("created")
    @Expose
    private Date created;
    /**
     * The skin color of this person.
     * (Required)
     * 
     */
    @SerializedName("skin_color")
    @Expose
    private String skinColor;
    /**
     * The url of the species resource that this person is.
     * (Required)
     * 
     */
    @SerializedName("species")
    @Expose
    private ArrayList<String> species = null;
    /**
     * The name of this person.
     * (Required)
     * 
     */
    @SerializedName("name")
    @Expose
    private String name;
    /**
     * The url of this resource
     * (Required)
     * 
     */
    @SerializedName("url")
    @Expose
    private String url;
    /**
     * The birth year of this person. BBY (Before the Battle of Yavin) or ABY (After the Battle of Yavin).
     * (Required)
     * 
     */
    @SerializedName("birth_year")
    @Expose
    private String birthYear;
    /**
     * the ISO 8601 date format of the time that this resource was edited.
     * (Required)
     * 
     */
    @SerializedName("edited")
    @Expose
    private Date edited;
    /**
     * An array of urls of film resources that this person has been in.
     * (Required)
     * 
     */
    @SerializedName("films")
    @Expose
    private ArrayList<String> films = null;
    /**
     * The url of the planet resource that this person was born on.
     * (Required)
     * 
     */
    @SerializedName("homeworld")
    @Expose
    private String homeworld;
    /**
     * An array of vehicle resources that this person has piloted
     * (Required)
     * 
     */
    @SerializedName("vehicles")
    @Expose
    private ArrayList<String> vehicles = null;

    public People(ArrayList<String> starships, String height, String eyeColor, String gender, String hairColor, String mass, Date created, String skinColor, ArrayList<String> species, String name, String url, String birthYear, Date edited, ArrayList<String> films, String homeworld, ArrayList<String> vehicles)
    {
        this.starships = starships;
        this.height = height;
        this.eyeColor = eyeColor;
        this.gender = gender;
        this.hairColor = hairColor;
        this.mass = mass;
        this.created = created;
        this.skinColor = skinColor;
        this.species = species;
        this.name = name;
        this.url = url;
        this.birthYear = birthYear;
        this.edited = edited;
        this.films = films;
        this.homeworld = homeworld;
        this.vehicles = vehicles;
    }

    public People(){}

    /**
     * An array of starship resources that this person has piloted
     * (Required)
     * 
     */
    public ArrayList<String> getStarships() {
        return starships;
    }

    /**
     * An array of starship resources that this person has piloted
     * (Required)
     * 
     */
    public void setStarships(ArrayList<String> starships) {
        this.starships = starships;
    }

    /**
     * The height of this person in meters.
     * (Required)
     * 
     */
    public String getHeight() {
        return height;
    }

    /**
     * The height of this person in meters.
     * (Required)
     * 
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * The eye color of this person.
     * (Required)
     * 
     */
    public String getEyeColor() {
        return eyeColor;
    }

    /**
     * The eye color of this person.
     * (Required)
     * 
     */
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * The gender of this person (if known).
     * (Required)
     * 
     */
    public String getGender() {
        return gender;
    }

    /**
     * The gender of this person (if known).
     * (Required)
     * 
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * The hair color of this person.
     * (Required)
     * 
     */
    public String getHairColor() {
        return hairColor;
    }

    /**
     * The hair color of this person.
     * (Required)
     * 
     */
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * The mass of this person in kilograms.
     * (Required)
     * 
     */
    public String getMass() {
        return mass;
    }

    /**
     * The mass of this person in kilograms.
     * (Required)
     * 
     */
    public void setMass(String mass) {
        this.mass = mass;
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
     * The skin color of this person.
     * (Required)
     * 
     */
    public String getSkinColor() {
        return skinColor;
    }

    /**
     * The skin color of this person.
     * (Required)
     * 
     */
    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    /**
     * The url of the species resource that this person is.
     * (Required)
     * 
     */
    public ArrayList<String> getSpecies() {
        return species;
    }

    /**
     * The url of the species resource that this person is.
     * (Required)
     * 
     */
    public void setSpecies(ArrayList<String> species) {
        this.species = species;
    }

    /**
     * The name of this person.
     * (Required)
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * The name of this person.
     * (Required)
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The url of this resource
     * (Required)
     * 
     */
    public String getUrl() {
        return url;
    }

    /**
     * The url of this resource
     * (Required)
     * 
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * The birth year of this person. BBY (Before the Battle of Yavin) or ABY (After the Battle of Yavin).
     * (Required)
     * 
     */
    public String getBirthYear() {
        return birthYear;
    }

    /**
     * The birth year of this person. BBY (Before the Battle of Yavin) or ABY (After the Battle of Yavin).
     * (Required)
     * 
     */
    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
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
     * An array of urls of film resources that this person has been in.
     * (Required)
     * 
     */
    public ArrayList<String> getFilms() {
        return films;
    }

    /**
     * An array of urls of film resources that this person has been in.
     * (Required)
     * 
     */
    public void setFilms(ArrayList<String> films) {
        this.films = films;
    }

    /**
     * The url of the planet resource that this person was born on.
     * (Required)
     * 
     */
    public String getHomeworld() {
        return homeworld;
    }

    /**
     * The url of the planet resource that this person was born on.
     * (Required)
     * 
     */
    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    /**
     * An array of vehicle resources that this person has piloted
     * (Required)
     * 
     */
    public ArrayList<String> getVehicles() {
        return vehicles;
    }

    /**
     * An array of vehicle resources that this person has piloted
     * (Required)
     * 
     */
    public void setVehicles(ArrayList<String> vehicles) {
        this.vehicles = vehicles;
    }

}
