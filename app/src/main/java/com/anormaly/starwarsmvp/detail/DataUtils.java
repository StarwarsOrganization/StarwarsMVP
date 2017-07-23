package com.anormaly.starwarsmvp.detail;

import com.anormaly.starwarsmvp.data.dataobjects.film.source.Film;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.People;
import com.anormaly.starwarsmvp.data.dataobjects.planet.source.Planet;
import com.anormaly.starwarsmvp.data.dataobjects.species.source.Species;
import com.anormaly.starwarsmvp.data.dataobjects.starship.source.Starship;
import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ichigo on 22/07/17.
 */

public class DataUtils
{

    public static List<DataRow> getPeople(People people){
        List<DataRow> rows = new ArrayList<>();
        rows.add(new DataRow("Name",people.getName()));
        rows.add(new DataRow("Height",people.getHeight()));
        rows.add(new DataRow("Eye Color",people.getEyeColor()));
        rows.add(new DataRow("Gender",people.getGender()));
        rows.add(new DataRow("Hair Color",people.getHairColor()));
        rows.add(new DataRow("Mass",people.getMass()));
        rows.add(new DataRow("Skin Color",people.getSkinColor()));
        rows.add(new DataRow("Birth Year",people.getBirthYear()));
        rows.add(new DataRow("Homeworld",people.getHomeworld()));
        return rows;
    }

    public static List<DataRow> getFilm(Film film){
        List<DataRow> rows = new ArrayList<>();
        rows.add(new DataRow("Title",film.getTitle()));
        rows.add(new DataRow("Producer",film.getProducer()));
        rows.add(new DataRow("Episode",film.getEpisodeId()+""));
        rows.add(new DataRow("Opening Crawl",film.getOpeningCrawl()));
        rows.add(new DataRow("Release Date",film.getReleaseDate()));
        rows.add(new DataRow("Director",film.getDirector()));
        return rows;
    }

    public static List<DataRow> getPlanet(Planet planet){
        List<DataRow> rows = new ArrayList<>();
        rows.add(new DataRow("Name",planet.getName()));
        rows.add(new DataRow("Rotation Period",planet.getRotationPeriod()));
        rows.add(new DataRow("Diameter",planet.getDiameter()));
        rows.add(new DataRow("Terrain",planet.getTerrain()));
        rows.add(new DataRow("Orbital Period",planet.getOrbitalPeriod()));
        rows.add(new DataRow("Surface Water",planet.getSurfaceWater()));
        rows.add(new DataRow("Gravity",planet.getGravity()));
        rows.add(new DataRow("Climate",planet.getClimate()));
        rows.add(new DataRow("Population",planet.getPopulation()));
        return rows;
    }

    public static List<DataRow> getSpecies(Species species){
        List<DataRow> rows = new ArrayList<>();
        rows.add(new DataRow("Name",species.getName()));
        rows.add(new DataRow("Classification",species.getClassification()));
        rows.add(new DataRow("Eye Colors",species.getEyeColors()));
        rows.add(new DataRow("Average Lifespan",species.getAverageLifespan()));
        rows.add(new DataRow("Hair Colors",species.getHairColors()));
        rows.add(new DataRow("Language",species.getLanguage()));
        rows.add(new DataRow("Skin Colors",species.getSkinColors()));
        rows.add(new DataRow("Designation",species.getDesignation()));
        rows.add(new DataRow("Average Height",species.getAverageHeight()));
        rows.add(new DataRow("Homeworld",species.getHomeworld()));
        return rows;
    }

    public static List<DataRow> getStarship(Starship starship){
        List<DataRow> rows = new ArrayList<>();
        rows.add(new DataRow("Name",starship.getName()));
        rows.add(new DataRow("Max Atmosphering Pressure",starship.getMaxAtmospheringSpeed()));
        rows.add(new DataRow("Class",starship.getStarshipClass()));
        rows.add(new DataRow("Cost In Credits",starship.getCostInCredits()));
        rows.add(new DataRow("Model",starship.getModel()));
        rows.add(new DataRow("Cargo Capacity",starship.getCargoCapacity()));
        rows.add(new DataRow("Crew",starship.getCrew()));
        rows.add(new DataRow("Length",starship.getLength()));
        rows.add(new DataRow("mGLT",starship.getMGLT()));
        rows.add(new DataRow("Hyperdrive Rating",starship.getHyperdriveRating()));
        rows.add(new DataRow("Consumables",starship.getConsumables()));
        rows.add(new DataRow("Passengers",starship.getPassengers()));
        rows.add(new DataRow("Manufacturer",starship.getManufacturer()));
        return rows;
    }

    public static List<DataRow> getVehicle(Vehicle vehicle){
        List<DataRow> rows = new ArrayList<>();
        rows.add(new DataRow("Name",vehicle.getName()));
        rows.add(new DataRow("Max Atmosphering Speed",vehicle.getMaxAtmospheringSpeed()));
        rows.add(new DataRow("Consumables",vehicle.getConsumables()));
        rows.add(new DataRow("Class",vehicle.getVehicleClass()));
        rows.add(new DataRow("Cost In Credits",vehicle.getCostInCredits()));
        rows.add(new DataRow("Model",vehicle.getModel()));
        rows.add(new DataRow("Cargo Capacity",vehicle.getCargoCapacity()));
        rows.add(new DataRow("Crew",vehicle.getCrew()));
        rows.add(new DataRow("Length",vehicle.getLength()));
        rows.add(new DataRow("Passengers",vehicle.getPassengers()));
        rows.add(new DataRow("Manufacturer",vehicle.getManufacturer()));
        return rows;
    }

    public static List<String> getParent(List<DataRow> rows){
        List<String> list = new ArrayList<>();

        for(DataRow row: rows){
            list.add(row.getTitle());
        }

        return list;
    }

    public static HashMap<String,List<String>> getChild(List<DataRow> rows){
        HashMap<String,List<String>> map = new HashMap<>();

        for(DataRow row: rows){
            List<String> l = new ArrayList<>();
            l.add(row.getField());
            map.put(row.getTitle(),l);
        }

        return map;
    }
}
