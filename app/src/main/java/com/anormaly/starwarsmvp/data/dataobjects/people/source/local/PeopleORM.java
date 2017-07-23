
package com.anormaly.starwarsmvp.data.dataobjects.people.source.local;

import com.anormaly.starwarsmvp.data.dataobjects.people.source.People;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


/**
 * PeopleORM
 * <p>
 * A person within the Star Wars universe
 */
@DatabaseTable(tableName = "people")
public class PeopleORM
{

    public PeopleORM()
    {
    }

    public PeopleORM(People people){
        this.starships = ORMUtils.getStrings(people.getStarships());
        this.height = people.getHeight();
        this.eyeColor = people.getEyeColor();
        this.gender = people.getGender();
        this.hairColor = people.getHairColor();
        this.mass = people.getMass();
        this.created = people.getCreated();
        this.skinColor = people.getSkinColor();
        this.species = ORMUtils.getStrings(people.getSpecies());
        this.name = people.getName();
        this.url = people.getUrl();
        this.birthYear = people.getBirthYear();
        this.edited = people.getEdited();
        this.films = ORMUtils.getStrings(people.getFilms());
        this.homeworld = people.getHomeworld();
        this.vehicles = ORMUtils.getStrings(people.getVehicles());
    }

    /**
     * An array of starship resources that this person has piloted
     * (Required)
     */

    @ForeignCollectionField
    private Collection<CustomString> starships = null;
    /**
     * The height of this person in meters.
     * (Required)
     */
    @DatabaseField
    private String height;
    /**
     * The eye color of this person.
     * (Required)
     */
    @DatabaseField
    private String eyeColor;
    /**
     * The gender of this person (if known).
     * (Required)
     */
    @DatabaseField
    private String gender;
    /**
     * The hair color of this person.
     * (Required)
     */
    @DatabaseField
    private String hairColor;
    /**
     * The mass of this person in kilograms.
     * (Required)
     */
    @DatabaseField
    private String mass;
    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
     */
    @DatabaseField(dataType = DataType.DATE_STRING, format = "YYYY-MM-DD'T'hh:mm:ss.SSSZ")
    private Date created;
    /**
     * The skin color of this person.
     * (Required)
     */
    @DatabaseField
    private String skinColor;
    /**
     * The url of the species resource that this person is.
     * (Required)
     */
    @ForeignCollectionField
    private Collection<CustomString> species = new ArrayList<>();
    /**
     * The name of this person.
     * (Required)
     */
    @DatabaseField
    private String name;
    /**
     * The url of this resource
     * (Required)
     */
    @DatabaseField(id = true)
    private String url;
    /**
     * The birth year of this person. BBY (Before the Battle of Yavin) or ABY (After the Battle of Yavin).
     * (Required)
     */
    @DatabaseField
    private String birthYear;
    /**
     * the ISO 8601 date format of the time that this resource was edited.
     * (Required)
     */
    @DatabaseField(dataType = DataType.DATE_STRING, format = "YYYY-MM-DD'T'hh:mm:ss.SSSZ")
    private Date edited;
    /**
     * An array of urls of film resources that this person has been in.
     * (Required)
     */
    @ForeignCollectionField
    private Collection<CustomString> films = new ArrayList<>();
    /**
     * The url of the planet resource that this person was born on.
     * (Required)
     */
    @DatabaseField
    private String homeworld;
    /**
     * An array of vehicle resources that this person has piloted
     * (Required)
     */
    @ForeignCollectionField
    private Collection<CustomString> vehicles = new ArrayList<>();

    /**
     * An array of starship resources that this person has piloted
     * (Required)
     */
    public Collection<CustomString> getStarships()
    {
        return starships;
    }

    /**
     * An array of starship resources that this person has piloted
     * (Required)
     */
    public void setStarships(Collection<CustomString> starships)
    {
        this.starships = starships;
    }

    /**
     * The height of this person in meters.
     * (Required)
     */
    public String getHeight()
    {
        return height;
    }

    /**
     * The height of this person in meters.
     * (Required)
     */
    public void setHeight(String height)
    {
        this.height = height;
    }

    /**
     * The eye color of this person.
     * (Required)
     */
    public String getEyeColor()
    {
        return eyeColor;
    }

