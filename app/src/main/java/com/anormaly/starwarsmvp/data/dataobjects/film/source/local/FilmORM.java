
package com.anormaly.starwarsmvp.data.dataobjects.film.source.local;

import com.anormaly.starwarsmvp.data.dataobjects.people.source.local.CustomString;
import com.anormaly.starwarsmvp.data.dataobjects.film.source.Film;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.local.ORMUtils;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


/**
 * Film
 * <p>
 * A Star Wars film
 * 
 */
public class FilmORM
{

    public FilmORM()
    {
    }

    public FilmORM(Film film)
    {
        this.starships = ORMUtils.getStrings(film.getStarships());
        this.producer = film.getProducer();
        this.episodeId = film.getEpisodeId();
        this.openingCrawl = film.getOpeningCrawl();
        this.created = film.getCreated();
        this.releaseDate = film.getReleaseDate();
        this.url = film.getUrl();
        this.director = film.getUrl();
        this.vehicles = ORMUtils.getStrings(film.getVehicles());
        this.planets = ORMUtils.getStrings(film.getPlanets());
        this.title = film.getTitle();
        this.characters = ORMUtils.getStrings(film.getCharacters());
        this.edited = film.getEdited();
        this.species = ORMUtils.getStrings(film.getSpecies());
    }

    public Film getFilm(){
        return new Film(
                ORMUtils.getList(getStarships()),
                getProducer(),
                getEpisodeId(),
                getOpeningCrawl(),
                getCreated(),
                getReleaseDate(),
                getUrl(),
                getDirector(),
                ORMUtils.getList(getVehicles()),
                ORMUtils.getList(getPlanets()),
                getTitle(),
                ORMUtils.getList(getCharacters()),
                getEdited(),
                ORMUtils.getList(getSpecies())
        );
    }

    /**
     * The starship resources featured within this film.
     * (Required)
     * 
     */
    @ForeignCollectionField
    private Collection<CustomString> starships = new ArrayList<>();
    /**
     * The producer(s) of this film.
     * (Required)
     * 
     */
    @DatabaseField
    private String producer;
    /**
     * The episode number of this film.
     * (Required)
     * 
     */
    @DatabaseField
    private Integer episodeId;
    /**
     * The opening crawl text at the beginning of this film.
     * (Required)
     * 
     */
    @DatabaseField
    private String openingCrawl;
    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
     * 
     */
    @DatabaseField(dataType = DataType.DATE_STRING, format = "YYYY-MM-DD'T'hh:mm:ss.SSSZ")
    private Date created;
    /**
     * The release date at original creator country.
     * (Required)
     * 
     */
    @DatabaseField
    private String releaseDate;
    /**
     * The url of this resource
     * (Required)
     * 
     */
    @DatabaseField(id = true)
    private String url;
    /**
     * The director of this film.
     * (Required)
     * 
     */
    @DatabaseField
    private String director;
    /**
     * The vehicle resources featured within this film.
     * (Required)
     * 
     */
    @ForeignCollectionField
    private Collection<CustomString> vehicles = new ArrayList<>();
    /**
     * The planet resources featured within this film.
     * (Required)
     * 
     */
    @ForeignCollectionField
    private Collection<CustomString> planets = null;
    /**
     * The title of this film.
     * (Required)
     * 
     */
    @DatabaseField
    private String title;
    /**
     * The people resources featured within this film.
     * (Required)
     * 
     */
    @ForeignCollectionField
    private Collection<CustomString> characters = new ArrayList<>();
    /**
     * the ISO 8601 date format of the time that this resource was edited.
     * (Required)
     * 
     */
    @DatabaseField(dataType = DataType.DATE_STRING, format = "YYYY-MM-DD'T'hh:mm:ss.SSSZ")
    private Date edited;
    /**
     * The species resources featured within this film.
     * (Required)
     * 
     */
    @ForeignCollectionField
    private Collection<CustomString> species = new ArrayList<>();

    /**
     * The starship resources featured within this film.
     * (Required)
     * 
     */
    public Collection<CustomString> getStarships() {
        return starships;
    }

    /**
     * The starship resources featured within this film.
     * (Required)
     * 
     */
    public void setStarships(ArrayList<CustomString> starships) {
        this.starships = starships;
    }

    /**
     * The producer(s) of this film.
     * (Required)
     * 
     */
    public String getProducer() {
        return producer;
    }

    /**
     * The producer(s) of this film.
     * (Required)
     * 
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }

    /**
     * The episode number of this film.
     * (Required)
     * 
     */
    public Integer getEpisodeId() {
        return episodeId;
    }

    /**
     * The episode number of this film.
     * (Required)
     * 
     */
    public void setEpisodeId(Integer episodeId) {
        this.episodeId = episodeId;
    }

    /**
     * The opening crawl text at the beginning of this film.
     * (Required)
     * 
     */
    public String getOpeningCrawl() {
        return openingCrawl;
    }

    /**
     * The opening crawl text at the beginning of this film.
     * (Required)
     * 
     */
    public void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
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
     * The release date at original creator country.
     * (Required)
     * 
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * The release date at original creator country.
     * (Required)
     * 
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
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
     * The director of this film.
     * (Required)
     * 
     */
    public String getDirector() {
        return director;
    }

    /**
     * The director of this film.
     * (Required)
     * 
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * The vehicle resources featured within this film.
     * (Required)
     * 
     */
    public Collection<CustomString> getVehicles() {
        return vehicles;
    }

    /**
     * The vehicle resources featured within this film.
     * (Required)
     * 
     */
    public void setVehicles(ArrayList<CustomString> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * The planet resources featured within this film.
     * (Required)
     * 
     */
    public Collection<CustomString> getPlanets() {
        return planets;
    }

    /**
     * The planet resources featured within this film.
     * (Required)
     * 
     */
    public void setPlanets(ArrayList<CustomString> planets) {
        this.planets = planets;
    }

    /**
     * The title of this film.
     * (Required)
     * 
     */
    public String getTitle() {
        return title;
    }

    /**
     * The title of this film.
     * (Required)
     * 
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * The people resources featured within this film.
     * (Required)
     * 
     */
    public Collection<CustomString> getCharacters() {
        return characters;
    }

    /**
     * The people resources featured within this film.
     * (Required)
     * 
     */
    public void setCharacters(ArrayList<CustomString> characters) {
        this.characters = characters;
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
     * The species resources featured within this film.
     * (Required)
     * 
     */
    public Collection<CustomString> getSpecies() {
        return species;
    }

    /**
     * The species resources featured within this film.
     * (Required)
     * 
     */
    public void setSpecies(ArrayList<CustomString> species) {
        this.species = species;
    }

}
