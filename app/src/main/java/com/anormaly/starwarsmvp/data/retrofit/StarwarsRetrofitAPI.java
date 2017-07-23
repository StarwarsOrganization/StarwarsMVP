package com.anormaly.starwarsmvp.data.retrofit;

import com.anormaly.starwarsmvp.data.dataobjects.DataObjectList;
import com.anormaly.starwarsmvp.data.dataobjects.film.source.Film;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.People;
import com.anormaly.starwarsmvp.data.dataobjects.planet.source.Planet;
import com.anormaly.starwarsmvp.data.dataobjects.species.source.Species;
import com.anormaly.starwarsmvp.data.dataobjects.starship.source.Starship;
import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.Vehicle;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ichigo on 12/07/17.
 */

public interface StarwarsRetrofitAPI
{
    @GET("people")
    Call<DataObjectList<People>> getPeoples(@Query("query") String query,@Query("page") int page);

    @GET("people/{id}")
    Call<People> getPeople(@Path("id") int id);


    @GET("starships")
    Call<DataObjectList<Starship>> getStarships(@Query("query") String query);

    @GET("starships/{id}")
    Call<Starship> getStarship(@Path("id") int id);


    @GET("vehicles")
    Call<DataObjectList<Vehicle>> getVehicles(@Query("query") String query);

    @GET("vehicles/{id}")
    Call<Vehicle> getVehicle(@Path("id") int id);


    @GET("planets")
    Call<DataObjectList<Planet>> getPlanets(@Query("query") String query);

    @GET("planets/{id}")
    Call<Planet> getPlanet(@Path("id") int id);


    @GET("species")
    Call<DataObjectList<Species>> getSpecies(@Query("query") String query);

    @GET("species/{id}")
    Call<Species> getSpecie(@Path("id") int id);


    @GET("films")
    Call<DataObjectList<Film>> getFilms(@Query("query") String query);

    @GET("films/{id}")
    Call<Film> getFilm(@Path("id") int id);
}