    /**
     * The eye color of this person.
     * (Required)
     */
    public void setEyeColor(String eyeColor)
    {
        this.eyeColor = eyeColor;
    }

    /**
     * The gender of this person (if known).
     * (Required)
     */
    public String getGender()
    {
        return gender;
    }

    /**
     * The gender of this person (if known).
     * (Required)
     */
    public void setGender(String gender)
    {
        this.gender = gender;
    }

    /**
     * The hair color of this person.
     * (Required)
     */
    public String getHairColor()
    {
        return hairColor;
    }

    /**
     * The hair color of this person.
     * (Required)
     */
    public void setHairColor(String hairColor)
    {
        this.hairColor = hairColor;
    }

    /**
     * The mass of this person in kilograms.
     * (Required)
     */
    public String getMass()
    {
        return mass;
    }

    /**
     * The mass of this person in kilograms.
     * (Required)
     */
    public void setMass(String mass)
    {
        this.mass = mass;
    }

    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
     */
    public Date getCreated()
    {
        return created;
    }

    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
     */
    public void setCreated(Date created)
    {
        this.created = created;
    }

    /**
     * The skin color of this person.
     * (Required)
     */
    public String getSkinColor()
    {
        return skinColor;
    }

    /**
     * The skin color of this person.
     * (Required)
     */
    public void setSkinColor(String skinColor)
    {
        this.skinColor = skinColor;
    }

    /**
     * The url of the species resource that this person is.
     * (Required)
     */
    public Collection<CustomString> getSpecies()
    {
        return species;
    }

    /**
     * The url of the species resource that this person is.
     * (Required)
     */
    public void setSpecies(Collection<CustomString> species)
    {
        this.species = species;
    }

    /**
     * The name of this person.
     * (Required)
     */
    public String getName()
    {
        return name;
    }

    /**
     * The name of this person.
     * (Required)
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * The url of this resource
     * (Required)
     */
    public String getUrl()
    {
        return url;
    }

    /**
     * The url of this resource
     * (Required)
     */
    public void setUrl(String url)
    {
        this.url = url;
    }

    /**
     * The birth year of this person. BBY (Before the Battle of Yavin) or ABY (After the Battle of Yavin).
     * (Required)
     */
    public String getBirthYear()
    {
        return birthYear;
    }

    /**
     * The birth year of this person. BBY (Before the Battle of Yavin) or ABY (After the Battle of Yavin).
     * (Required)
     */
    public void setBirthYear(String birthYear)
    {
        this.birthYear = birthYear;
    }

    /**
     * the ISO 8601 date format of the time that this resource was edited.
     * (Required)
     */
    public Date getEdited()
    {
        return edited;
    }

    /**
     * the ISO 8601 date format of the time that this resource was edited.
     * (Required)
     */
    public void setEdited(Date edited)
    {
        this.edited = edited;
    }

    /**
     * An array of urls of film resources that this person has been in.
     * (Required)
     */
    public Collection<CustomString> getFilms()
    {
        return films;
    }

    /**
     * An array of urls of film resources that this person has been in.
     * (Required)
     */
    public void setFilms(Collection<CustomString> films)
    {
        this.films = films;
    }

    /**
     * The url of the planet resource that this person was born on.
     * (Required)
     */
    public String getHomeworld()
    {
        return homeworld;
    }

    /**
     * The url of the planet resource that this person was born on.
     * (Required)
     */
    public void setHomeworld(String homeworld)
    {
        this.homeworld = homeworld;
    }

    /**
     * An array of vehicle resources that this person has piloted
     * (Required)
     */
    public Collection<CustomString> getVehicles()
    {
        return vehicles;
    }

    /**
     * An array of vehicle resources that this person has piloted
     * (Required)
     */
    public void setVehicles(Collection<CustomString> vehicles)
    {
        this.vehicles = vehicles;
    }


    public People getPeople(){

        return new People(ORMUtils.getList(starships),height,eyeColor,gender,hairColor,mass,created,skinColor,ORMUtils.getList(species),name,url,birthYear,edited,ORMUtils.getList(films),homeworld,ORMUtils.getList(vehicles));
    }

}
