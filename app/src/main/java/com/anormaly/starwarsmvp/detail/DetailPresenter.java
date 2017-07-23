package com.anormaly.starwarsmvp.detail;

import com.anormaly.starwarsmvp.data.categories.source.Category;
import com.anormaly.starwarsmvp.data.categories.source.CategoryDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.DataObject;
import com.anormaly.starwarsmvp.data.dataobjects.film.source.Film;
import com.anormaly.starwarsmvp.data.dataobjects.planet.source.Planet;
import com.anormaly.starwarsmvp.data.dataobjects.species.source.Species;
import com.anormaly.starwarsmvp.data.dataobjects.starship.source.Starship;
import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.Vehicle;

import java.util.List;

/**
 * Created by ichigo on 22/07/17.
 */

public class DetailPresenter implements DetailContract.Presenter
{

    private final DetailContract.View mView;

    public DetailPresenter(DetailContract.View view)
    {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start()
    {
    }

    @Override
    public void initializeViews()
    {
        mView.bindViews();
        initData();


    }

    @Override
    public void initData()
    {
        mView.loadData();

    }

    @Override
    public void convertData(DataObject mDataObject, Category mCategory)
    {
        List<DataRow> rows= null;
        switch (mCategory.getId()){

            case CategoryDataSource.FILMS_TYPE:
                rows = DataUtils.getFilm((Film) mDataObject);
                break;
            case CategoryDataSource.PEOPLE_TYPE:
                rows = DataUtils.getPeople((com.anormaly.starwarsmvp.data.dataobjects.people.source.People) mDataObject);
                break;
            case CategoryDataSource.PLANETS_TYPE:
                rows = DataUtils.getPlanet((Planet) mDataObject);
                break;
            case CategoryDataSource.SPECIES_TYPE:
                rows = DataUtils.getSpecies((Species) mDataObject);
                break;
            case CategoryDataSource.STARSHIPS_TYPE:
                rows = DataUtils.getStarship((Starship) mDataObject);
                break;
            case CategoryDataSource.VEHICLES_TYPE:
                rows = DataUtils.getVehicle((Vehicle) mDataObject);
                break;
            default:

                break;


        }
        if(rows!=null){
            mView.initAdapter(rows);
        }else{

        }
    }
}
