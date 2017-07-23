package com.anormaly.starwarsmvp.data.categories.source.staticds;

import com.anormaly.starwarsmvp.data.dataobjects.DataObject;
import com.anormaly.starwarsmvp.data.categories.source.Category;
import com.anormaly.starwarsmvp.data.categories.source.CategoryDataSource;
import com.anormaly.starwarsmvp.data.dataobjects.film.source.Film;
import com.anormaly.starwarsmvp.data.dataobjects.planet.source.Planet;
import com.anormaly.starwarsmvp.data.dataobjects.species.source.Species;
import com.anormaly.starwarsmvp.data.dataobjects.starship.source.Starship;
import com.anormaly.starwarsmvp.data.dataobjects.vehicle.source.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ichigo on 13/07/17.
 */
public class CategoryStaticDataSource implements CategoryDataSource
{
    private static CategoryStaticDataSource INSTANCE;

    private List<Category> categories = new ArrayList<>();

    private String[] categoriesArray = new String[]{
            "People",
            "Films",
            "Planets",
            "Species",
            "Starships",
            "Vehicles"
    };

    private CategoryStaticDataSource()
    {
        categories.clear();

        categories.add(new Category(PEOPLE_TYPE, categoriesArray[0]));
        categories.add(new Category(FILMS_TYPE, categoriesArray[1]));
        categories.add(new Category(PLANETS_TYPE, categoriesArray[2]));
        categories.add(new Category(SPECIES_TYPE, categoriesArray[3]));
        categories.add(new Category(STARSHIPS_TYPE, categoriesArray[4]));
        categories.add(new Category(VEHICLES_TYPE, categoriesArray[5]));


    }

    public static CategoryStaticDataSource getInstance()
    {
        if (INSTANCE == null) INSTANCE = new CategoryStaticDataSource();
        return INSTANCE;
    }


    @Override
    public void loadCategories(LoadCategoriesCallback callback)
    {
        callback.onCategoriesLoaded(categories);
    }

    @Override
    public void obtainCategoryType(DataObject dataobject, CategoryTypeCallback callback)
    {

        int type = -1;
        if (dataobject instanceof com.anormaly.starwarsmvp.data.dataobjects.people.source.People)
        {
            type = PEOPLE_TYPE;
        } else if (dataobject instanceof Film)
        {
            type = FILMS_TYPE;
        } else if (dataobject instanceof Planet)
        {
            type = PLANETS_TYPE;
        } else if (dataobject instanceof Species)
        {
            type = SPECIES_TYPE;
        } else if (dataobject instanceof Starship)
        {
            type = STARSHIPS_TYPE;
        } else if (dataobject instanceof Vehicle)
        {
            type = VEHICLES_TYPE;
        }

        if (type < 0)
        {
            callback.onCategoryNotFound();
        } else
        {
            callback.onCategoryType(categories.get(type));
        }
    }
}
