
package com.anormaly.starwarsmvp.data.dataobjects.film.source;

import java.util.ArrayList;
import java.util.Date;

import com.anormaly.starwarsmvp.data.dataobjects.DataObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Film
 * <p>
 * A Star Wars film
 * 
 */
public class Film implements DataObject
{

    public Film()
    {
    }

    public Film(ArrayList<String> starships, String producer, Integer episodeId, String openingCrawl, Date created, String releaseDate, String url, String director, ArrayList<String> vehicles, ArrayList<String> planets, String title, ArrayList<String> characters, Date edited, ArrayList<String> species)
    {
        this.starships = starships;
        this.producer = producer;
        this.episodeId = episodeId;
        this.openingCrawl = openingCrawl;
        this.created = created;
        this.releaseDate = releaseDate;
        this.url = url;
        this.director = director;
        this.vehicles = vehicles;
        this.planets = planets;
        this.title = title;
        this.characters = characters;
        this.edited = edited;
        this.species = species;
    }


    /**
     * The starship resources featured within this film.
     * (Required)
     * 
     */
    @SerializedName("starships")
    @Expose
    private ArrayList<String> starships =new ArrayList<>();
    /**
     * The producer(s) of this film.
     * (Required)
     * 
     */
    @SerializedName("producer")
    @Expose
    private String producer;
    /**
     * The episode number of this film.
     * (Required)
     * 
     */
    @SerializedName("episode_id")
    @Expose
    private Integer episodeId;
    /**
     * The opening crawl text at the beginning of this film.
     * (Required)
     * 
     */
    @SerializedName("opening_crawl")
    @Expose
    private String openingCrawl;
    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
     * 
     */
    @SerializedName("created")
    @Expose
    private Date created;
    /**
     * The release date at original creator country.
     * (Required)
     * 
     */
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    /**
     * The url of this resource
     * (Required)
     * 
     */
    @SerializedName("url")
    @Expose
    private String url;
    /**
     * The director of this film.
     * (Required)
     * 
     */
    @SerializedName("director")
    @Expose
    private String director;
    /**
     * The vehicle resources featured within this film.
     * (Required)
     * 
     */
    @SerializedName("vehicles")
    @Expose
    private ArrayList<String> vehicles = null;
    /**
     * The planet resources featured within this film.
     * (Required)
     * 
     */
    @SerializedName("planets")
    @Expose
    private ArrayList<String> planets = null;
    /**
     * The title of this film.
     * (Required)
     * 
     */
    @SerializedName("title")
    @Expose
    private String title;
    /**
     * The people resources featured within this film.
     * (Required)
     * 
     */
    @SerializedName("characters")
    @Expose
    private ArrayList<String> characters = null;
    /**
     * the ISO 8601 date format of the time that this resource was edited.
     * (Required)
     * 
     */
    @SerializedName("edited")
    @Expose
    private Date edited;
    /**
     * The species resources featured within this film.
     * (Required)
     * 
     */
    @SerializedName("species")
    @Expose
    private ArrayList<String> species = null;

    /**
     * The starship resources featured within this film.
     * (Required)
     * 
     */
    public ArrayList<String> getStarships() {
        return starships;
    }

    /**
     * The starship resources featured within this film.
     * (Required)
     * 
     */
    public void setStarships(ArrayList<String> starships) {
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
    public ArrayList<String> getVehicles() {
        return vehicles;
    }

    /**
     * The vehicle resources featured within this film.
     * (Required)
     * 
     */
    public void setVehicles(ArrayList<String> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * The planet resources featured within this film.
     * (Required)
     * 
     */
    public ArrayList<String> getPlanets() {
        return planets;
    }

    /**
     * The planet resources featured within this film.
     * (Required)
     * 
     */
    public void setPlanets(ArrayList<String> planets) {
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
    public ArrayList<String> getCharacters() {
        return characters;
    }

    /**
     * The people resources featured within this film.
     * (Required)
     * 
     */
    public void setCharacters(ArrayList<String> characters) {
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
    public ArrayList<String> getSpecies() {
        return species;
    }

    /**
     * The species resources featured within this film.
     * (Required)
     * 
     */
    public void setSpecies(ArrayList<String> species) {
        this.species = species;
    }

}
