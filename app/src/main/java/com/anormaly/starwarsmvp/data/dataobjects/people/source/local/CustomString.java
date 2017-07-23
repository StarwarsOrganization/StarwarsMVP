package com.anormaly.starwarsmvp.data.dataobjects.people.source.local;


import com.anormaly.starwarsmvp.data.dataobjects.planet.source.local.PlanetORM;
import com.j256.ormlite.field.DatabaseField;

/**
 * Created by ichigo on 12/07/17.
 */

public class CustomString
{

    @DatabaseField(generatedId = true,unique = true)
    private long id;

    @DatabaseField(canBeNull = true,foreign = true)
    private PeopleORM peopleORM;

    @DatabaseField
    private String text;


    public String text()
    {
        return text;
    }


    public CustomString toType(String text)
    {
        return new CustomString(text);
    }

    public CustomString()
    {
    }

    public CustomString(String text)
    {
        this.text = text;
    }


}
