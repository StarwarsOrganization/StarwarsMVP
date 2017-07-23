package com.anormaly.starwarsmvp.dataobject;

import com.anormaly.starwarsmvp.data.categories.source.Category;
import com.anormaly.starwarsmvp.data.categories.source.CategoryDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.DataObject;
import com.anormaly.starwarsmvp.data.dataobjects.film.source.Film;
import com.anormaly.starwarsmvp.data.dataobjects.film.source.FilmDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.film.source.FilmRepository;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.People;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.PeopleDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.people.source.PeopleRepository;
import com.anormaly.starwarsmvp.data.dataobjects.planet.source.Planet;
import com.anormaly.starwarsmvp.data.dataobjects.planet.source.PlanetDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.planet.source.PlanetRepository;
import com.anormaly.starwarsmvp.data.dataobjects.species.source.Species;
import com.anormaly.starwarsmvp.data.dataobjects.species.source.SpeciesDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.species.source.SpeciesRepository;
import com.anormaly.starwarsmvp.data.dataobjects.starship.source.Starship;
import com.anormaly.starwarsmvp.data.dataobjects.starship.source.StarshipDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.starship.source.StarshipRepository;
import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.Vehicle;
import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.VehicleDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.VehicleRepository;

import java.util.List;

/**
 * Created by ichigo on 13/07/17.
 */

public class DataObjectPresenter implements DataObjectContract.Presenter
{
    private final DataObjectContract.View mView;
    private final PeopleRepository mPeopleRepository;
    private PlanetDataSource mPlanetRepository;
    private SpeciesRepository mSpeciesRepository;
    private StarshipDataSource mStarshipRepository;
    private VehicleDataSource mVehicleRepository;
    private FilmDataSource mFilmRepository;

    public DataObjectPresenter(DataObjectContract.View view, PeopleRepository peopleRepository, PlanetRepository planetRepository, SpeciesRepository speciesRepository, StarshipRepository starshipRepository, VehicleRepository vehicleRepository, FilmRepository filmRepository)
    {
        mView = view;
        mPeopleRepository = peopleRepository;
        mPlanetRepository = planetRepository;
        mSpeciesRepository = speciesRepository;
        mStarshipRepository = starshipRepository;
        mVehicleRepository = vehicleRepository;
        mFilmRepository = filmRepository;
        mView.setPresenter(this);
    }


    @Override
    public void start()
    {

    }

    @Override
    public void initializeViews()
    {
        mView.bindButterknife();
        mView.initializeRecylerView();
    }

    @Override
    public void showList()
    {

    }


    @Override
    public void loadDataObjectList(Category category)
    {
        switch (category.getId()){

            case CategoryDataSource.FILMS_TYPE:
                mFilmRepository.loadFilms(new FilmDataSource.LoadFilmCallback()
                {
                    @Override
                    public void onFilmLoaded(List<Film> films)
                    {
                        mView.setDataObjects(films);
                    }

                    @Override
                    public void onDataNotAvailable()
                    {
                        mView.setEmptyDataView();
                    }
                });
                break;
            case CategoryDataSource.PEOPLE_TYPE:
                mPeopleRepository.loadPeoples(new PeopleDataSource.LoadPeopleCallback()
                {
                    @Override
                    public void onPeopleLoaded(List<People> peoples)
                    {
                        mView.setDataObjects(peoples);
                    }

                    @Override
                    public void onDataNotAvailable()
                    {
                        mView.setEmptyDataView();
                    }
                });
                break;
            case CategoryDataSource.PLANETS_TYPE:
                mPlanetRepository.loadPlanets(new PlanetDataSource.LoadPlanetCallback()
                {
                    @Override
                    public void onPlanetLoaded(List<Planet> planets)
                    {
                        mView.setDataObjects(planets);
                    }

                    @Override
                    public void onDataNotAvailable()
                    {
                        mView.setEmptyDataView();
                    }
                });
                break;
            case CategoryDataSource.SPECIES_TYPE:
                mSpeciesRepository.loadSpecies(new SpeciesDataSource.LoadSpeciesCallback()
                {
                    @Override
                    public void onSpeciesLoaded(List<Species> speciess)
                    {
                        mView.setDataObjects(speciess);
                    }

                    @Override
                    public void onDataNotAvailable()
                    {
                        mView.setEmptyDataView();
                    }
                });
                break;
            case CategoryDataSource.STARSHIPS_TYPE:
                mStarshipRepository.loadStarships(new StarshipDataSource.LoadStarshipsCallback()
                {
                    @Override
                    public void onStarshipLoaded(List<Starship> starships)
                    {
                        mView.setDataObjects(starships);
                    }

                    @Override
                    public void onDataNotAvailable()
                    {
                        mView.setEmptyDataView();
                    }
                });
                break;
            case CategoryDataSource.VEHICLES_TYPE:
                mVehicleRepository.loadVehicles(new VehicleDataSource.LoadVehicleCallback()
                {
                    @Override
                    public void onVehicleLoaded(List<Vehicle> vehicles)
                    {
                        mView.setDataObjects(vehicles);
                    }

                    @Override
                    public void onDataNotAvailable()
                    {
                        mView.setEmptyDataView();
                    }
                });
                break;
            default:

                break;


        }
    }

    @Override
    public void selectedDataObject(DataObject dataObject)
    {
        mView.navigateToDetail(dataObject);
    }
}
